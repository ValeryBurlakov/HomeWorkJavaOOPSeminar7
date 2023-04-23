package PhoneBook.Interfaces;

import java.io.IOException;

public interface IImportBook {
    void importContacts(String fileName) throws IOException;
}
