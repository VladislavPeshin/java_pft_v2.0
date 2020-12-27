package ru.stqa.pft.addressbook.tests.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.tests.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().gotoContactPage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withName("test2");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
