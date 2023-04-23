package PhoneBook.Saver;

import java.util.List;

import PhoneBook.Books.PhoneBook;
import PhoneBook.ContactTypes.Contact;

public class BookSaver {
    public void saveContacts(List<Contact> contacts, PhoneBook book) {
        book.getContacts().addAll(contacts);
    }
 }
