import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class orangeHRM_testNG_Activity6 {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {


        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");

        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        // Find the username and password fields
        WebElement username = driver.findElement(By.id("txtUsername"));

        WebElement password = driver.findElement(By.id("txtPassword"));

        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        // Find and click the submit button
        driver.findElement(By.id("btnLogin")).click();

        String hometitle = driver.getTitle();

        //Print the title of the page
        System.out.println("Home Page title after login is: " + hometitle);

        //Assertion for page title
        //Assert.assertEquals("OrangeHRM", hometitle);

    }

    @Test
    public void TestCase6(){

        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("OrangeHRM", title);

        WebElement Directory = driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]"));
        Directory.isDisplayed();
        Assert.assertTrue(Directory.isDisplayed(), "Directory Menu is Displayed");
        //System.out.println("Directory is Displayed: ", Directory.isDisplayed());
        Directory.isEnabled();
        Assert.assertTrue(Directory.isEnabled(), "Directory Menu is Enabled");
        Directory.click();
        Directory.click();

        String pageheading = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/h1")).getText();
        System.out.println("Page Heading: " + pageheading);
        Assert.assertEquals("Search Directory", pageheading);

    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
      driver.quit();
    }

}
