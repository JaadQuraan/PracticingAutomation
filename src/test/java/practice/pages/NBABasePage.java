package practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice.utilities.BrowserUtils;
import practice.utilities.Constants;
import practice.utilities.Driver;

import java.util.List;

public class NBABasePage {

    public NBABasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//select[@class='DropDown_select__4pIg9']")
    public WebElement dateDropdown;
    @FindBy(xpath = "//img[@src = 'https://cdn.nba.com/logos/leagues/logo-nba.svg']")
    public WebElement NBALogo;
    @FindBy(xpath = "//ul[@id='nav-ul']")
    public WebElement navigationBar;


    public List<WebElement> getNavItems() {

        BrowserUtils.waitForVisibility(NBALogo, Constants.large);
        String xPathExpression = "//ul[@id='nav-ul']/li[@data-dropdown='true']/a/span";
        return Driver.getDriver().findElements(By.xpath(xPathExpression));
    }
}


