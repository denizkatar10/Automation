package com.techproed.pages;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Day11_DefaultPage {
    public Day11_DefaultPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addUserButton;
    @FindBy(xpath = "//span[contains(text(),'Hotel Management')]")
    public WebElement hotelManagement;
    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRooms;
    @FindBy(xpath = "(//span)[1]")
    public WebElement userID;
    @FindBy(id = "IDHotel")
    public WebElement hotelIdDropdown;
    @FindBy(id = "Code")
    public WebElement code;
    @FindBy(id = "Name")
    public WebElement name;
    @FindBy(id = "Location")
    public WebElement location;
    @FindBy(id = "IDGroupRoomType")
    public WebElement description;
    @FindBy(id = "MaxAdultCount")
    public WebElement maxAdultCount;
    @FindBy(id = "MaxChildCount")
    public WebElement maxChildCount;
    @FindBy(id= "IsAvailable")
    public WebElement isApprovedCheckbox;
    @FindBy(id= "btnSubmit")
    public WebElement saveButton;

}