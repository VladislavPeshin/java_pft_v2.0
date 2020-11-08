package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php#");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  protected void returnToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
    wd.findElement(By.linkText("Logout")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
  }

  protected void submitGroupCreation(String submit) {
    wd.findElement(By.name(submit)).click();
  }

  protected void fillGroupForm(GroupData groupData) {
    initGroupCreation("new");
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  private void initGroupCreation(String s) {
    wd.findElement(By.name(s)).click();
  }

  protected void gotoGroupPage(String groups) {
    wd.findElement(By.linkText(groups)).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected void returnToLogin() {
    wd.findElement(By.linkText("Logout")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
  }

  protected void returnToHome() {
    wd.findElement(By.linkText("home")).click();
  }

  protected void submitContactCreation() {
    wd.findElement(By.name("submit")).click();
  }

  protected void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).sendKeys(contactData.getName());
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(contactData.getMeddleName());
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
  }

  protected void initContactCreation() {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
  }

  protected void gotoContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  protected void deleteSelectedGroups() {
    wd.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
  }

  protected void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }

  protected void deleteSelectedContacts() {
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
    wd.switchTo().alert().accept();
  }

  protected void selectContact() {
    wd.findElement(By.name("selected[]")).click();
  }

  protected void gotoContactHome() {
    wd.findElement(By.linkText("home")).click();
  }
}
