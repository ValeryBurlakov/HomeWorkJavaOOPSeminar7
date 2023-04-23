package PhoneBook.Import;

import java.io.IOException;
import java.util.List;

import PhoneBook.ContactTypes.Contact;

public class PhoneBookTXTImport extends Importer{
    @Override
    public List<Contact> importContacts(String filePath) throws IOException {
        // импорт контактов из CSV файла
        Importer importer = new Importer();
        List<Contact> importedContacts = importer.importContacts(filePath + ".txt");
        // List<Contact> importedContacts = super.importContacts(filePath);
        // book.getContacts().addAll(importedContacts);
        return importedContacts;
    }
}
