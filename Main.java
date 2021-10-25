package w4_23102021;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
//        int b = 9;
//        int a = 12;
//        System.out.println(dzielniki(a));
//        System.out.println(dzielniki(b));
//        System.out.println(NWD(dzielniki(a), dzielniki(b)));
//
//        System.out.println(NWD2(a, b));
//        System.out.println(leastCommonMultiple(a, b));
//
//        System.out.println(binaryToDecimals(1000));
//        System.out.println(decimalsToBinary(1234));
//
//        System.out.println(primes(100));
//        System.out.println(printNumbersFromOneToInput());
//        System.out.println(sum1());
//        System.out.println(NValuesOfFibo(7));
//        System.out.println(calculator());
//        pattern(4,22);

//        System.out.println(sneeze("test aaaaaaaaaa psik"));
//        System.out.println(sumOfDigits(1234));
//        System.out.println(longestWord());
//        System.out.println(emptySignProcent());
//        System.out.println(stutter());
//        System.out.println(stutter());
//        System.out.println(countSignsBetween());


//        checkIfDuplicates(returnArray());
        System.out.println(longestInterval(returnArray()));

    }

    public static int NWD(ArrayList<Integer> a, ArrayList<Integer> b) {
        int sizeA = a.size();
        int sizeB = b.size();
        int returnDivisor = 0;
        boolean check = false;
        if (a.get(sizeA - 1) >= b.get(sizeB - 1)) {
            for (int i = sizeA - 1; i != 0; i--) {
                for (int j = sizeB - 1; j >= 0; j--) {
                    if (a.get(i).equals(b.get(j)) && !check) {
                        returnDivisor = a.get(i);
                        check = true;
                    }
                }
            }
        } else {
            for (int i = sizeB - 1; i != 0; i--) {
                for (int j = sizeA - 1; j >= 0; j--) {
                    if (a.get(j).equals(b.get(i)) && !check) {
                        returnDivisor = a.get(j);
                        check = true;
                    }
                }
            }
        }
        return returnDivisor;
    }

    public static ArrayList<Integer> dzielniki(int i) {
        ArrayList<Integer> dzielnikiLista = new ArrayList<>();
        for (int dzielnik = 1; dzielnik <= Math.abs(i); dzielnik++) {
            if (i % dzielnik == 0) {
                dzielnikiLista.add(dzielnik);
            }
        }
        return dzielnikiLista;
    }


    public static int NWD2(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }


    public static int leastCommonMultiple(int a, int b) {
        return a * b / NWD2(a, b);

    }


    public static int binaryToDecimals(int i) {
        int returnNumber = 0;
        int exp = 0;
        while (i != 0) {
            int temp = i % 10;
            returnNumber += temp * Math.pow(2, exp);
            i = i / 10;
            exp++;
        }
        return returnNumber;

    }


    public static String decimalsToBinary(int i) {
        StringBuilder wynik = new StringBuilder();
        int[] tab = new int[20];
        int temp = 0;
        while (i > 0) {
            tab[temp++] = i % 2;
            i = i / 2;
        }
        for (int j = temp - 1; j >= 0; j--) {
            wynik.append(tab[j]);
        }
        return wynik.toString();
    }

    public static ArrayList<Integer> primes(int i) {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int j = 2; j < i; j++) {
            if (divisorCounters(j) < 3) {
                lista.add(j);
            }
        }
        return lista;
    }

    public static int divisorCounters(int i) {
        int counter = 0;
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static ArrayList<Integer> printNumbersFromOneToInput() {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj zakes drukowanych libcz");
        int s1 = scanner.nextInt();
        for (int i = 1; i <= s1; i++) {
            lista.add(i);
        }
        return lista;
    }

    public static float sum1() {
        float sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj n-ty wyraz ciągu harmonicznego");
        int j = scanner.nextInt();
        for (int i = 1; i <= j; i++) {
            sum += (float) 1 / i;
        }

        return sum;
    }


    public static int NValuesOfFibo(int n) {
        int a = 0, b = 1, licz = 0;
        while (licz < n) {
            int c = b + a;
            a = b;
            b = c;
            licz++;
        }
        return a;
    }


    public static void fibo1(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            b += a;
            a = b - a;
            System.out.println(a);
        }
    }

    public static Float calculator() {

        float n1 = 0;
        float n2 = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj pierwszą liczbę");
        String scan = scanner.nextLine();
        n1 = Float.parseFloat(scan);

        String sign = "";
        boolean isRunning = true;
        System.out.println("podaj znak");

        while (isRunning) {
            if (scanner.hasNext()) {
                sign = scanner.nextLine();
                switch (sign) {
                    case "+":
                        sign = "+";
                        isRunning = false;
                        break;
                    case "-":
                        sign = "-";
                        isRunning = false;
                        break;
                    case "*":
                        sign = "*";
                        isRunning = false;
                        break;
                    case "/":
                        sign = "/";
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Błąd, podaj znak [+,-,*,/]");
                        break;
                }
            }
        }

        System.out.println("podaj drugą liczbę");
        scan = scanner.nextLine();
        n2 = Float.parseFloat(scan);
        float wynik = 0;
        if (sign.equals("+")) {
            wynik = n1 + n2;
        } else if (sign.equals("-")) {
            wynik = n1 - n2;
        } else if (sign.equals("*")) {
            wynik = n1 * n2;
        } else if (sign.equals("/") && n2 != 0) {
            wynik = (float) n1 / n2;
        }

        if (n2 != 0) {
            return wynik;
        } else
            return null;
    }

    public static void pattern(int height, int count) {
        int l = height - 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < count; j++) {
                if (j % (height * 2) == l) {
                    System.out.print("*");
                } else if (j % (height * 2) == height + i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            l--;
            System.out.println();
        }

    }

    public static boolean sneeze(String userinput) {
        Pattern sneezPattern = Pattern.compile("a+ psik");
        Matcher matcher = sneezPattern.matcher(userinput);
        return matcher.find();
    }

    public static long silnia(long i) {
        System.out.println("\n oblicz silnię z: " + i);

        long wynik;
        for (wynik = 1; i > 1; --i) {
            wynik *= i;
        }

        return wynik;
    }

    public static int sumOfDigits(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }

        return sum;
    }

    public static String longestWord() {
        String string = "";
        String input = "";
        boolean run = true;
        //ArrayList<String> lista = new ArrayList<>();
        int counter = 0;
        Scanner scanner = new Scanner(System.in);

        while (run) {
            if (scanner.hasNext()) {
                input = scanner.nextLine();
                switch (input) {
                    case "starczy":
                        run = false;
                        break;
                    default:
                        if (!(input.length() == 0)) {
                            //    lista.add(input);
                        } else {
                            System.out.println("nie podano słowa");
                        }
                        if (input.length() > counter) {
                            counter = input.length();
                            string = input;
                        }
                        //System.out.println(lista);
                        break;
                }
            }
        }
        scanner.close();
        return string;
    }

    public static double emptySignProcent() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return ((double) (input.length() - input.replaceAll(" ", "").length()) / input.length()) * 100;

    }


    public static void calcDateBetweenDates() {
        Scanner scanner = new Scanner(System.in);
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.parse(scanner.nextLine());
        long diffInDays = ChronoUnit.DAYS.between(date1, date2);
        System.out.println(diffInDays);
    }

    public static String stutter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj zdanie");
        String input = scanner.nextLine();
        StringBuilder outcome = new StringBuilder();
        String[] lista = input.split(" ");
        for (String a : lista)
            outcome.append(a).append(" ").append(a).append(" ");
        scanner.close();
        return outcome.toString();
    }

    public static int countSignsBetween() {
        String firstSign = null;
        String lastSign = null;
        ;
        char firstSignChar;
        char lastSignChar;
        Scanner scanner = new Scanner(System.in);

        Pattern ascii = Pattern.compile("/^[\\x00-\\x7F]*$/");

        boolean regexMatch = false;
        while (firstSign == null || firstSign.length() != 1 || regexMatch) {
            System.out.println("podaj pierwszy pojedynczy znak");
            firstSign = scanner.nextLine();
            Matcher matcher = ascii.matcher(firstSign);
            regexMatch = matcher.matches();
        }

        regexMatch = false;
        while (lastSign == null || lastSign.length() != 1 || regexMatch) {
            System.out.println("podaj drugi znak");
            lastSign = scanner.nextLine();
            Matcher matcher = ascii.matcher(lastSign);
            regexMatch = matcher.matches();
        }

        firstSignChar = firstSign.charAt(0);
        lastSignChar = lastSign.charAt(0);
        scanner.close();
        return (int) lastSignChar - (int) firstSignChar;
    }

    //nie skończone
    public static int[] returnArray() {
        int size = 10;
        int[] array = new int[size];
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj " + size + " liczb");
        String number = "";
        for (int i = 0; i < size; i++) {
            number = scanner.nextLine();
            array[i] = Integer.parseInt(number);
        }
        return array;
    }

    public static void checkIfDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (i != j && array[i] == array[j])
                    System.out.println(array[i]);
            }
        }
    }
    // nie skończone

    public static int longestInterval(int[] array) {
        int max = 0;
        int temp = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i])
                temp++;
            else temp = 1;
            if (max < temp) max = temp;
        }
        return max;
    }




}






