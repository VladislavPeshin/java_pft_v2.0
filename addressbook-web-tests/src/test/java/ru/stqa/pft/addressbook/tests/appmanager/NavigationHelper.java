package ru.stqa.pft.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage(String groups) {
    click(By.linkText(groups));
  }

  public void gotoContactPage() {
    click(By.linkText("add new"));
  }

  public void gotoContactHome() {
    click(By.linkText("home"));
  }
}
