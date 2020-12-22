package ru.stqa.pft.addressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() throws Exception{
    app.getNavigationHelper().gotoContactPage();
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoContactHome();
    if (! app.getContactHelper().isThereContact()){
      app.getContactHelper().createContact(new ContactData("ivan", "ivan", "ivanov", "ivanovich", "ivan666", "test", "test", "test", null));
    }
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("ivan", "ivan", "ivanov", "ivanovich", "ivan666", "test", "test", "test", null));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHome();
    int after= app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
