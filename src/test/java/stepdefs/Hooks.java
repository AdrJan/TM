package stepdefs;

import io.cucumber.java.Before;
import setup.TestBase;

public class Hooks extends TestBase {

    @Before
    public void init(){
        setUp();
        clearCookie();
    }
}
