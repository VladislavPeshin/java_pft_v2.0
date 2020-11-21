package ru.stqa.pft.addressbook.tests.appmanager;


import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;

  private SessionHelper sessionHelp;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php#");
    groupHelper = new GroupHelper ((FirefoxDriver) wd);
    contactHelper = new ContactHelper ((FirefoxDriver) wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelp = new SessionHelper(wd);
    sessionHelp.login("admin", "secret");
  }
/*
  public void initContact() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php#");
    contactHelper = new ContactHelper ((FirefoxDriver) wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelp = new SessionHelper(wd);
    sessionHelp.login("admin", "secret");
  }
*/

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
  public ContactHelper getContactHelper(){
    return contactHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
