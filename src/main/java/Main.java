import com.github.javafaker.Faker;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ContactList myContacts = new ContactList();
    boolean isRunning = true;
    Faker faker = new Faker();

    while (isRunning) {
        System.out.println("What option would you like to choose?");
        System.out.println("1. Add contact\n2. Remove contact\n3. View contact list\n4. Generate Test Data\n5. Exit");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1) {
            System.out.println("Name:");
            String name = scanner.nextLine();
            System.out.println("Phone:");
            String phone = scanner.nextLine();

            if (isValidPhone(phone)) {
                Contact person = new Contact(name, phone);
                myContacts.contactsList.add(person);
            } else {
                System.out.println("Error: Invalid phone format! Use numbers, (), or -.");
            }

        } else if (option == 2) {
            System.out.println("What contact would you like to remove?");
            String removeContact = scanner.nextLine();
            for (int i = 0; i < myContacts.contactsList.size(); i++) {
                if (myContacts.contactsList.get(i).name.equalsIgnoreCase(removeContact)) {
                    myContacts.contactsList.remove(i);
                    System.out.println("Contact removed successfully!");
                    break;
                }
            }
        } else if (option == 3) {
            System.out.println(myContacts.contactsList);
        } else if (option == 4) {
            for (int i = 0; i < 10; i++) {
                String name = faker.name().fullName();
                String phone = faker.phoneNumber().phoneNumber();
                faker.name().fullName();
                faker.phoneNumber().phoneNumber();
                Contact dataTest = new Contact(name, phone);
                myContacts.contactsList.add(dataTest);
            }
            System.out.println("10 random contacts generated successfully!");
        } else if (option == 5){
            System.out.println("Bye!");
            isRunning = false;
        } else {
            System.out.println("Invalid input. Try again!");
            isRunning = false;
        }
    }
}

public static boolean isValidPhone(String phone) {
    if (phone.isEmpty()) return false;

    for (int i = 0; i < phone.length(); i++) {
        char c = phone.charAt(i);

        if (!(Character.isDigit(c) || c == '(' || c == ')' || c == '-' || c == ' ' || c == '.' || c == 'x'))
            return false;
        }

        return true;
}