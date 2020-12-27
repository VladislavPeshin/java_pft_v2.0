package ru.stqa.pft.addressbook.tests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import ru.stqa.pft.addressbook.tests.model.Contacts;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContactPhoneTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("Ivan").withSurname("Ivanov").withMobilePhone("666666").withEmail("test666@test.ru"));
    }
  }

  @Test
  public void testVerifyContact() {
    app.goTo().contactHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditedForm = app.contact().infoFromEditedForm(contact);

    MatcherAssert.assertThat(contact.getAllPhones(), CoreMatchers.equalTo(mergePhones(contactInfoFromEditedForm)));
    MatcherAssert.assertThat(contact.getAllMails(), CoreMatchers.equalTo(mergeEmails(contactInfoFromEditedForm)));
    MatcherAssert.assertThat(contact.getAddress(), CoreMatchers.equalTo(contactInfoFromEditedForm.getAddress()));

  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleanedEmails)
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getMobilePhone(),contact.getHomePhone(),contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleanedPhones)
            .collect(Collectors.joining("\n"));
  }

  public static String cleanedPhones(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  public static String cleanedEmails(String email) {
    return email.replaceAll("\\s", "");
  }
}
