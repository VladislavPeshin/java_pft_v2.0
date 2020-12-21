package ru.stqa.pft.addressbook.tests.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoContactPage();
    app.getNavigationHelper().gotoContactHome();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("ivan", "ivanov", "ivanovich", "ivan666", "test", "test", "test", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHome();
  }
}
