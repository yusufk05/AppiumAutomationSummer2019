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











    }
}
