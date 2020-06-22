import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author Adrian Jankowski
 * <p>
 * Cucumber test runner class.
 */

@CucumberOptions(features = "src/test/java/resources")
public class TestRunner extends AbstractTestNGCucumberTests {

}
