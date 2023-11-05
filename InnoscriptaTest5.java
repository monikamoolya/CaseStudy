package Pack;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
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

public class InnoscriptaTest5 {
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
    		report = new ExtentReports(System.getProperty("C:\\Users\\monika.moolya\\Downloads\\")+"ExtentReportTest5Results.html");
    		test = report.startTest("InnoscriptoTest5");
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
       
       // Locate the search input field and enter a search query
       WebElement searchInput = driver.findElement(By.id("js--search-option"));
       searchInput.sendKeys("Regulator");
       test.log(LogStatus.INFO, "Search for Regulator Product");
       searchInput.sendKeys(Keys.RETURN);
       driver.findElement(By.id("go-to-search-page")).click();
       test.log(LogStatus.PASS, "Regulator Products are available");
       
       driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/div[1]/div/div/div[1]/p/a")).click();
      Thread.sleep(3000);
      test.log(LogStatus.INFO, "Clicked on Categories");

     driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[1]/a")).click();
     WebElement hoverButton = driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/div[1]/div/div/div[2]/ul/li[1]/a"));

     // Create an Actions object
     Actions actions = new Actions(driver);

     // Hover over the button to trigger the menu
     actions.moveToElement(hoverButton).perform();

     // Locate and interact with submenu elements (e.g., click on menu items)
     WebElement menuOption1 = driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/div[1]/div/div/div[2]/ul/li[1]/div/a[1]"));
     menuOption1.click();
     test.log(LogStatus.PASS, "Accessories products are available of Connector");
   WebElement product = driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/div[2]/div[2]/div/div[1]/div/a[2]/div"));
    System.out.println(product.getText());
      
    driver.findElement(By.id("browse-filter")).click();
    test.log(LogStatus.INFO, "Sorting the filter values ");
    WebElement dropdownElement = driver.findElement(By.id("browse-filter"));

    // Create a Select object for the dropdown
    Select dropdown = new Select(dropdownElement);

    // Select an option by value
    dropdown.selectByValue("PRICE_ASC");
    test.log(LogStatus.PASS, "Sorted with Price- Low to High ");

       }
    


    @After
    public void tearDown() throws InterruptedException {
    	Thread.sleep(3000);
    	report.endTest(test);
    	report.flush();
       //driver.quit();
    }
}