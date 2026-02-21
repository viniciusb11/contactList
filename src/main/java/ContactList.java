public static class ContactList {
    String contact;
    ArrayList<String> contactsList = new ArrayList<String>();
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ContactList myContacts = new ContactList();
    boolean isRunning = true;

    while (isRunning) {
        System.out.println("What option would you like to choose?");
        System.out.println("1. Add contact\n2. Remove contact\n3. View contact list\n4. Exit");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1) {
            System.out.println("What's the name of your new contact?");
            String newContact = scanner.nextLine();
            myContacts.contactsList.add(newContact);
        } else if (option == 2) {
            System.out.println("What contact would you like to remove?");
            String removeContact = scanner.nextLine();
            myContacts.contactsList.remove(removeContact);
        } else if (option == 3) {
            System.out.println(myContacts.contactsList);
        } else if (option == 4){
            System.out.println("Bye!");
            isRunning = false;
        } else {
            System.out.println("Invalid input. Try again!");
            isRunning = false;
        }
    }
}

