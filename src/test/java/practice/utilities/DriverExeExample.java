package practice.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverExeExample {


        public static void main(String[] args) {
            // Set system property to specify the path to chromedriver executable
            System.setProperty("webdriver.chrome.driver", "path_to_chromedriver_executable");

// Instantiate ChromeDriver
            WebDriver driver = new ChromeDriver();

// Open a website
driver.get("https://google.com");

// Find an element and interact with it
            WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
            element.sendKeys("WebDriver");
            element.submit();


// Close the browser
            driver.quit();
        }
    }

