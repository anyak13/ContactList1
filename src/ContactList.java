// Anya Kothari
// 1/19
// Contact list uses various methods to add, list, and search for objects in a contact list.
import java.util.ArrayList;
import java.util.Scanner;
public class ContactList {
    // Private variable ArrayList contacts of Person objects
    private ArrayList<Person> contacts;

    // Initializes ArrayList
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact() {
        System.out.println("Select a type of contact to add: \n 1. Student \n 2. Athlete");
        Scanner input = new Scanner(System.in);
        String personType = input.nextLine();
        System.out.println("Please fill in the following information.");
        System.out.println("First Name: ");
        String firstNameInput = input.nextLine();
        System.out.println("Last Name: ");
        String lastNameInput = input.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumberInput = input.nextLine();
        // If the user wants to add a Student object, then ask for grade input
        if (personType.equals("Student")) {
                System.out.println("Grade: ");
                int gradeInput = input.nextInt();
                contacts.add(new Student(firstNameInput, lastNameInput, phoneNumberInput, gradeInput));
        }
        // If the user wants to add a Athlete object, then ask for sport input
        else {
            System.out.println("Sport: ");
            String sportInput = input.nextLine();
            contacts.add(new Athlete(firstNameInput, lastNameInput, phoneNumberInput, sportInput));
        }
    }

    public void printContacts() {
        // Go through all the objects in contacts ArrayList
        for (int i = 0; i < contacts.size(); i++) {
            // Print it's toString() method
            System.out.println(contacts.get(i).toString());
        }
    }

    public void sort(int sortBy) {
        int n = contacts.size();
        for (int pass = 0; pass < n - 1; pass++) {
            for (int comp = 0; comp < n - 1 - pass; comp++) {
                String str1 = "";
                String str2 = "";
                if (sortBy == 0) {
                    str1 = contacts.get(comp).getFirstName();
                    str2 = contacts.get(comp + 1).getFirstName();
                } else if (sortBy == 1) {
                    str1 = contacts.get(comp).getLastName();
                    str2 = contacts.get(comp + 1).getLastName();
                } else if (sortBy == 2) {
                    str1 = contacts.get(comp).getPhoneNumber();
                    str2 = contacts.get(comp + 1).getPhoneNumber();
                }
                // If the str1 comes after str2 alphabetically, it returns a number greater than 0
                if (str1.compareTo(str2) > 0) {
                    // If they are in the wrong order, then they switch spots
                    Person temp = contacts.get(comp);
                    contacts.set(comp, contacts.get(comp + 1));
                    contacts.set(comp + 1, temp);
                }
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        // Go through the ArrayList and check if firstName is in it
        for (int i = 0; i < contacts.size(); i++) {
            if (firstName.equals(contacts.get(i).getFirstName())) {
                // If found, returns the object
                return contacts.get(i);
            }
        }
        // Return null if firstName is not found
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (lastName.equals(contacts.get(i).getLastName())) {
                return contacts.get(i);
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            if (phoneNumber.equals(contacts.get(i).getPhoneNumber())) {
                //System.out.println("hi");
                return contacts.get(i);
            }
        }
        return null;
    }

    public void listStudents() {
        for (int i = 0; i < contacts.size(); i++) {
            // Checks if the contact is a Student
            if (contacts.get(i) instanceof Student) {
                // If it is a Student, it prints it
                System.out.println(contacts.get(i));
            }
        }

    }

    public void run() {
        System.out.println("Welcome to your contact list!");
        System.out.println("Please pick from the following menu options");
        System.out.println("Menu: ");
        System.out.println("\n 1. Add Contact \n 2. List All Contacts By First Name \n 3. List All Contacts By Last Name" +
              "\n 4. List All Contacts By Phone Number \n 5. List All Students \n 6. Search By First Name" +
              " \n 7. Search By Last Name \n 8. Search By Phone Number \n 0. Exit");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        // Continues asking for input until user inputs a 0
        while (num != 0) {
            if (num == 1) {
                addContact();
            }
            else if (num == 2) {
                sort(0);
                printContacts();
            }
            else if (num == 3) {
                sort(1);
                printContacts();
            }
            else if (num == 4) {
                sort(2);
                printContacts();
            }
            else if (num == 5) {
                listStudents();
            }
            else if (num == 6) {
                System.out.println("Enter a first name: ");
                String name = input.next();
                // Checks if the name inputed is not the list
                if (searchByFirstName(name) == null) {
                    System.out.println(name + " is not in the list");
                }
                else {
                    System.out.println(searchByFirstName(name.toString()));
                }
            }
            else if (num == 7) {
                System.out.println("Enter a last name: ");
                String lastName = input.next();
                if (searchByLastName(lastName) == null) {
                    System.out.println(lastName + " is not in the list");
                }
                else {
                    System.out.println(searchByLastName(lastName.toString()));
                }
            }
            else if (num == 8) {
                System.out.println("Enter a phone number: ");
                String phoneNumber = input.next();
                if (searchByPhoneNumber(phoneNumber) == null) {
                    System.out.println(phoneNumber + " is not in the list");
                }
                else {
                    System.out.println(searchByPhoneNumber(phoneNumber.toString()));
                }
            }
            else if (num == 0) {
                System.exit(0);
            }
            System.out.println("\nYou can make another selection.");
            num = input.nextInt();
        }

    }
    public static void main (String[] args) {
        ContactList contacts = new ContactList();
        contacts.run();
    }
}