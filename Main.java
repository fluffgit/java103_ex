package w4_23102021;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int b = 9;
        int a = 12;
//        System.out.println(dzielniki(a));
//        System.out.println(dzielniki(b));
//        System.out.println(NWD(dzielniki(a), dzielniki(b)));

        System.out.println(divisor2(a, b));
        System.out.println(leastCommonMultiple(a, b));

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


    public static int divisor2(int a, int b) {
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
        return a * b / divisor2(a, b);
    }

}
