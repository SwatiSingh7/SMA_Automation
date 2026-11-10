package com.morrisons.common.utility;

import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ConfigLoader {

	private static final String ENV_KEY = "xxwmm_env";
	private static final Map<String, String> envSpecificConfig = new HashMap<String, String>();

	static {
		envSpecificConfig.put("dev", "application_DEV.yml");
		envSpecificConfig.put("cit", "application_CIT.yml");
		envSpecificConfig.put("sit", "application_SIT.yml");
		envSpecificConfig.put("uat", "application_UAT.yml");
		envSpecificConfig.put("pre", "application_PRE.yml");
		envSpecificConfig.put("prod", "application_PROD.yml");
		envSpecificConfig.put("local", "application_LOCAL.yml");
	}

	private ApplicationConfig applicationConfig;

	public ConfigLoader() {
		applicationConfig = new Yaml().loadAs(
				ApplicationConfig.class.getClassLoader().getResourceAsStream(
						envSpecificConfig.get(System.getenv(ENV_KEY) != null ? System.getenv(ENV_KEY) : "sit")),
				ApplicationConfig.class);
	}

	public ApplicationConfig getConfig() {
		return applicationConfig;
	}
}
