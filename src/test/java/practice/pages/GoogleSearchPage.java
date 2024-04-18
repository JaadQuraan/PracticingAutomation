package practice.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice.utilities.Driver;

public class GoogleSearchPage {

    @FindBy(name="q")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@value='Google Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//a[@class='FLP8od']")
    public WebElement capital;

    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
