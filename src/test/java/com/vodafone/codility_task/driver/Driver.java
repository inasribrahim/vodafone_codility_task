package com.vodafone.codility_task.driver;

import com.vodafone.codility_task.read_properties.ReadProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;


public final class Driver {
    private Driver(){}
    public static void initDriver(String browserName,String challengeKey){
        String challengePaths = System.getProperty("user.dir")
                .concat("/src/test/resources/web_automation_challenges/");

        if (isNull(DriverManager.getWebDriver())){
            if(browserName.equalsIgnoreCase("chrome")){
                  ChromeOptions options = new ChromeOptions();
                  System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		          options.addArguments("--headless");
		          options.addArguments("--disable-gpu");
		          options.addArguments("--no-sandbox");
		          options.addArguments("--disable-dev-shm-usage");
                  DriverManager.setWebDriver(new ChromeDriver(options));
            }
            DriverManager.getWebDriver().navigate().to(challengePaths.concat(challengeKey));
        }
    }
    public static void closeDriver(){
        if(isNotNull(DriverManager.getWebDriver())){
            DriverManager.getWebDriver().quit();
            DriverManager.unLoad();
        }
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNotNull(Object object) {
        return object != null;
    }

    public static String getChallengeOnePath() throws IOException {
            return ReadProperties.setAutomationChallengeConfig().getProperty("challengeOnePath");
    }
    public static String getChallengeTwoPath() throws IOException {
        return ReadProperties.setAutomationChallengeConfig().getProperty("challengeTwoPath");
    }
    public static String getChallengeThreePath() throws IOException {
        return ReadProperties.setAutomationChallengeConfig().getProperty("challengeThreePath");
    }
    public static String getChallengeFourPath() throws IOException {
        return ReadProperties.setAutomationChallengeConfig().getProperty("challengeFourPath");
    }

    public static String getBrowserName() throws IOException {
        return ReadProperties.setAutomationChallengeConfig().getProperty("browserName");
    }
}
