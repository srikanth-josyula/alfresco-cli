package com.labs.model;

//Singleton to Store Configuration Data
public class ConfigStore {

	private static ConfigStore instance;
	private ConfigModel configModel;

	private ConfigStore() {
	}

	public static ConfigStore getInstance() {
		if (instance == null) {
			instance = new ConfigStore();
		}
		return instance;
	}

	public ConfigModel getConfigModel() {
		return configModel;
	}

	public void setConfigModel(ConfigModel configModel) {
		this.configModel = configModel;
	}
}
