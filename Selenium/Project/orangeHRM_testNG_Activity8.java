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

public class orangeHRM_testNG_Activity8 {


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
    public void TestCase8(){

        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("OrangeHRM", title);

        WebElement pageheading = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1"));
        String Heading = pageheading.getText();
        System.out.println("Page Title is: " + Heading);

        Assert.assertEquals("Dashboard", Heading);

        WebElement ApplyLeave = driver.findElement(By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[4]/div/a/img"));
        ApplyLeave.click();
        ApplyLeave.click();

        // Find the dropdown
        WebElement LeaveTypeDropDown = driver.findElement(By.xpath("//*[@id=\"applyleave_txtLeaveType\"]"));

        // Pass the WebElement to the Select object
        Select singleSelect = new Select(LeaveTypeDropDown);

        singleSelect.selectByIndex(1);
        // Select the second option using visible text
        //singleSelect.selectByVisibleText("Option 2");
        // Print the selected option
        System.out.println("Selected Leave option: " + singleSelect.getFirstSelectedOption().getText());
        String SelectedLeaveType = singleSelect.getFirstSelectedOption().getText();
        Assert.assertEquals("DayOff", SelectedLeaveType);

        WebElement LeaveFromDate = driver.findElement(By.xpath("//*[@id=\"applyleave_txtFromDate\"]"));
        LeaveFromDate.clear();
        LeaveFromDate.sendKeys("2023-08-23");

        WebElement LeaveToDate = driver.findElement(By.xpath("//*[@id=\"applyleave_txtToDate\"]"));
        LeaveToDate.clear();
        LeaveToDate.sendKeys("2023-08-23");

        WebElement ApplyLeavebtn = driver.findElement(By.xpath("//*[@id=\"applyBtn\"]"));
        ApplyLeavebtn.click();

        WebElement LeaveMenu = driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]"));
        LeaveMenu.click();

        WebElement MyLeave = driver.findElement(By.xpath("//*[@id=\"menu_leave_viewMyLeaveList\"]"));
        MyLeave.click();

        WebElement SearchFromDate = driver.findElement(By.xpath("//*[@id=\"calFromDate\"]"));
        SearchFromDate.clear();
        SearchFromDate.sendKeys("2023-08-23");

        WebElement SearchToDate = driver.findElement(By.xpath("//*[@id=\"calToDate\"]"));
        SearchToDate.clear();
        SearchToDate.sendKeys("2023-08-23");

        WebElement Search = driver.findElement(By.xpath("//*[@id=\"btnSearch\"]"));
        Search.click();

        WebElement LeaveStatus = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[6]/a"));
        System.out.println("Leave Status: " +LeaveStatus.getText());
        String AppliedLeaveStatus = LeaveStatus.getText();
        Assert.assertEquals("Pending Approval(1.00)", AppliedLeaveStatus);

    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}

