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


public class orangeHRM_testNG_Activity5 {

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
    public void TestCase5(){

        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("OrangeHRM", title);

        WebElement myinfo = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]"));
        myinfo.click();
        myinfo.click();

        WebElement edit = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
        edit.click();

        WebElement fstname = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]"));
        fstname.clear();
        fstname.sendKeys("First Name Edited");

        WebElement lstname = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpLastName\"]"));
        lstname.clear();
        lstname.sendKeys("Last Name Edited");

        //Gender

        WebElement Nationality = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/form/fieldset/ol[3]/li[3]/select"));
        Nationality.click();
        Nationality.sendKeys("Indian");
        Nationality.sendKeys(Keys.ENTER);

        //WebElement DOB = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/form/fieldset/ol[3]/li[4]/input"));
        WebElement DOB = driver.findElement(By.xpath("//*[@id=\"personal_DOB\"]"));
        DOB.clear();
        DOB.sendKeys("1982-01-01");

        WebElement save = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
        save.click();


    }
    @AfterMethod
    public void afterMethod() {
    //Close the browser
      driver.quit();
     }


}
