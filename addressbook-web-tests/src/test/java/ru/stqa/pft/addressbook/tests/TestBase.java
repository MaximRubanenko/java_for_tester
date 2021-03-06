package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;


public class TestBase {

//protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  public void setUp() {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  public ApplicationManager getApp() {
    return app;
  }

}
