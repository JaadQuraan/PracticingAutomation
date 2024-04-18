package practice.utilities;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class BrowserUtils {

    public static Scenario myScenario;
    private static final Logger LOG = LogManager.getLogger();

    public static Duration currentImplicitWaitTime;
    public static void setImplicitWaitToZero(){
        currentImplicitWaitTime = Driver.getDriver().manage().timeouts().getImplicitWaitTimeout();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ZERO);
    }

    public static void resetImplicitWait(){
        Driver.getDriver().manage().timeouts().implicitlyWait(currentImplicitWaitTime);
    }



    /**
     * @param driver
     * @param expectedTitle
     *returns void, assertion is implemented
     * @author jaad
     */

    public static void validateTitle(WebDriver driver, String expectedTitle){
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    /**
     * Moves the mouse to given element
     * @param element on which to hover
     * @author jaad
     */
    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Scrolls down to an element using javascript
     * @param element
     * @author jaad
     */

    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    /**
     * Click on an element using JavaScript
     * @param element
     * @author jaad
     */
    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Performs double click action on an element
     * @param element
     * @return void
     * @author jaad
     */

    public static void doubleClick(WebElement element){
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Wait for provided element to be visible on the page
     * @param element
     * @param timeToWaitInSec
     * @return element
     * @author jaad
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec){
        setImplicitWaitToZero();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeToWaitInSec));
        resetImplicitWait();
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @return void
     * @author jaad
     */
    public static void waitForInvisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Waits for provided element to be clickable
     * @param element
     * @param timeout
     * @return
     * @author jaad
     */

    public static WebElement waitForClickable(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     *performs a pause
     * @param seconds
     * @author jaad
     */

    public static void justWait(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    // Method to take a screenshot and save it to a specified directory
    public static void takeScreenshotAndSave(String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Specify the directory where you want to save the screenshots
        String directoryPath = "C:\\Users\\quraa\\Documents\\CucumberScreenshots\\Docuport Login";

        // Create the directory if it doesn't exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Specify the path for the screenshot file
        Path targetPath = Path.of(directoryPath, screenshotName + ".png");

        try {
            // Copy the screenshot to the specified directory
            Files.copy(sourceFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }
}

