import java.util.*;

public class Library {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library_User Library = new Library_User();
        System.out.println("Welcome to the Hurtado Library!");
        System.out.println("Please begin by entering your first name:");
        Library.fName = scanner.nextLine();
        System.out.println("Enter your last name:");
        Library.lName = scanner.nextLine();
        System.out.println("Enter your library card ID:");
        Library.cardId = scanner.nextInt();

        Library.getUserInfo(Library.fName, Library.lName, Library.cardId);
        Library.setUserInfo();


    }
}

