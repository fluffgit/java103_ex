package w4_23102021.Ex_019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        Author author1 = new Author("Mickiewicz", "polish");
        Author author2 = new Author("Poe", "usa");
        Author author3 = new Author("Orwell", "british");
        Author author4 = new Author("Tolstoj", "russian");

        Poem poem1 = new Poem(author1,10);
        Poem poem2 = new Poem(author2,5);
        Poem poem3 = new Poem(author3,120);
        Poem poem4 = new Poem(author4,100);
        Poem poem5 = new Poem(author1,1);


        Poem[] lista = {poem1,poem2,poem3,poem4,poem5};
        Poem winner = null;
        for (int i = 0; i < lista.length-1; i++) {
            if(lista[i+1].getStropheNumbers()>lista[i].getStropheNumbers()){
                winner =lista[i+1];
            }
        }
        System.out.println(winner);

    }
}
