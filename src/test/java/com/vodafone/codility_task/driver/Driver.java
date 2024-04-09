package com.vodafone.codility_task.driver;

import com.vodafone.codility_task.read_properties.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;


public final class Driver {
    private Driver(){}
    public static void initDriver(String browserName,String challengeKey){
        String challengePaths = System.getProperty("user.dir")
                .concat("/src/test/resources/web_automation_challenges/");
       try {
        if(browserName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.setAcceptInsecureCerts(true);
            DriverManager.setWebDriver(new ChromeDriver(options));
        }
        WebDriver driver = DriverManager.getWebDriver();
        String htmlContent = "";
            try {
                htmlContent = Files.readString(Paths.get(challengePaths.concat(challengeKey)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        driver.get("data:text/html;charset=utf-8,"+htmlContent);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains(challengeKey)); // Adjust condition as needed
    } catch (Exception e) {
        e.printStackTrace(); 
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
