package w4_23102021.Ex_020;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        int goal =generateRandom();
        int min = 0;
        int max =100;
        System.out.println("Podaj liczbę z zakresu [0,100]");
        System.out.println(goal);
        Scanner scanner = new Scanner(System.in);
        int choice=0;
        int counter = 0;
        while(choice!=goal){
            choice =scanner.nextInt();
            counter++;
            if(choice>goal){
                max = choice;
                System.out.println("za dużo, max: "+ max+", min "+min);

            }else if(choice<goal){
                min = choice;
                System.out.println("za mało, max: "+ max+", min "+min);

            }else{
                System.out.println("wygrałeś, szukana liczba to "+ goal);
            }
        }
        System.out.println("Ilość prób: "+counter);
    }
    public static int generateRandom(){
        int max =100;
        int min =1;
        return (int)(Math.random()*(max-min)+min);
    }

}
