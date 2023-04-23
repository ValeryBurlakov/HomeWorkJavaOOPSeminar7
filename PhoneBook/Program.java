package PhoneBook;

import java.io.IOException;

import PhoneBook.Books.PhoneBook;
import PhoneBook.Books.PhonebookNew;
import PhoneBook.ContactTypes.Contact;
import PhoneBook.Export.Exporter;
import PhoneBook.Export.PhoneBookCsvExport;
import PhoneBook.Export.PhoneBookTXTExport;
import PhoneBook.Import.Importer;
import PhoneBook.Import.PhoneBookCsvImport;
import PhoneBook.Import.PhoneBookTXTImport;
import PhoneBook.Interfaces.IImporter;

/* 
 * OCP - принцип: класс Exporter имеет базовую реализацию, 
    а PhoneBookCsvExport и PhoneBookTXTExport расширяют его также и с импортом 

 * LSP - принцип: для экспорта в файл мы можем использовать как 
    класс Exporter так и PhoneBookCsvExport, результат будет одинаковый, как и у импорта

 * SRP - принцип: каждый класс в этом проекте имеет одну ответственность, 
  даже класс PhoneBook у которого есть 4 метода, так как он отвечает только 
  за управление списком контактов, и не занимается никакими другими задачами

* ISP - принцип: добавлены интерфейсы IDisplay, IExportsCSVBook, IGettersBook, IImportBook,
  IPhoneBook, ISortingAlphabetically, ISearchContact. Специально создал новый класс 
  телефонной книги PhonebookNew чтобы наглядно показать разделение интерфейсов. 
  Теперь я могу расширять или урезать функционал справочника как мне угодно, 
  в первую очередь у нас реализуются базовые возможности справочника, 
  а потом можем иплементить всё остальное, что душе угодно.

* DIP - принцип: В целом, как я понял у меня слабозависиммый проект, 
  потому что я могу добавлять любые виды экспорта или импорта без внесения изменений 
  в старый код. Поэтому я изменил класс Phonebook, теперь там импорт 
  контактов в книгу зависит не от класса с реализацией, а от абстракции 
  (принцип внедрения зависимостей через конструктор)!!! не вижу смысла абстрактить добавление, 
  удаление контактов, потому что эти методы будут неизменны. в классе PhoneBookNew 
  не делал абстракцию, чтобы видеть разницу.
*/

public class Program {
    public static void main(String[] args) throws IOException {
        // контакты
        Contact oleg = new Contact("Oleg", "Barvin", "1", "1@mail.ru");
        Contact Vitya = new Contact("Vitya", "Lagov", "2", "2@mail.ru");
        Contact Tom = new Contact("Tom", "Cruize", "3", "3@mail.ru");
        Contact Tommy = new Contact("Tommy", "Cruize", "4", "4@mail.ru");
        // телефонные книги с разным функионалом
        PhoneBook firstBook = new PhoneBook(null);
        PhonebookNew threeBook = new PhonebookNew();
        // PhonebookNew fourBook = new PhonebookNew();

        // добавление контактов в книгу
        firstBook.addContact(oleg);
        firstBook.addContact(Vitya);
        firstBook.addContact(Tom);
        
        threeBook.addContact(Tommy);
        threeBook.addContact(Tom);
        threeBook.addContact(Vitya);
        threeBook.addContact(oleg);


        // экспорт
        Exporter firstExporterExport = new Exporter(); // родительский
        PhoneBookCsvExport firstCSVExport = new PhoneBookCsvExport(); // дочерний
        PhoneBookTXTExport firstTXTExport = new PhoneBookTXTExport(); // дочерний
       
        // импорт
        IImporter IImp = new Importer(); // DIP
        Importer Imp = new Importer(); // родительский
        PhoneBookCsvImport firstCSVImport = new PhoneBookCsvImport(); // дочерний
        PhoneBookTXTImport firstTXTImport = new PhoneBookTXTImport(); // дочерний


        PhoneBook twoBook = new PhoneBook(IImp); // дал новой книге импортера DIP
        PhoneBook fiveBook = new PhoneBook(IImp); // дал новой книге импортера DIP
        // LSP
        firstExporterExport.exportContacts(firstBook.getContacts(), "PhoneBook1.csv");
        firstCSVExport.exportContacts(firstBook.getContacts(), "PhoneBook");
        firstTXTExport.exportContacts(firstBook.getContacts(), "phonebook");

        fiveBook.importContacts("phonebook.txt");
        twoBook.importContacts("PhoneBook.csv");

        System.out.println("Контакты 1 книги" + firstBook.getContacts() + "\n");
        // родительский и дочерний класс взаимозаменяемы
        System.out.println("Родительский Импортирующий класс csv: " + Imp.importContacts("PhoneBook.csv") + "\n");
        System.out.println("Родительский Импортирующий класс txt: " + Imp.importContacts("phonebook.txt") + "\n");
        System.out.println("дочерний CSV класс: " + firstCSVImport.importContacts("PhoneBook") + "\n");
        System.out.println("дочерний TXT класс: " + firstTXTImport.importContacts("phonebook") + "\n");
        System.out.println("Импортирование контактов во 2 книгу из файла: " + twoBook.getContacts() + "\n");
        System.out.println("Импортирование контактов в 5 книгу из файла: " + fiveBook.getContacts() + "\n");


        // в новой книге появился функционал сортировки по алфавиту а также вывод всех контактов

        threeBook.displayAllContacts(); // вместо sysout, стало короче и красивее
        // System.out.println("До сортировки: " + threeBook.getContacts() + "\n"); // до

        threeBook.sortContactsAlphabetically();

        threeBook.displayAllContacts(); 
        // System.out.println("После сортировки: " + threeBook.getContacts()); // после  

        // firstBook.sortContactsAlphabetically(); // не имеет такого метода... is undefined for the type
              

    }

}
