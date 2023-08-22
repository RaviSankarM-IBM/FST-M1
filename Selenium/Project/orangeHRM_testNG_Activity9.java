import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class orangeHRM_testNG_Activity9 {


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
    public void TestCase9(){

        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("OrangeHRM", title);

        WebElement MyInfo = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]"));
        MyInfo.click();
        MyInfo.click();

        //WebElement emergencycontactslist = driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[3]/a"));
        WebElement emergencycontactslist = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a"));
        emergencycontactslist.click();

        List<WebElement> table = driver.findElements(By.xpath("//*[@id=\"emgcontact_list\"]"));
        System.out.println("Table row cell values: ");
        for(WebElement cell : table) {
            System.out.println(cell.getText());
        }




    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}



