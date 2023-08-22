import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class orangeHRM_testNG_Activity2 {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void TestCase2() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("OrangeHRM", title);

        //String urlimg = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).getText();
        //System.out.println(urlimg);

        String urlimg = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/img")).getAttribute("src");
        System.out.println("URL of the Image is: " + urlimg);


    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}

