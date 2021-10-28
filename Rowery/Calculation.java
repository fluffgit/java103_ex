package w4_23102021.Rowery;

import java.util.ArrayList;

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




}
