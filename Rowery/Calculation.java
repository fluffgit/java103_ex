package w4_23102021.Rowery;

import java.util.ArrayList;
import java.util.Date;

public class Calculation {

    private int avgRideTime;
    private ArrayList<Travel> travel;


    public Calculation(ArrayList<Travel> travel) {
        this.travel = travel;
    }


    public int getAvgRideTime() {
        return avgRideTime;
    }

    public void setAvgRideTime(int avgRideTime) {
        this.avgRideTime = avgRideTime;
    }

    public void printTravels(){
        System.out.println(travel);
    }

    public void printRideAboveAVG(){

    }

    public int returnAvgRideTimeMINUTES(ArrayList<Travel> travels){
        int count  =0;
        int sum =0;
        for(Travel e: travels){
            sum+=e.calcMinutesBeetweenStartEnd();
            count++;
        }
        return sum/count;
    }

    public int returnSumRidesTime(ArrayList<Travel> travels){
        int sum =0;
        for(Travel e: travels){
            sum+=e.calcMinutesBeetweenStartEnd();
        }
        return sum;
    }

    public int howManyBikesInUse(ArrayList<Travel> travels){
        ArrayList<Integer> uniqeBikes = new ArrayList<>();
        int sum = 0;
         for(Travel e: travels){
             if(!uniqeBikes.contains(Integer.parseInt(e.getBikeNumber()))){
                 uniqeBikes.add(Integer.parseInt(e.getBikeNumber()));
             }
         }
        return uniqeBikes.size();
    }

    public int test(ArrayList<Travel> travels){
        for (Travel e:travels){

            //dates.add(e.getStartTime222(e.getTravelStart(travels)));
        }


        return 0;
    }



    public ArrayList<Date> returnTime (ArrayList<Travel>travels){
        ArrayList<Date> dates = new ArrayList<>();

        for (Travel e:travels){

            //dates.add(e.getStartTime222(e.getTravelStart(travels)));
        }


        return dates;
    }


}
