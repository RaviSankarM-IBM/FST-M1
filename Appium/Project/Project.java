package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Project {

    AndroidDriver driver;

    WebDriverWait wait;
    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.nexuslauncher");
        options.setAppActivity(".NexusLauncherActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://v1.training-support.net/selenium");

    }

    @Test
    public void WebAppTest() throws InterruptedException{

        Dimension dims = driver.manage().window().getSize();

        Point start = new Point(((int) (dims.getWidth() * 0.5 )), (int) (dims.getHeight() * 0.8));
        Point end = new Point(((int) (dims.getWidth() * 0.5 )), (int) (dims.getHeight() * 0.6));

        //W3CActionsBase.doSwipe(driver, start, end, 200);
        W3CActionsBase.doSwipe(driver, start, end, 200);

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.TextView[contains(@text,'To-Do-List')]"))).click();


        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("tasksCard"))).click();

        WebElement Task = driver.findElement(AppiumBy.id("taskInput"));

        //Task.click();
        Task.sendKeys("Task1");
        Task.click();

        //id:android.widget.Button
        WebElement AddTaskButton = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[1]/android.widget.Button"));

        AddTaskButton.click();

        //Check the count of Task lists
        List<WebElement> TaskCount = driver.findElements(AppiumBy.id("tasksList"));

        System.out.println("The number of Tasks Entered: " + TaskCount);

        Assert.assertEquals(TaskCount.size(), "1");

        //Strike the Task
        WebElement EnteredTask = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View/android.view.View"));
        EnteredTask.click();

        //Clear Task
        WebElement ClearTask = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[3]"));
        ClearTask.click();

        Assert.assertNotEquals(Task, EnteredTask);

    }

    @AfterClass
    public void WebAppClose(){
        driver.quit();
    }

}
