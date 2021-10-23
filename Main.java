package w4_23102021;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int b = 9;
        int a = 12;
        System.out.println(dzielniki(a));
        System.out.println(dzielniki(b));
        System.out.println(NWD(dzielniki(a), dzielniki(b)));

        System.out.println(NWD2(a, b));
        System.out.println(leastCommonMultiple(a, b));

        System.out.println(binaryToDecimals(1000));
        System.out.println(decimalsToBinary(1234));

        System.out.println(primes(100));


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

}
