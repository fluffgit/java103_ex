package w4_23102021;

import java.util.ArrayList;
import java.util.Scanner;

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
        pattern(4);

//        int count =25;
//        String s = "********************";
//        int n = 4;
//
//
//        if (n == 1)
//        {
//            // simply print the
//            // string and return
//            System.out.print(s);
//            return;
//        }
//
//        int row = 0;
//        boolean down = true;
//
//        for (int i = 0; i < 25; i++)
//        {
//            // put characters in
//            // the matrix
//            a[row][i] = c[i];
//
//            // You have reached
//            // the bottom
//            if (row == n - 1)
//                down = false;
//            else if (row == 0)
//                down = true;
//
//            if(down)
//                row++;
//            else
//                row--;
//        }
//
//        for (int i = 0; i < n; i++)
//        {
//            for (int j = 0; j < len; j++)
//            {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
        String str = "THISPROBLEMISAWESOME";
        int k = 4;

        printZigZag(str, k);


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

    public static ArrayList<Integer> primes(int i){
        ArrayList<Integer> lista = new ArrayList<>();
        for(int j =2;j<i;j++){
            if(divisorCounters(j)<3){
                lista.add(j);
            }
        }
        return lista;
    }

    public static int divisorCounters(int i) {
        int counter =0;
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static ArrayList<Integer> printNumbersFromOneToInput(){
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj zakes drukowanych libcz");
        int s1 = scanner.nextInt();
        for(int i=1;i<=s1;i++){
            lista.add(i);
        }
        return lista;
    }

    public static float sum1(){
        float sum =0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj n-ty wyraz ciągu harmonicznego");
        int j= scanner.nextInt();
        for(int i =1;i<=j;i++){
            sum +=(float)1/i;
        }

        return sum;
    }


    public static int NValuesOfFibo(int n){
        int a = 0, b = 1, licz = 0;
        while (licz < n) {
            int c = b + a;
            a = b;
            b = c;
            licz++;
        }
        return a;
    }


    public static void fibo1(int n)
    {
        int a = 0, b = 1;
        for(int i=0;i<n;i++)
        {
            b += a;
            a = b-a;
            System.out.println(a);
        }
    }

    public static Float calculator(){

        float n1=0;
        float n2=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj pierwszą liczbę");
        String scan = scanner.nextLine();
        n1 =Float.parseFloat(scan);

        String sign = "";
        boolean isRunning = true;
        System.out.println("podaj znak");

            while (isRunning) {
                if(scanner.hasNext()) {
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
        n2 =Float.parseFloat(scan);
        float wynik =0;
        if(sign.equals("+")){
            wynik = n1+n2;
        }else if(sign.equals("-")){
            wynik = n1-n2;
        }else  if(sign.equals("*")){
            wynik = n1*n2;
        }else if(sign.equals("/") && n2!=0){
            wynik = (float)n1/n2;
        }

        if(n2!=0){
            return wynik;
        }else
            return null;
    }

    public static void pattern(int k){
        int l = k-1;
        int count =0;

        for(int i= 0;i<k;i++,l--) {
            for (int j =0;j<Math.pow(k,2)*2;j++){
                if(j%(k*2)==l || j%(k*2)==k+i){
                    System.out.print("*");
                    count++;
                }else System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println(count);
    }

    public static void printZigZag(String str, int k)
    {
        // base case
        if (str == null || k == 0) {
            return;
        }

        // base case
        if (k == 1)
        {
            System.out.print(str);
            return;
        }

        // print first row
        for (int i = 0; i < str.length(); i += (k-1)*2) {
            System.out.print(str.charAt(i));
        }

        // print middle rows
        for (int j = 1; j < k - 1; j++)
        {
            boolean down = true;
            for (int i = j; i < str.length();)
            {
                System.out.print(str.charAt(i));
                if (down) {     // going down
                    i += (k - j - 1) * 2;
                }
                else {          // going up
                    i += (k - 1) * 2 - (k - j - 1) * 2;
                }

                down = !down;   // switch direction
            }
        }

        // print last row
        for (int i = k - 1; i < str.length(); i += (k - 1) * 2) {
            System.out.print(str.charAt(i));
        }
    }

}
