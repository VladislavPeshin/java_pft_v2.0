package ru.stqa.pft.addressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoContactPage();
    app.goTo().gotoContactHome();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("test1"));
    }
  }

  @Test
  public void testContactModification() throws Exception{
    Set<ContactData> before = app.contact().all();
    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifyContact.getId()).withName("ivan").withMeddleName("ivanov").withLastName("ivanovich")
            .withNickname("ivan666").withTitle("test").withAddress("test").withCompany("test").withGroup(null);
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifyContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
