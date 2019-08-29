package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.interactions.Actions;

public class TestAppium {

	public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
 
    //Elements
    String secondNewJob = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
            "android.widget.RelativeLayout/android.widget.ImageView";
 
    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus 5X API 24");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0");
        //caps.setCapability("skipUnlock","true");
        caps.setCapability("app","C:\\Users\\williamr\\AppData\\Local\\Android\\Sdk\\platform-tools\\TripAdvisor v29.4.1.apk");
       //caps.setCapability("appPackage", "com.isinolsun.app");
        //caps.setCapability("appActivity","com.isinolsun.app.activities.SplashActivity");
        //caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }
 
 
    @Test
    public void basicTest () throws InterruptedException {
        //Click and pass Splash
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.tripadvisor.tripadvisor:id/generic_onboarding_cta"))).click();
 
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.tripadvisor.tripadvisor:id/login_skip"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.tripadvisor.tripadvisor:id/button"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.android.packageinstaller:id/permission_allow_button"))).click();
        
       // Thread.sleep(15000);
       
       /* TouchActions action = new TouchActions(driver);
        action.move(200,200).release();*/
        
        /*TouchActions action = new TouchActions(driver);*/
       // MobileElement element = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.ImageView"));
        /*action.scroll(element, 10, 100);
        action.perform();*/
       

       // new Actions(driver).clickAndHold(element).perform();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.tripadvisor.tripadvisor:id/header_title")));
        
        scrollDown();

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.ImageView"))).click();

        

        

        //Click I am searching a job
        /*wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.isinolsun.app:id/bluecollar_type_button"))).click();*/
 
 
        //Notification Allow
       /* if (driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).size()>0) {
            driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).get(0).click();
        }
 
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(secondNewJob)));*/
        
        Thread.sleep(10000);
    }
 
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    
    public void scrollDown()  {

        //The viewing size of the device
        Dimension size = driver.manage().window().getSize();

        //x position set to mid-screen horizontally
        int width = size.width / 2;

        //Starting y location set to 80% of the height (near bottom)
        int startPoint = (int) (size.getHeight() * 0.80);

        //Ending y location set to 20% of the height (near top)
        int endPoint = (int) (size.getHeight() * 0.20);

        new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint)).release().perform();

    }
}
