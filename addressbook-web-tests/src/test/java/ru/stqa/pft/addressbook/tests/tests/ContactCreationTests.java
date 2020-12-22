package ru.stqa.pft.addressbook.tests.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.tests.model.ContactData;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("ivan", "ivanov", "ivanovich", "ivan666", "ivan666", "test", "test", "test", "test1"));
    int after= app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);

  }

}
