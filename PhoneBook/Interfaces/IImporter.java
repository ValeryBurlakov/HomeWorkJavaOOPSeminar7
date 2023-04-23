package PhoneBook.Interfaces;

import java.io.IOException;
import java.util.List;

import PhoneBook.ContactTypes.Contact;

public interface IImporter {
    List<Contact> importContacts(String fileName) throws IOException;
}
