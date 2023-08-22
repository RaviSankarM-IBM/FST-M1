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

public class orangeHRM_testNG_Activity4 {


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

        //Assertion for page title
        //Assert.assertEquals("OrangeHRM", title);

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
        //Assert.assertEquals("OrangeHRM", hometitle);

    }

    @Test
    public void TestCase4() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("OrangeHRM", title);

        //String urlimg = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/img")).getAttribute("src");
        //System.out.println("URL of the Image is: " + urlimg);

        // Find the username and password fields
        WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
        //WebElement username = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/input"));
        //      /html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]
        //      /html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[2]/input
        //WebElement username = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/svg/switch/g/path[5]"));
        //WebElement username = driver.findElement(By.xpath("//*[@id=\"divLoginImage\"]/svg/switch/g/path[5]"));
        //driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/svg/switch/g/path[5]"));

        //*[@id="divLoginImage"]/svg/switch/g/path[5]
        WebElement employeelist = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        //WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[3]/input"));
        // Enter the credentials
        //username.click();
        pim.click();
        employeelist.click();
        // Find and click the submit button
        driver.findElement(By.id("btnAdd")).click();
        //driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[5]/input")).click();
        //WebElement Login = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/svg/switch/g/g[4]/path"));
        //Login.click();

        WebElement firstname = driver.findElement(By.id("firstName"));
        WebElement lastname = driver.findElement(By.id("lastName"));
        firstname.sendKeys("EmpFstNm2");
        lastname.sendKeys("EmpLstNm2");

        driver.findElement(By.id("btnSave")).click();

        //WebElement pim1 = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]"));
        WebElement pim1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a"));
        pim1.click();

        //List<WebElement> FstName = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/thead/tr/th[3]/a"));
        //WebElement empsearch = driver.findElement(By.name("empsearch[employee_name][empName]"));
        //WebElement emplist = driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/ul/li[2]/a"));
        WebElement emplist = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewEmployeeList\"]"));
        emplist.click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //WebElement empsearch = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[1]/input[1]"));
        WebElement empsearch = driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]"));
        empsearch.click();
        //empsearch.clear();
        //empsearch.sendKeys(Keys.BACK_SPACE);
        //empsearch.click();
        empsearch.sendKeys("EmpFstNm2");

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //driver.findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();
        WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/p/input[1]"));
        //WebElement search = driver.findElement(By.xpath("//*[@id=\"searchBtn\"]"));
        //WebElement search = driver.findElement(By.id("searchBtn"));
        search.click();
        //search.click();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement fstnamevalue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[3]/a"));
        //WebElement fstnamevalue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr/td[3]/a"));
        System.out.println("Employee First Name " + fstnamevalue.getText());


        WebElement lstnamevalue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[4]/a"));
        //WebElement lstnamevalue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr/td[4]/a"));
        System.out.println("Employee Last Name " + lstnamevalue.getText());

        Assert.assertEquals("EmpFstNm2", fstnamevalue.getText());
        Assert.assertEquals("EmpLstNm2", lstnamevalue.getText());

        //String hometitle = driver.getTitle();

        //Print the title of the page
        //System.out.println("Home Page title after login is: " + hometitle);

        //Assertion for page title
        //Assert.assertEquals("OrangeHRM", hometitle);

    }

    @AfterMethod
    public void afterMethod() {
      //Close the browser
       driver.quit();
    }
}
