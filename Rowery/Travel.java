package w4_23102021.Rowery;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Travel {
    private String id;
    private String uid;
    private String bikeNumber;
    private LocalDateTime travelStart;
    private LocalDateTime travelEnd;
    private String startSation;
    private String endStation;

    public  Travel(String id){
        this.id = id;
    }

    public Travel(String id, String uid, String bikeNumber, LocalDateTime travelStart, LocalDateTime travelEnd, String startSation, String endStation) {
        this.id = id;
        this.uid = uid;
        this.bikeNumber = bikeNumber;
        this.travelStart = travelStart;
        this.travelEnd = travelEnd;
        this.startSation = startSation;
        this.endStation = endStation;
    }



    @Override
    public String toString() {
        return "Travel{" +
                "id='" + id + '\'' +
                ", bikeNumber='" + bikeNumber + '\'' +
                ", travelStart=" + travelStart +
                ", travelEnd=" + travelEnd +
                ", startSation='" + startSation + '\'' +
                ", endStation='" + endStation + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBikeNumber() {
        return bikeNumber;
    }

    public void setBikeNumber(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public LocalDateTime getTravelStart() {
        return travelStart;
    }

    public void setTravelStart(LocalDateTime travelStart) {
        this.travelStart = travelStart;
    }

    public LocalDateTime getTravelEnd() {
        return travelEnd;
    }

    public void setTravelEnd(LocalDateTime travelEnd) {
        this.travelEnd = travelEnd;
    }

    public String getStartSation() {
        return startSation;
    }

    public void setStartSation(String startSation) {
        this.startSation = startSation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public int calcMinutesBeetweenStartEnd(){
        return (int) ChronoUnit.MINUTES.between(travelStart,travelEnd);
    }

}
