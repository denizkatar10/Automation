package com.techproed.WorkStation;

import com.techproed.pages.Day11_DefaultPage;
import com.techproed.pages.Day11_LoginPage;
import com.techproed.pages.Day12_HotelRoomPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Scanner;

public class Day13_workingOnExcel {
    Day11_LoginPage loginPage;
    Day11_DefaultPage defaultPage;
    Day12_HotelRoomPage hotelRoomPage;
    //Login teh application:
    @BeforeMethod
    public void setUp(){
        loginPage= new Day11_LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("application_login_url"));
        loginPage.username.sendKeys(ConfigReader.getProperty("admin_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("admin_password"));
        loginPage.loginButton.click();
//        Checking if the login is successful
        defaultPage=new Day11_DefaultPage();
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());
        //Click on Hotel Management
        defaultPage.hotelManagement.click();
//Click on Hotel Rooms
        defaultPage.hotelRooms.click();
//Click on Add Hotel Room
        hotelRoomPage=new Day12_HotelRoomPage();
    }

        /*
Create a method: BeforeMethod to log in the app and navigate to hotel rooms page
Log in  https://qa-environment.resortsline.com/Account/Logon
Click on Hotel Management
Click on Hotel Rooms
Create a test method: entireTable() and Find the size of the entire table body and print all of headers
Create a test method: printRows() and Print all of the rows and print the elements on the 4th row
Create a test method: printCells() and a the total number of cells in the table body and print all of the cells
Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 6th column
Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column
*/

    //Create a test method: entireTable() and Find the size of the entire table body and print all of headers
    @Test
    public void entireTable(){

        List<WebElement> entireBody = Driver.getDriver().findElements(By.xpath("//tbody"));
        System.out.println("table size " + entireBody.size());
        List<WebElement> allHeaders = Driver.getDriver().findElements(By.xpath("//th"));
        for (WebElement eachHeaders:allHeaders){
            System.out.println("Headers = " + eachHeaders.getText());
        }
        System.out.println("Number of headers = " + allHeaders.size());
    }
    //Create a test method: printRows() and Print all of the rows and print the elements on the 4th row
    @Test
    public void printRows(){
        List<WebElement> allRows = Driver.getDriver().findElements(By.xpath("//tbody//tr"));
        WebElement row4th = Driver.getDriver().findElement(By.xpath("//tbody//tr[3]"));
        for (WebElement eachRow : allRows){
            System.out.println(eachRow.getText());
        }
        System.out.println("Row 4th = " + row4th.getText());
    }
    //Create a test method: printCells() and a the total number of cells in the table body and print all of the cells
    @Test
    public void printCells(){
        List<WebElement> allCell = Driver.getDriver().findElements(By.xpath("//tbody//td"));
        System.out.println("Total Number of Cells = " + allCell.size());
        int total =1;
        for (WebElement eachCell : allCell){
            System.out.println(total + " " + eachCell.getText());
            total ++;
        }
    }
    //Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 6th column
    @Test
    public void printColumns(){
        List<WebElement> allColumns = Driver.getDriver().findElements(By.xpath("//th"));
        List<WebElement> allCell = Driver.getDriver().findElements(By.xpath("//tbody//td[6]"));
        System.out.println("Number of columns = " + allColumns.size());
        for (WebElement each6thColumn: allCell){
            System.out.println("6th columns = " + each6thColumn.getText());
        }
    }
    //Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column
    @Test
    public void printData(int row, int column){
        WebElement allBody = Driver.getDriver().findElement(By.xpath("//tbody//tr[" +row+ "]//td[" +column+ "]"));
        System.out.println(allBody.getText());
    }
    @Test
    public void printData1(){
        printData(5, 3);
    }



}
