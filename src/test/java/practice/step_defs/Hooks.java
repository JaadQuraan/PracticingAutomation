package practice.step_defs;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import practice.utilities.BrowserUtils;
import practice.utilities.Constants;
import practice.utilities.Driver;

//Before After Scenario come from io.cucumber.java
public class Hooks {

    private static final Logger LOG = LogManager.getLogger();

    @Before
    public void setUp(Scenario scenario){
        Driver.getDriver();
        BrowserUtils.myScenario = scenario;
        LOG.info(".............START Automation.........");
    }

    @After
    public void tearDown(Scenario scenario){
        // only takes a screenshot when scenario is failed
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        Constants.scenario = null;


        Driver.closeDriver();
        LOG.info(".............END Automation.........");

    }
}
