package com.automation.tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Day2 {

    private AndroidDriver<MobileElement> driver;

    @Before
    public void setup(){
        DesiredCapabilities desiredCapabilities =new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir") + "/api_demos.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        try{
            driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void teardown(){
        driver.closeApp();
    }

    @Test
    public void test() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Views")));

        driver.findElement(MobileBy.AccessibilityId("Views")).click();

        MobileElement webview = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().textContains(\"WebView\"));"));
        webview.click();

        driver.navigate().back();

        MobileElement imageSwitcher = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().textContains(\"imageSwitcher\"));"));
        imageSwitcher.click();

        TouchAction touchAction = new TouchAction(driver);

        //to tap on element
        //you can chain actions like in Actions class
        //so you can tap twice
        //drag and drop: long press then move to target --> build().perform()
        touchAction.tap(new ElementOption().withElement(imageSwitcher)).perform();
    }
}
