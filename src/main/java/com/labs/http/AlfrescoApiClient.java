package com.labs.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlfrescoApiClient {

	@Autowired
	RestTemplate restTemplate;

	@Value("${content.service.path}")
	String servicePath;

	public void downloadContent(String hostname, String nodeId, String encodedAuth, String downloadPath) {

		String downloadurl = "https://" + hostname + "/" + servicePath + "/nodes/" + nodeId
				+ "/content?attachment=true";

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/octet-stream");
		headers.set("Authorization", "Basic " + encodedAuth);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<byte[]> response = restTemplate.exchange(downloadurl, HttpMethod.GET, entity, byte[].class,
				nodeId);

		// Extract the content (response body)
		byte[] content = response.getBody();
		if (content != null) {
			
			// Define the output file path
			File outputFile = Paths.get(downloadPath).toFile();

			// Save the content to the specified path
			try (FileOutputStream fos = new FileOutputStream(outputFile)) {
				fos.write(content);
				System.out.println("Content downloaded successfully to " + downloadPath);
			} catch (IOException e) {
				System.err.println("Failed to save the content to " + downloadPath);
			}
		} else {
			System.err.println("No content received from the server.");
		}
	}
}
