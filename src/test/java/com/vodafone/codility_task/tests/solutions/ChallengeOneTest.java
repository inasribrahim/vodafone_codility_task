    package com.vodafone.codility_task.tests.solutions;


    import com.vodafone.codility_task.driver.Driver;
    import com.vodafone.codility_task.driver.DriverManager;
    import org.openqa.selenium.*;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.support.ui.*;
    import org.testng.Assert;
    import org.testng.annotations.*;

    import java.io.IOException;
    import java.time.Duration;

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
           driver.findElement(By.id("email")).sendKeys("ibrahim@yahoo.com");
           driver.findElement(By.id("nickname")).sendKeys("hima");
           driver.findElement(By.xpath("//button[@type='submit']")).click();
            
           Assert.assertTrue(driver.switchTo().alert().getText().contains("ibrahim@yahoo.com"));
        }
        @Test
        public void verifyInformativeMessageWithInvalidEmail() {
            driver.findElement(By.id("email")).sendKeys("ibrahimyahoo.com");
            String emailError = driver.findElement(By.id("emailError")).getText();
            Assert.assertEquals("Please enter a valid email address.",emailError);
        }
        
        @Test
        public void verifyInformativeMessageWithInvalidNickName() throws InterruptedException {
            driver.findElement(By.id("nickname")).sendKeys("ss2");
            String nickNameError = driver.findElement(By.id("nicknameError")).getText();
            Assert.assertEquals("Nickname cannot contain numbers.",nickNameError);
        }

        @AfterMethod(alwaysRun = true)
        protected void tearDown() {
            Driver.closeDriver();
        }

    }
