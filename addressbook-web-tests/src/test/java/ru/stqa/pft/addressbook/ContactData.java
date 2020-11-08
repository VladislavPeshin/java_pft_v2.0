package ru.stqa.pft.addressbook;

public class ContactData {
  private final String name;
  private final String meddleName;
  private final String lastName;
  private final String nickname;
  private final String title;
  private final String address;
  private final String company;

  public ContactData(String name, String meddleName, String lastName, String nickname, String title, String address, String company) {
    this.name = name;
    this.meddleName = meddleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.address = address;
    this.company = company;
  }

  public String getName() {
    return name;
  }

  public String getMeddleName() {
    return meddleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getAddress() {
    return address;
  }

  public String getCompany() {
    return company;
  }
}
