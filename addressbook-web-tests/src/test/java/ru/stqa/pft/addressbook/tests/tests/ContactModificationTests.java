package ru.stqa.pft.addressbook.tests.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoContactPage();
    app.getGroupHelper().selectContact();
    app.getGroupHelper().initContactModification();
    app.getGroupHelper().fillContactForm(new ContactData("ivan", "ivanov", "ivanovich", "ivan666", "test", "test", "test"));
    app.getGroupHelper().submitContactModification();
    app.getGroupHelper().returnToHome();
  }
}
