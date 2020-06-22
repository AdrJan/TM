package setup;

import org.openqa.selenium.By;
import org.testng.Assert;

public class TestBase extends TestSetup {

    public void sleep(long millisecs)
    {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void assertXpath(String xpath, String msg) {
        Assert.assertTrue(
                driver.findElements(By.xpath(xpath)).size() > 0,
                msg
        );
    }
}
