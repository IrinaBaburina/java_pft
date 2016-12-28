package ru.stqa.pft.addressbook.model;

public class GroupFormContacts {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String nickname;
  private String company;
  private String address;
  private String mobile;
  private String email;
  private String group;

  public GroupFormContacts withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public GroupFormContacts withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public GroupFormContacts withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public GroupFormContacts withCompany(String company) {
    this.company = company;
    return this;
  }

  public GroupFormContacts withAddress(String address) {
    this.address = address;
    return this;
  }

  public GroupFormContacts withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public GroupFormContacts withEmail(String email) {
    this.email = email;
    return this;
  }

  public GroupFormContacts withGroup(String group) {
    this.group = group;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupFormContacts contacts = (GroupFormContacts) o;

    if (id != contacts.id) return false;
    if (firstname != null ? !firstname.equals(contacts.firstname) : contacts.firstname != null) return false;
    return lastname != null ? lastname.equals(contacts.lastname) : contacts.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  public GroupFormContacts withId(int id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "GroupFormContacts{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}
