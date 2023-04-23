package PhoneBook.Books;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import PhoneBook.ContactTypes.Contact;
import PhoneBook.Interfaces.IGettersBook;
import PhoneBook.Interfaces.IImportBook;
import PhoneBook.Interfaces.IImporter;
import PhoneBook.Interfaces.IPhoneBook;
// интерфейсы разделены, можно расширять или урезать классы сколько душе угодно, пойду создам новый класс книги
public class PhoneBook implements IPhoneBook, IGettersBook, IImportBook {
    // private List<Contact> contacts;
    public List<Contact> contacts;
    private final IImporter iimporter; // DIP


    public PhoneBook(IImporter iimporter) {
        this.iimporter = iimporter; // DIP
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
    public void importContacts(String fileName) throws IOException {
        // Importer importer = new Importer(); // убрали зависимость от класса, 
        // чтобы соответствовало принципу DIP, теперь зависимость от абстракции
        List<Contact> importedContacts = iimporter.importContacts(fileName);
        contacts.addAll(importedContacts);
    }
}
