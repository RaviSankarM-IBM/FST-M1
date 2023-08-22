import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class orangeHRM_testNG_Activity3 {

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
    public void TestCase3() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("OrangeHRM", title);

        //String urlimg = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/img")).getAttribute("src");
        //System.out.println("URL of the Image is: " + urlimg);

        // Find the username and password fields
        WebElement username = driver.findElement(By.id("txtUsername"));
        //WebElement username = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/input"));
        //      /html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]
          //      /html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/input
        //WebElement username = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/svg/switch/g/path[5]"));
        //WebElement username = driver.findElement(By.xpath("//*[@id=\"divLoginImage\"]/svg/switch/g/path[5]"));
        //driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/svg/switch/g/path[5]"));

        //*[@id="divLoginImage"]/svg/switch/g/path[5]
        WebElement password = driver.findElement(By.id("txtPassword"));
        //WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[3]/input"));
        // Enter the credentials
        //username.click();
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        // Find and click the submit button
        driver.findElement(By.id("btnLogin")).click();
        //driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[5]/input")).click();
        //WebElement Login = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/svg/switch/g/g[4]/path"));
        //Login.click();

        String hometitle = driver.getTitle();

        //Print the title of the page
        System.out.println("Home Page title after login is: " + hometitle);

        //Assertion for page title
        Assert.assertEquals("OrangeHRM", hometitle);

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
      driver.quit();
    }


}
