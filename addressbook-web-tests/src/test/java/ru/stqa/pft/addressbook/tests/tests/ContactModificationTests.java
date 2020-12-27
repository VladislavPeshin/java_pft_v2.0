package ru.stqa.pft.addressbook.tests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.model.ContactData;
import ru.stqa.pft.addressbook.tests.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().contactHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().
              withName("Ivan").withSurname("Ivanov").withMobilePhone("666666").withEmail("test666@test.ru"));
    }
  }

  @Test
  public void testContactModification() throws Exception{
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withName("Ivan").withSurname("Ivanov").withMobilePhone("666666").withEmail("test666@test.ru");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(before.size(), after.size());

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
