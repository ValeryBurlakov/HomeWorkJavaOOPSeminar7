package PhoneBook.Interfaces;

import java.util.List;

import PhoneBook.ContactTypes.Contact;
// геттеры телефонной книги
public interface IGettersBook {
    List<Contact> getContacts();
}
