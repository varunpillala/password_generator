import java.util.Scanner;
import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "1234567890";
    private static final String SYMBOLS = "!@#$%^&*()_=+\\/~?";
    private StringBuilder pool;

    public PasswordGenerator(boolean includeUpper, boolean includeLower, boolean includeNum, boolean includeSym) {
        pool = new StringBuilder();
        if (includeUpper) {
            pool.append(UPPERCASE_LETTERS);
        }
        if (includeLower) {
            pool.append(LOWERCASE_LETTERS);
        }
        if (includeNum) {
            pool.append(NUMBERS);
        }
        if (includeSym) {
            pool.append(SYMBOLS);
        }
    }

    public String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();
        int poolLength = pool.length();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(poolLength);
            password.append(pool.charAt(randomIndex));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Password Generator!");
        boolean includeUpper = false;
        boolean includeLower = false;
        boolean includeNum = false;
        boolean includeSym = false;

        System.out.print("Include Uppercase Letters? (yes/no): ");
        includeUpper = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.print("Include Lowercase Letters? (yes/no): ");
        includeLower = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.print("Include Numbers? (yes/no): ");
        includeNum = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.print("Include Symbols? (yes/no): ");
        includeSym = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();

        PasswordGenerator generator = new PasswordGenerator(includeUpper, includeLower, includeNum, includeSym);
        String password = generator.generatePassword(length);
        System.out.println("Generated Password: " + password);
        scanner.close();
    }
}
