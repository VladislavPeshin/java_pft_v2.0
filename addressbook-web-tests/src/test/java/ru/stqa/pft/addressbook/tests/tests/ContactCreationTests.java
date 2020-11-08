package ru.stqa.pft.addressbook.tests.tests;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.tests.model.ContactData;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.gotoContactPage();
    app.initContactCreation();
    app.fillContactForm(new ContactData("ivan", "ivanov", "ivanovich", "ivan666", "test", "test", "test"));
    app.submitContactCreation();
    app.returnToHome();
    app.returnToLogin();
  }

}
