package stepdefs;

import io.cucumber.java.Before;
import setup.TestSetup;

public class Hooks extends TestSetup {

    @Before
    public void init(){
        setUp();
        clearCookie();
    }
}
