package ru.stqa.pft.addressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void gotoGroupPage(String groups) {
    wd.findElement(By.linkText(groups)).click();
  }

  public void gotoContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void gotoContactHome() {
    wd.findElement(By.linkText("home")).click();
  }
}
