package practice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice.utilities.Driver;

public class SmartBearBasePage {

    @FindBy(xpath = "//a[@id='ctl00_logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//a[.='View all orders']")
    public WebElement viewAllOrders;
    @FindBy(xpath = "//a[.='View all products']")
    public WebElement viewAllProducts;

    @FindBy(xpath = "//a[@href='Process.aspx']")
    public WebElement order;

    public SmartBearBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
