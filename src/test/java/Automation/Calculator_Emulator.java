package Automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator_Emulator {
    public AndroidDriver driver;
    @BeforeMethod
    public void setUp() throws MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        System.out.println("Start Automation");
    }
    @Test
    public void calculation() throws InterruptedException {
        WebElement five = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        five.click();
        Thread.sleep(2000);
        WebElement plus = driver.findElement(AppiumBy.accessibilityId("plus"));
        plus.click();
        WebElement two = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        two.click();
        WebElement equal = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"equals\"]"));
        equal.click();
    }
}
