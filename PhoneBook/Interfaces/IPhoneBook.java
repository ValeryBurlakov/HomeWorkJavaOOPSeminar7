package PhoneBook.Interfaces;

import PhoneBook.ContactTypes.Contact;

// базовый интерфейс телефонный книги
public interface IPhoneBook {
    void addContact(Contact contact);
    void removeContact(Contact contact);

}
