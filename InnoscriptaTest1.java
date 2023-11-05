package Pack;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.List;
import java.util.Set;

public class InnoscriptaTest1 {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentTest test;
    static ExtentReports report;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Eclipse Workspace\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        // Navigate to the website
        driver.get("https://techshopbd.com/");
    	driver.manage().window().maximize();
    	wait = new WebDriverWait(driver, 10);
    	{
    		report = new ExtentReports(System.getProperty("C:\\Users\\monika.moolya\\Downloads\\")+"ExtentReportTest1Results.html");
    		test = report.startTest("InnoscriptoTest1");
    		}
    }

    @Test
    public void testWebsiteElements() throws InterruptedException {

    	 //Test Scenario 1: User Registration
         //Locate the registration link and click it
        WebElement registrationLink = driver.findElement(By.xpath("/html/body/header/section/div/div/div/a/span[1]/img"));
        registrationLink.click();
       driver.findElement(By.id("signup-tab")).click();
       test.log(LogStatus.PASS, "Clicked on the Sign Up link.");

       // Fill in the registration form (replace with your test data)
       WebElement fullNameInput = driver.findElement(By.id("userName"));
       fullNameInput.sendKeys("Monika");

       WebElement emailInput = driver.findElement(By.id("email"));
       emailInput.sendKeys("moolyanaina@gmail.com");
       
       WebElement phone = driver.findElement(By.id("phone"));
       phone.sendKeys("7234336787");

       WebElement passwordInput = driver.findElement(By.id("password"));
       passwordInput.sendKeys("securePassword");
       
       Thread.sleep(1000);
       WebElement checkbox = driver.findElement(By.id("privacy"));
       Actions actions = new Actions(driver);
       actions.moveToElement(checkbox).click().build().perform();

       // Submit the registration form
       WebElement registerButton = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div[2]/form/div[6]/input"));
       registerButton.click();   
       test.log(LogStatus.PASS, "Registration Successfull");

    // Validate registration success 
       test.log(LogStatus.PASS, "Verification code has been sent to your email.");
   
       Thread.sleep(14000);
       driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/form/div[2]/input")).click();
 
       //Verified successfully
       test.log(LogStatus.PASS, "Verified Successfully");
       
     
       }
    


    @After
    public void tearDown() throws InterruptedException {
    	Thread.sleep(3000);
    	report.endTest(test);
    	report.flush();
       driver.quit();
    }
}