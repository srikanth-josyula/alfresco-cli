package com.labs.model;

public class ConfigModel {
	private String alfrescoUrl;
	private String base64Credentials;

	public ConfigModel(String alfrescoUrl, String base64Credentials) {
		this.alfrescoUrl = alfrescoUrl;
		this.base64Credentials = base64Credentials;
	}

	// Getters and setters
	public String getAlfrescoUrl() {
		return alfrescoUrl;
	}

	public void setAlfrescoUrl(String alfrescoUrl) {
		this.alfrescoUrl = alfrescoUrl;
	}

	public String getBase64Credentials() {
		return base64Credentials;
	}

	public void setBase64Credentials(String base64Credentials) {
		this.base64Credentials = base64Credentials;
	}

	@Override
	public String toString() {
		return "ConfigModel{" + "alfrescoUrl='" + alfrescoUrl + '\'' + ", base64Credentials='" + base64Credentials
				+ '\'' + '}';
	}
}
