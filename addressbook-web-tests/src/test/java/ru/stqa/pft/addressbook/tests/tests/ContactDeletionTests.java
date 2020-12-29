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
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().contactHomePage();
      app.contact().create(new ContactData().
      withName("Ivan").withSurname("Ivanov").withMobilePhone("666666").withEmail("test666@test.ru"));
    }
  }

  @Test
  public void testDeleteContact() throws Exception{
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.goTo().contactHomePage();
    app.contact().delete(deletedContact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size()-1);

    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
