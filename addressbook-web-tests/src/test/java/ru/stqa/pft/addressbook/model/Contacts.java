package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by iryamka on 12/28/2016.
 */
public class Contacts extends ForwardingSet<GroupFormContacts> {

  private Set<GroupFormContacts> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<GroupFormContacts>(contacts.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<GroupFormContacts>();
  }

  @Override
  protected Set<GroupFormContacts> delegate() {
    return delegate;
  }

  public Contacts withAdded(GroupFormContacts contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }

  public Contacts without(GroupFormContacts contact) {
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }
}
