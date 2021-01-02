package ru.stqa.pft.addressbook.tests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.tests.model.ContactData;
import ru.stqa.pft.addressbook.tests.model.Contacts;
import ru.stqa.pft.addressbook.tests.model.GroupData;
import ru.stqa.pft.addressbook.tests.model.Groups;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddContactToGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    Contacts allContacts = app.db().contacts();
    Groups allGroups = app.db().groups();
    List<GroupData> withoutUsedGroups = new ArrayList<>();
    for (GroupData group : allGroups) {
      if (group.getContacts().size() != allContacts.size()) {
        withoutUsedGroups.add(group);
      }
    }

    if (app.db().groups().size() == 0||withoutUsedGroups.size()==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }

    if (app.db().contacts().size() == 0 ) {
      app.goTo().contactHomePage();
      app.contact().create(new ContactData().withName("Ivan").withSurname("Ivanov")
              .withMobilePhone("666666").withEmail("test666@test.ru"));
    }
  }


  @Test
  public void testAddContactToGroup() throws Exception {
    Contacts allContacts = app.db().contacts();
    Groups allGroups = app.db().groups();
    List<GroupData> withoutUsedGroups = new ArrayList<>();
    for (GroupData group : allGroups) {
      if (group.getContacts().size() != allContacts.size()) {
        withoutUsedGroups.add(group);
      }

      GroupData selectGroup = withoutUsedGroups.iterator().next();
      List<ContactData> withoutUsedContact = new ArrayList<>();
      for (ContactData contact : allContacts) {
        if (!contact.getGroups().contains(selectGroup)) {
          withoutUsedContact.add(contact);
        }
      }
      ContactData selectContact = withoutUsedContact.iterator().next();
      app.goTo().contactHomePage();
      Contacts beforeContact = selectGroup.getContacts();
      Groups beforeGroup = selectContact.getGroups();
      app.contact().addToSelectedGroup(selectContact, selectGroup);
      Contacts afterContacts = app.db().group(selectGroup.getId()).getContacts();
      Groups afterGroups = app.db().contact(selectContact.getId()).getGroups();


      assertThat(afterContacts.size(), equalTo(beforeContact.size() + 1));
      assertThat(afterGroups.size(), equalTo(beforeGroup.size() + 1));
    }
  }

}
