package com.techproed.JSExecutor;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSUtils;
import org.apache.xmlbeans.impl.jam.JamUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Day15_JSExecutorTest {
    JavascriptExecutor je=(JavascriptExecutor) Driver.getDriver();
    @Test
    public void scrollIntoViewTest() throws InterruptedException {
        /*
         * Given user is on the application url
         * Then verify the text "Recent Blog" is on the page
         * */
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
        Thread.sleep(1000);
        WebElement recentBlog=Driver.getDriver().findElement(By.xpath("//*[.='Recent Blog']"));
        je.executeScript("arguments[0].scrollIntoView(true);",recentBlog);
        Thread.sleep(3000);
        Assert.assertTrue(recentBlog.isDisplayed());
    }

    @Test
    public void scrollWothCoordinates() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
        WebElement recentBlog=Driver.getDriver().findElement(By.xpath("//*[.='Recent Blog']"));
        Point coordinates = recentBlog.getLocation();
        System.out.println(coordinates.toString());
        je.executeScript("window.scrollBy(0,"+coordinates.y+");");
        Thread.sleep(2000);
        Assert.assertEquals(recentBlog.getText(), "Recent Blog");
    }
    @Test
    public void flashingButton(){
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
        WebElement checkAvailibilityButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.changeColor("black" , checkAvailibilityButton);
        JSUtils.flash(checkAvailibilityButton);
    }
    @Test
    public void scrollIntoViewUtils() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
        WebElement recentBlog=Driver.getDriver().findElement(By.xpath("//*[.='Recent Blog']"));
        JSUtils.scrollIntoVIewJS(recentBlog);
        Thread.sleep(4000);
        Assert.assertEquals(recentBlog.getText(), "Recent Blog");
    }


}
