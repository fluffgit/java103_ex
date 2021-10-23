package w4_23102021;

public class Main {

    public static void main(String[] args) {
        NWD(27,3);
    }

    public static void NWD(int i, int j){
        int bigger, smaller;
        int reszta=0;
        if(i>j){
            bigger =i;
            smaller=j;
        }else{
            bigger =j;
            smaller=i;
        }
        while(bigger!=0){
            bigger = bigger/smaller;
            reszta = bigger-(bigger/smaller)*smaller;
            if(reszta >0 && bigger % reszta!=0){
                System.out.println(bigger);
            }
        }
    }
}
