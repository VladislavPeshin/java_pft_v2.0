package ru.stqa.pft.addressbook.tests.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.tests.model.ContactData;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.tests.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoContactPage();
    app.goTo().gotoContactHome();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("test1"));
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size()-1);

    assertThat(after, equalTo(before.without(deletedContact)));

  }
}
