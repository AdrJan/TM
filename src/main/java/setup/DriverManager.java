package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private final static String PATH_TO_DRIVER = "src/main/resources/drivers/chromedriver";
    protected WebDriver driver;

    public WebDriver createWebDriver() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER);

        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }
}
