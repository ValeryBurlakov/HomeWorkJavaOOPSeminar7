package PhoneBook.Interfaces;

import java.util.List;

import PhoneBook.ContactTypes.Contact;

public interface IExporter {
    void exportContacts(List<Contact> contacts, String filePath);
}
