package practice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice.utilities.Driver;

public class SmartBearViewAllOrdersPage extends SmartBearBasePage{

    @FindBy(xpath = "//table[@class='SampleTable']/tbody/tr/td[.='Chuck Norris']")     // //table[@class='SampleTable']/tbody/tr/following-sibling::tr/td/following-sibling::td
    public WebElement firstRowName;
    public SmartBearViewAllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
