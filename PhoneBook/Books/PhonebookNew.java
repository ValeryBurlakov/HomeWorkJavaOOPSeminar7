package PhoneBook.Books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import PhoneBook.ContactTypes.Contact;
import PhoneBook.Interfaces.IDisplay;
import PhoneBook.Interfaces.IGettersBook;
import PhoneBook.Interfaces.IPhoneBook;
import PhoneBook.Interfaces.ISearchContact;
import PhoneBook.Interfaces.ISortingAlphabetically;
// новый класс телефонной книги, урезал функционал, не будет экспорта и импорта, 
// зато есть сортировка имён контактов по алфавиту и вывод всех контактов
public class PhonebookNew implements IPhoneBook, IGettersBook, ISortingAlphabetically, IDisplay, ISearchContact {
    public List<Contact> contacts;
    public Contact contact;
    
    public PhonebookNew() {
        contacts = new ArrayList<Contact>();
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }
    
    @Override
    public List<Contact> getContacts() {
        return contacts;
    }
    
    @Override
    public void sortContactsAlphabetically() {
        System.out.print("Отсортированные по алфавиту");
        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
            }
        });
    }

    @Override
    public Contact searchContact(String firstName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        return null; // возвращает null, если контакт не найден
    }
    
    @Override
    public void displayAllContacts() {
        System.out.println("контакты вашей книги:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
        System.out.println();
    }
}
