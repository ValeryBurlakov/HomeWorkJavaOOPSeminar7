package PhoneBook.Import;

import java.io.IOException;
// import java.util.ArrayList;
import java.util.List;
// public class PhoneBookCsvImport extends Importer{
// public void importFromCsv(String fileName) throws IOException {
//     PhoneBookCsvImport importer = new PhoneBookCsvImport();
//     List<Contact> importedContacts = importer.importFromCsv(fileName);
//     contacts.addAll(importedContacts);
// }
// }

import PhoneBook.ContactTypes.Contact;

public class PhoneBookCsvImport extends Importer{
    @Override
    public List<Contact> importContacts(String filePath) throws IOException {
        // импорт контактов из CSV файла
        Importer importer = new Importer();
        List<Contact> importedContacts = importer.importContacts(filePath + ".csv");
        // List<Contact> importedContacts = super.importContacts(filePath);
        // book.getContacts().addAll(importedContacts);
        return importedContacts;
    }
}

