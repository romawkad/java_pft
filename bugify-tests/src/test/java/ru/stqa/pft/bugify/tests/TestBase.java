package ru.stqa.pft.bugify.tests;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.bugify.appmanager.ApplicationManager;

import java.io.IOException;

/**
 * Created by RomanovaD on 22.05.2017.
 */
public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws IOException {
        app.stop();
    }

    public boolean isIssueOpen(int issueId) throws IOException {
        if (app.rest().getIssueStatus(issueId).equals("Closed")){
            return false;
        } else {
            return true;
        }

    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}
