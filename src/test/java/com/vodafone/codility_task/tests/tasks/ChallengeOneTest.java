package com.vodafone.codility_task.tests.tasks;


import com.vodafone.codility_task.driver.Driver;
import com.vodafone.codility_task.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.vodafone.codility_task.driver.Driver.getBrowserName;
import static com.vodafone.codility_task.driver.Driver.getChallengeOnePath;

public class ChallengeOneTest {
    protected WebDriver driver ;
    @BeforeMethod(alwaysRun = true)
    protected void setUp() throws IOException {
        Driver.initDriver(getBrowserName(),getChallengeOnePath());
        driver = DriverManager.getWebDriver();
    }

    @Test
    public void verifyUsernameAndNickNameAreWorkCorrectly() {
    }
    @Test
    public void verifyInformativeMessageWithInvalidEmail() {
    }
    @Test
    public void verifyInformativeMessageWithInvalidNickName() throws InterruptedException {
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        Driver.closeDriver();
    }

}
