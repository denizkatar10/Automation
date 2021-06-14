package com.techproed.smoketest;
import com.techproed.pages.PositiveTestPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class PositiveTest {

    PositiveTestPage positiveTestPage = new PositiveTestPage();


    @Test
    public void positiveTest() throws InterruptedException {
//        Go to teh applicaiton URL
//        Go to the login page
//        Send username password
//        click on login button
//        find a core object in the default login page
//        And verify if the log in successful
//        MAKE SURE TO USE PAGE OBJECT MODEL
//        - page class: LoginPage
//
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));

        positiveTestPage.logInButton.click();
        Thread.sleep(500);
        positiveTestPage.username.sendKeys(ConfigReader.getProperty("admin_username"));
        positiveTestPage.password.sendKeys(ConfigReader.getProperty("admin_password"));
        positiveTestPage.logIn.click();

        Assert.assertTrue(positiveTestPage.listOfUsers.isDisplayed());

    }

}