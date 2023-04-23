package PhoneBook.Export;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import PhoneBook.ContactTypes.Contact;
import PhoneBook.Interfaces.IExporter;

public class ExporterNew implements IExporter{
    @Override
    public void exportContacts(List<Contact> contacts, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Contact contact : contacts) {
                writer.write(contact.getFirstName() + ", " + contact.getLastName() + "\n" + "phonenumber: " + contact.getPhoneNumber() +
                        ", E-mail: "  + contact.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
