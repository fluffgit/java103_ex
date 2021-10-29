package w4_23102021.Rowery;

import java.util.*;

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

    public String findPopular2(ArrayList<Travel> travels) {
        //odchudzone
        //buduje Arraylist ze String-ów do sprawdzenia
        // przy pomocy Iteratora bo tak fajnie :)
        ArrayList<String> test = new ArrayList<>();
        Iterator<Travel> iter = travels.iterator();
        while (iter.hasNext()) {
            test.add(iter.next().getBikeNumber());
        }
        // buduje HashMapę String Integer >> String numer roweru, Integer licznik
        // For each przelatuje elementy i dodaje do stringcout jeżeli count !=0
        Map<String, Integer> stringsCount = new HashMap<String, Integer>();
        for (String string : test) {
            Integer count = stringsCount.get(string);
            // dlaczego wywala się bez if poniżej??
            if (count == null){
                count = 0;
            }
            count++;
            stringsCount.put(string, count);
        }
        // Map.Entery w For each przelauje przez elementy (enterySet) Mapy stringCount
        // jeżeli wartość mostReapeated < niż wartośc elementu e podstaw e do most repeated
        // zwróć wartość Map.Entery przez getKey();
        Map.Entry<String, Integer> mostRepeated = null;
        for (Map.Entry<String, Integer> e : stringsCount.entrySet()) {
            if (mostRepeated == null || mostRepeated.getValue() < e.getValue())
                mostRepeated = e;
        }
        return mostRepeated.getKey();
    }


}
