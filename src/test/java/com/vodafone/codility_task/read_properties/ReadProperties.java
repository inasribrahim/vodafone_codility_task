package com.vodafone.codility_task.read_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private ReadProperties(){}
    private static final String ROOT_PATH = System.getProperty("user.dir")
                                                    .concat("/src/test/resources/");
    private static final String AUTOMATION_CHALLENGES_CONFIG_PATH =ROOT_PATH.concat("automation_config.properties");
    public static Properties setAutomationChallengeConfig() throws  IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(AUTOMATION_CHALLENGES_CONFIG_PATH);
        configProperties.load(inputStream);
        return configProperties;
    }
}
