package w4_23102021.Ex_020;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        int goal =generateRandom();
        System.out.println("Podaj liczbę z zakresu [0,100]");
        System.out.println(goal);
        Scanner scanner = new Scanner(System.in);
        int choice=0;
        while(choice!=goal){
            choice =scanner.nextInt();
            if(choice>goal){
                System.out.println("za dużo");
            }else if(choice<goal){
                System.out.println("za mało");
            }else{
                System.out.println("wygrałeś, szukana liczba to "+ goal);
            }
        }
    }
    public static int generateRandom(){
        int max =100;
        int min =1;
        return (int)(Math.random()*(max-min)+min);
    }

}
