package ru.stqa.pft.addressbook;


import org.testng.annotations.*;


public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    gotoContactPage();
    initContactCreation();
    fillContactForm(new ContactData("ivan", "ivanov", "ivanovich", "ivan666", "test", "test", "test"));
    submitContactCreation();
    returnToHome();
    returnToLogin();
  }

}
