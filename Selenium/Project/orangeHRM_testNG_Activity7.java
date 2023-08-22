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

public class orangeHRM_testNG_Activity7 {


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
    public void TestCase7(){

        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("OrangeHRM", title);

        WebElement MyInfo = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]"));
        MyInfo.click();
        MyInfo.click();

        WebElement Qualification = driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[9]/a"));
        Qualification.click();

        WebElement Add = driver.findElement(By.xpath("//*[@id=\"addWorkExperience\"]"));
        Add.click();

        WebElement Company = driver.findElement(By.xpath("//*[@id=\"experience_employer\"]"));
        Company.click();
        Company.sendKeys("Company1");

        WebElement JobTitle = driver.findElement(By.xpath("//*[@id=\"experience_jobtitle\"]"));
        JobTitle.click();
        JobTitle.sendKeys("Job Title1");

        WebElement Save = driver.findElement(By.xpath("//*[@id=\"btnWorkExpSave\"]"));
        Save.click();

    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
      driver.quit();
    }

}
