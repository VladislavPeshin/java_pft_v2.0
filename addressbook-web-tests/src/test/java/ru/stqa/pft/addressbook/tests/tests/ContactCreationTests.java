package ru.stqa.pft.addressbook.tests.tests;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.tests.model.ContactData;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().createContact(new ContactData("ivan", "ivanov", "ivanovich", "ivan666", "ivan666", "test", "test", "test", "test1"));
  }

}
