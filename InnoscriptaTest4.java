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

public class InnoscriptaTest4 {
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
    		report = new ExtentReports(System.getProperty("C:\\Users\\monika.moolya\\Downloads\\")+"ExtentReportTest4Results.html");
    		test = report.startTest("InnoscriptoTest4");
    		}
    }

    @Test
    public void testWebsiteElements() throws InterruptedException {

    	
       
       // Test Scenario 2: User Login
       // Locate the login link and click it
       WebElement loginLink = driver.findElement(By.linkText("Login"));
       loginLink.click();

       // Fill in the login form
       WebElement emailLoginInput = driver.findElement(By.name("username"));
       emailLoginInput.sendKeys("moolyanaina@gmail.com");

       WebElement passwordLoginInput = driver.findElement(By.name("password"));
       passwordLoginInput.sendKeys("Hello2465");
       
       // Submit the login form
       WebElement loginButton = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div[1]/form/div[4]/input"));
       loginButton.click();
       test.log(LogStatus.PASS, "User Logged In Successfully");
       
       //Log Out
       driver.findElement(By.xpath("/html/body/header/section/div/div/div[2]/a/span[1]/img")).click();
       driver.findElement(By.xpath("/html/body/header/section/div/div/div[2]/div/a[2]/form/input[2]")).click();
       test.log(LogStatus.PASS, "User Logged Out Successfully");

       }
    


    @After
    public void tearDown() throws InterruptedException {
    	Thread.sleep(3000);
    	report.endTest(test);
    	report.flush();
       driver.quit();
    }
}