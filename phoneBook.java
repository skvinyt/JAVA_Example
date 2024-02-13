import java.util.*;

public class phoneBook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Добавление контактов в телефонную книгу
        addContact(phoneBook, "John", "12345");
        addContact(phoneBook, "Jane", "67890");
        addContact(phoneBook, "John", "54321");
        addContact(phoneBook, "Alice", "98765");
        addContact(phoneBook, "Alice", "69857");
        addContact(phoneBook, "Alice", "36872");

        // Вывод всех контактов в отсортированном порядке по убыванию числа телефонов
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Если имя уже существует в телефонной книге, добавляем новый номер телефона в список
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            // Иначе создаем новую запись в телефонной книге
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    // Метод для вывода всех контактов в телефонной книге
    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        // Создаем список для сортировки контактов по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        sortedContacts.sort(new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> contact1, Map.Entry<String, List<String>> contact2) {
                return Integer.compare(contact2.getValue().size(), contact1.getValue().size());
            }
        });

        // Выводим каждый контакт и его телефоны
        for (Map.Entry<String, List<String>> contact : sortedContacts) {
            System.out.println("Имя: " + contact.getKey());
            System.out.println("Телефоны: " + contact.getValue());
        }
    }
}
