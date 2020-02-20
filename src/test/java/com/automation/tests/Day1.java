package com.automation.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Day1 {

    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws Exception{
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //since we use android, put android. could be IOS
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        //version of your device
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "7.0");
        //name of the device
        //if it's a real device, you need to use udid parameter
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        //either you can specify app --> //path/to/the/appp.apk
        //or, if app is already installed, you need to specify appActivity and AppPackage
        //this info you can find in the internet, at work - from developers
        //otherwise, you can use apk info app to find this information
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        // Set your application's package name.
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        // Set your application's MainActivity i.e. the LAUNCHER activity name.

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //"http://localhost:4723/wd/hub" - address of the appium server. If you have appium server on the same computer - just use localhost
        //4723 - default appium port.
        //we need to provide 2 parameters: URL of appium servers and desired capabilities
        // in desired capabilities we specify device and  application to test information
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        Thread.sleep(3000);

        MobileElement digit2 = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        MobileElement digit4 = driver.findElement(By.id("com.android.calculator2:id/digit_4"));
        MobileElement digit6 = driver.findElement(By.id("com.android.calculator2:id/digit_6"));
        MobileElement digit7 = driver.findElement(By.id("com.android.calculator2:id/digit_7"));


        //MobileBy - is a child class of By
        MobileElement plus = driver.findElement(MobileBy.AccessibilityId("plus"));
        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));
        MobileElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
        MobileElement multiply = driver.findElement(MobileBy.AccessibilityId("multiply"));
        MobileElement divide = driver.findElement(MobileBy.AccessibilityId("divide"));
        MobileElement minus = driver.findElement(MobileBy.AccessibilityId("minus"));


        digit2.click();//click on digit 2
        plus.click();//click on plus
        digit2.click();//click on digit 2
        equals.click();//click on equals

        String resultText = result.getText();//read the text of result
        Assert.assertEquals("4", resultText);//assert that result is equals to 4

        //4 * 5 = 20
        getDigit(4).click();
        multiply.click();
        getDigit(5).click();
        equals.click();

        resultText = result.getText();//read the text of result
        Assert.assertEquals("20", resultText);

        //8/4=2
        getDigit(8).click();
        divide.click();
        getDigit(4).click();
        equals.click();

        resultText = result.getText();//read the text of result
        Assert.assertEquals("2", resultText);

        //50 - 20 = 30
        getDigit(5).click();
        getDigit(0).click();
        minus.click();

        getDigit(2).click();
        getDigit(0).click();
        equals.click();

        resultText = result.getText();//read the text of result
        Assert.assertEquals("30", resultText);

        driver.closeApp();
    }

    @Test
    public void test2() throws Exception{
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //to specify app for testing.
        //it can be on your computer or somewhere in cloud
        desiredCapabilities.setCapability("app", "https://cybertek-appium.s3.amazonaws.com/etsy.apk");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(10000);                    //com.etsy.android:id/search_src_text
        MobileElement search = driver.findElement(By.id("com.etsy.android:id/search_src_text"));


        search.click();
        search.sendKeys("Java");

        Thread.sleep(5000);

        driver.getKeyboard().pressKey(Keys.ENTER);

        Thread.sleep(5000);

        driver.closeApp();
    }




    public MobileElement getDigit(int digit) {
        return driver.findElement(By.id("com.android.calculator2:id/digit_" + digit));
    }
}
