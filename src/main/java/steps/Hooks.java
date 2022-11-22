package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.WebDriverUtils;

public class Hooks {
    @Before
    public void setUp() {
        WebDriverUtils.getDriver();
    }

    @After
    public void tearDown(){
        WebDriverUtils.quitDriver();
    }
}
