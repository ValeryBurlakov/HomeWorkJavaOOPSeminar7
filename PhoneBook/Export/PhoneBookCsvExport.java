package PhoneBook.Export;
import java.util.List;

import PhoneBook.ContactTypes.Contact;

public class PhoneBookCsvExport extends Exporter{
    @Override
    public void exportContacts(List<Contact> contacts, String filePath) {
        Exporter exporter = new Exporter();
        exporter.exportContacts(contacts, filePath + ".csv");
    }
}
