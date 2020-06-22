package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSetup {

    protected static DriverManager driverManager = new  DriverManager();
    protected static WebDriver driver;
    protected static Actions actions;

    public void setUp() {
        System.out.println("Setting up WebDriver");
        driver = driverManager.createWebDriver();
        actions = new Actions(driver);

        driver.manage().window().maximize();
    }

    public void clearCookie() {
        driver.manage().deleteAllCookies();
    }
}
