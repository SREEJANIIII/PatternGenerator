import java.util.InputMismatchException;
import java.util.Scanner;

public class PatternGenerator {
    // ANSI color codes for enhanced console output
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        // Display welcome banner
        displayWelcomeBanner();
        
        while (true) 
        {
            // Menu display for pattern options
            displayMenu();
            
            // User input for pattern choice
            System.out.print(YELLOW + "Enter your choice: " + RESET);
            int c = 0;  // Initialize
            try 
            {
                c = sc.nextInt();
            } 
            catch (InputMismatchException e) 
            {
                System.out.println(RED + "❌ Invalid input! Please enter a number." + RESET);
                sc.nextLine(); // clear the wrong input from scanner buffer
                continue; // go back to while loop
            }

            if (c < 1 || c > 10) {
                System.out.println(RED + "❌ Invalid choice! Please select a number between 1-10." + RESET);
                continue;
            }

            System.out.print(CYAN + "Choose a character (*, #, $, %, @, !, &, ^, ~, etc.): " + RESET);
            String x = sc.next();
            while (x.length() != 1) 
            {
                System.out.println(RED + "⚠️  Please enter only ONE character:" + RESET);
                x = sc.next();
            }

            sc.nextLine(); // Clear buffer

            // Display pattern generation message
            System.out.println(GREEN + "\n🎨 Generating your pattern..." + RESET);
            System.out.println(PURPLE + "═".repeat(50) + RESET);

            // Pattern logic based on choice
            switch (c) {
                case 1:
                    printSwastik(x);
                    break;
                case 2:
                    System.out.println("Enter the statement (exactly 7 characters): ");
                    String s = sc.nextLine();
                    while (s.length() != 7) {
                        System.out.println("Please enter exactly 7 characters: ");
                        s = sc.nextLine();
                    }
                    printHollowHeartWithText(x, s);
                    break;
                case 3:
                    printFilledHeart(x);
                    break;
                case 4:
                    printHollowButterfly(x);
                    break;
                case 5:
                    printFilledButterfly(x);
                    break;
                case 6:
                    System.out.println("Enter the statement (exactly 6 characters): ");
                    String s2 = sc.nextLine();
                    while (s2.length() != 6) {
                        System.out.println("Please enter exactly 6 characters: ");
                        s2 = sc.nextLine();
                    }
                    printHollowDiamond(x, s2);
                    break;
                case 7:
                    printFilledDiamond(x);
                    break;
                case 8:
                    printHollowHourGlass(x);
                    break;
                case 9:
                    printFilledHourglass(x);
                    break;
                case 10:
                    printPyramid(x);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println(PURPLE + "═".repeat(50) + RESET);
            System.out.println(CYAN + "✨ Pattern generated successfully!" + RESET);
            System.out.println(YELLOW + "\nWould you like to generate another pattern? (YES/NO): " + RESET);
            String t = sc.next();
            while((!t.equalsIgnoreCase("YES"))&&(!t.equalsIgnoreCase("NO")))
            {
                System.out.println(RED + "⚠️  Please enter either 'YES' or 'NO': " + RESET);
                t=sc.next();
            }
            if (t.equalsIgnoreCase("NO")) {
                displayGoodbyeMessage();
                break;
            }
            else if(t.equalsIgnoreCase("YES")) {
                clearScreen();
                continue;
            }
        }
        sc.close();
    }

    static void printSwastik(String x) 
    {
        for (int i = 1; i <= 9; i++) 
        {
            for (int j = 1; j <= 17; j++) 
            {
                if (i == 1 && j >= 9) 
                    System.out.print(x);
                else if (j == 9) 
                    System.out.print(x);
                else if (i == 5) 
                    System.out.print(x);
                else if (j == 17 && i >= 5) 
                    System.out.print(x);
                else if (j == 1 && i <= 5) 
                    System.out.print(x);
                else if (i == 9 && j <= 9) 
                    System.out.print(x);
                else if ((i == 3 && j == 5) || (i == 3 && j == 13) || (i == 7 && j == 5) || (i == 7 && j == 13))
                    System.out.print(".");
                else 
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void printHollowHeartWithText(String x, String s) 
    {
        for (int i = 0; i <= 10; i++) 
        {
            for (int j = 0; j <= 12; j++) 
            {
                if (i == 0 && j % 2 == 0 && j % 3 != 0 && j < 12) 
                    System.out.print(x);
                else if (i == 1 && j % 2 != 0 && j % 3 != 0) 
                    System.out.print(x);
                else if (i == 2 && j % 3 == 0 && j != 3 && j != 9) 
                    System.out.print(x);
                else if (i == 3) 
                {
                    if (j == 3) 
                        System.out.print(s);
                    else if (j == 0) 
                        System.out.print(x);
                    else if (j == 6) 
                        System.out.print(x);
                    else 
                        System.out.print(" ");
                } 
                else if (i - j == 4) 
                    System.out.print(x);
                else if (j + i == 16) 
                    System.out.print(x);
                else 
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void printFilledHeart(String x) 
    {
        for (int i = 1; i <= 3; i++) 
        {
            for (int a = 3; a > i; a--) 
                System.out.print(" ");
            for (int b = 1; b <= i; b++) 
                System.out.print(x);
            for (int c = 1; c <= i; c++) 
                System.out.print(x);
            for (int d = 3; d > i; d--) 
                System.out.print(" ");
            System.out.print(" ");
            for (int f = 3; f > i; f--) 
                System.out.print(" ");
            for (int e = 1; e <= i; e++) 
                System.out.print(x);
            for (int g = 1; g <= i; g++) 
                System.out.print(x);
            for (int h = 3; h > i; h--) 
                System.out.print(" ");
            System.out.println();
        }
        for (int j = 7; j >= 1; j--) 
        {
            for (int k = 7; k > j; k--) 
                System.out.print(" ");
            for (int l = 1; l <= j; l++) 
                System.out.print(x);
            for (int m = 1; m < j; m++) 
                System.out.print(x);
            System.out.println();
        }
    }

    static void printHollowButterfly(String x) 
    {
        for (int i = 1; i <= 5; i++) 
        {
            System.out.print(x);
            for (int j = 3; j <= i; j++) 
                System.out.print(" ");
            if (i != 1) 
                System.out.print(x);
            for (int j = 4; j >= i; j--) 
                System.out.print(" ");
            for (int j = 4; j >= i; j--) 
                System.out.print(" ");
            if (i != 1) 
                System.out.print(x);
            if (i == 1) 
                System.out.print(" ");
            else 
                for (int j = 1; j < i; j++) 
                    System.out.print(" ");
            System.out.print(x);
            System.out.println();
        }

        for (int i = 5; i >= 1; i--) 
        {
            System.out.print(x);
            for (int j = i - 2; j >= 1; j--) 
                System.out.print(" ");
            if (i != 1) 
                System.out.print(x);
            for (int j = 4; j >= i; j--) 
                System.out.print(" ");
            for (int j = 4; j >= i; j--) 
                System.out.print(" ");
            if (i != 1) 
                System.out.print(x);
            if (i == 1) 
                System.out.print(" ");
            else 
                for(int j = 1; j < i; j++) 
                    System.out.print(" ");
            System.out.print(x);
            System.out.println();
        }
    }

    static void printFilledButterfly(String x) 
    {
        for (int i = 1; i <= 4; i++) 
        {
            for (int k = 1; k <= i; k++) 
            System.out.print(x);
            for (int k = i + 1; k <= (8 - i); k++) 
            System.out.print(" ");
            for (int k = (8 - i + 1); k <= 8; k++) 
            System.out.print(x);
            System.out.println();
        }

        int l = 4;
        for (int i = 4; i >= 1; i--) 
        {
            for(int k = 1; k <= i; k++) 
            System.out.print(x);
            for(int k = i + 1; k <= 8 - i; k++) 
            System.out.print(" ");
            for(int k = l + 1; k <= 8; k++) 
            System.out.print(x);
            l++;
            System.out.println();
        }
    }

    static void printHollowDiamond(String x, String s2) 
    {
        for (int i = 1; i <= 5; i++) 
        {
            for (int j = 5; j >= i; j--) 
            System.out.print(" ");
            System.out.print(x);
            for (int j = 2; j <= i; j++) 
            System.out.print(" ");
            for (int j = 2; j <= i; j++) 
            System.out.print(" ");
            if (i != 1) 
            System.out.print(x);
            System.out.println();
        }
        System.out.println(x + "  " + s2 + "  " + x);
        for (int i = 1; i <= 6; i++) 
        {
            for (int j = 1; j <= i; j++) 
            System.out.print(" ");
            if (i != 6) 
            System.out.print(x);
            for (int j = 5; j > i; j--) 
            System.out.print(" ");
            for (int j = 5; j > i; j--) 
            System.out.print(" ");
            if (i < 5) 
            System.out.print(x);
            System.out.println();
        }
    }

    static void printFilledDiamond(String x) 
    {
        for (int i = 1; i <= 4; i++) 
        {
            for (int j = 3; j >= i; j--) 
            System.out.print(" ");
            for (int j = 1; j <= i; j++) 
            System.out.print(x);
            for (int j = 2; j <= i; j++) 
            System.out.print(x);
            System.out.println();
        }
        for (int i = 1; i <= 4; i++) 
        {
            for (int j = 1; j < i; j++) 
            System.out.print(" ");
            for (int j = 4; j >= i; j--) 
            System.out.print(x);
            for (int j = 3; j >= i; j--) 
            System.out.print(x);
            System.out.println();
        }
    }

    static void printHollowHourGlass(String x) 
    {
        for (int i = 1; i <= 5; i++) 
        {
            if (i == 1) 
            {
                for (int j = 1; j <= 9; j++) 
                System.out.print(x);
                System.out.println();
            } 
            else 
            {
                for (int j = 2; j <= i; j++) 
                System.out.print(" ");
                System.out.print(x);
                for (int j = 4; j >= i; j--) 
                System.out.print(" ");
                for (int j = 3; j >= i; j--) 
                System.out.print(" ");
                if (i != 5) 
                System.out.print(x);
                System.out.println();
            }
        }
        for (int i = 1; i <= 4; i++) 
        {
            if (i != 4) 
            {
                for (int j = 3; j >= i; j--) 
                System.out.print(" ");
                System.out.print(x);
                for (int j = 1; j <= i; j++) 
                System.out.print(" ");
                for (int j = 2; j <= i; j++) 
                System.out.print(" ");
                System.out.println(x);
            } else 
            {
                for (int j = 1; j <= 9; j++) 
                System.out.print(x);
                System.out.println();
            }
        }
    }

    static void printFilledHourglass(String x) 
    {
        for (int i = 1; i <= 5; i++) 
        {
            for (int j = 1; j < i; j++) 
            System.out.print(" ");
            for (int j = 5; j >= i; j--) 
            System.out.print(x);
            for (int j = 5; j > i; j--) 
            System.out.print(x);
            System.out.println();
        }
        for (int i = 1; i <= 5; i++) 
        {
            for (int j = 5; j > i; j--) 
            {
                if (i != 1) 
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) 
            {
                if (i != 1) 
                System.out.print(x);
            }
            for (int j = 1; j < i; j++) 
            System.out.print(x);
            if (i != 1) 
            System.out.println();
        }
    }

    static void printPyramid(String x) 
    {
        for (int i = 1; i <= 9; i++) 
        {
            for (int j = 12; j >= i; j--) 
            System.out.print(" ");
            for (int j = 1; j <= i; j++) 
            System.out.print(x + " ");
            System.out.println();
        }
    }

    static void displayWelcomeBanner() {
        clearScreen();
        System.out.println(BOLD + CYAN + "╔══════════════════════════════════════════════════╗" + RESET);
        System.out.println(BOLD + CYAN + "║" + WHITE + "              🎨 PATTERN GENERATOR 🎨             " + CYAN + "║" + RESET);
        System.out.println(BOLD + CYAN + "║" + WHITE + "           Create Beautiful ASCII Patterns        " + CYAN + "║" + RESET);
        System.out.println(BOLD + CYAN + "╚══════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }

    static void displayMenu() {
        System.out.println(BOLD + UNDERLINE + GREEN + "Available Patterns:" + RESET);
        System.out.println(BLUE + "┌─────────────────────────────────────┐" + RESET);
        System.out.println(BLUE + "│" + WHITE + "  1. 🕉️  Swastik                     " + BLUE + " │" + RESET);
        System.out.println(BLUE + "│" + WHITE + "  2. 💝 Hollow Heart with text       " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + WHITE + "  3. ❤️  Filled Heart                " + BLUE + " │" + RESET);
        System.out.println(BLUE + "│" + WHITE + "  4. 🦋 Hollow Butterfly             " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + WHITE + "  5. 🦋 Filled Butterfly             " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + WHITE + "  6. 💎 Hollow Diamond with text     " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + WHITE + "  7. 💎 Filled Diamond               " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + WHITE + "  8. ⏳ Hollow Hour Glass            " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + WHITE + "  9. ⏳ Filled Hour Glass            " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + WHITE + " 10. 🔺 Pyramid                     " + BLUE + " │" + RESET);
        System.out.println(BLUE + "└─────────────────────────────────────┘" + RESET);
        System.out.println();
    }

    static void displayGoodbyeMessage() {
        System.out.println();
        System.out.println(BOLD + PURPLE + "╔══════════════════════════════════════════════════╗" + RESET);
        System.out.println(BOLD + PURPLE + "║" + WHITE + "             ✨ THANK YOU! ✨                   " + PURPLE + "  ║" + RESET);
        System.out.println(BOLD + PURPLE + "║" + WHITE + "Thanks for using Pattern Generator!         " + PURPLE + "      ║" + RESET);
        System.out.println(BOLD + PURPLE + "║" + WHITE + "Hope you enjoyed the patterns! 🎨      " + PURPLE + "           ║" + RESET);
        System.out.println(BOLD + PURPLE + "╚══════════════════════════════════════════════════╝" + RESET);
    }

    static void clearScreen() {
        // Clear screen using ANSI escape codes
        System.out.print("\033[2J\033[H");
        System.out.flush();
    }


}
