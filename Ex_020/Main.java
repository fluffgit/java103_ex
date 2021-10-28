package w4_23102021.Ex_020;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        if (isMature()) {
            run();
        } else {
            System.out.println("nie jesteś pełnoletni");
        }
    }

    public static int generateRandom() {
        int max = 100;
        int min = 1;
        return (int) (Math.random() * (max - min) + min);
    }

    public static void run() {
        int goal = generateRandom();
        Pattern number = Pattern.compile("^\\d+$");
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        int min = 0;
        int max = 100;
        boolean regexMatch = true;
        boolean run = true;
        System.out.println("szukamy " + goal);

        while (run) {
            System.out.println("podaj liczbe do sprawdzenia");
            System.out.println(min + " " + max);
            choice = scanner.nextLine();
            Matcher matcher = number.matcher(choice);
            regexMatch = matcher.matches();

            if (regexMatch) {
                if (Integer.parseInt(choice) > goal) {
                    max = Integer.parseInt(choice);
                    System.out.println(min + " " + max);
                } else if (Integer.parseInt(choice) < goal) {
                    min = Integer.parseInt(choice);
                    System.out.println(min + " " + max);
                } else {
                    System.out.println("wygrałes:" + choice);
                    run = false;
                }
            } else if (!regexMatch)
                System.out.println("bladedny znak");
        }

    }

    public static boolean isMature() {
        System.out.println("Podaj datę urodzenia");
        LocalDate date1 = LocalDate.now();
        Scanner scanner = new Scanner(System.in);
        LocalDate date2 = LocalDate.parse(scanner.nextLine());
        return ChronoUnit.YEARS.between(date2, date1) > 18;
    }


}
