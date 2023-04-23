package PhoneBook.Interfaces;

import PhoneBook.ContactTypes.Contact;

public interface ISearchContact {
    Contact searchContact(String firstName);
}
