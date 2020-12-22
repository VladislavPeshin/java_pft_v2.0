package ru.stqa.pft.addressbook.tests.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.tests.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoContactHome();
    if (! app.getContactHelper().isThereContact()){
      app.getContactHelper().createContact(new ContactData("ivan", "ivan", "ivanov", "ivanovich", "ivan666", "test", "test", "test", null));
    }
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationHelper().gotoContactHome();
    int after= app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }

}
