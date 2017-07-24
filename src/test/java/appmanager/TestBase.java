package appmanager;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Oлег on 20.07.2017.
 */
public class TestBase {

    public static final ApplicationHelper app = new ApplicationHelper(BrowserType.FIREFOX);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.wd.quit();
    }

}
