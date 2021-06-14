package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;

public class PositiveTestPage {
    public PositiveTestPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Log in")
        public WebElement logInButton;
    @FindBy(name = "UserName")
    public WebElement username;
    @FindBy(name = "Password")
    public WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement logIn;
    @FindBy(className = "portlet-body")
    public WebElement listOfUsers;

}
