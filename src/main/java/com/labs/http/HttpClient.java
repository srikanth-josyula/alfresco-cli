package com.labs.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class HttpClient {
	
	@Autowired
	RestTemplate restTemlet;
	
	@Value("${content.service.download.path}")
	String downloadUrl;

	public void downloadContent() {
	
		restTemlet.execute(null, null, null, null);
	}
}
