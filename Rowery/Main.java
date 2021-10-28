package w4_23102021.Rowery;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Travel> travels = dataToArray();
        System.out.println("Avg ride "+avgRide(travels));
        System.out.println("Rides in minutes "+sumRidesTime(travels));

        Calculation calculation = new Calculation(travels);
        // chciałbym przenieść sumRideTime do calculation, jak?


    }

    private static Travel readData(String input){
        String[] split = input.split(",");
        String id = split[0];
        String uid = split[1];
        String bikeNumber = split[2];
        String startDate = split[3];
        LocalDateTime startDateObject = converDatetoLDT2(startDate);
        String endDate = split[4];
        LocalDateTime endDateObject = converDatetoLDT2(endDate);
        String starStation = split[5];
        String endStation = split[6];

        return new Travel(id,uid,bikeNumber,startDateObject,endDateObject,starStation,endStation);
    }

    private static LocalDateTime converDatetoLDT(String str){
        //stary format daty z początku nextbike >>01.03.2016 00:33
        StringBuilder dateFinal = new StringBuilder("");
        dateFinal.append(str, 6, 10).append("-").append(str, 3, 5).append("-").append(str, 0, 2).append(" ").append(str, 11, 16);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateFinal, formatter);

    }

    private static LocalDateTime converDatetoLDT2(String str){
        // format daty >> 2019-03-20 13:11:28
        StringBuilder dateFinal = new StringBuilder("");
        dateFinal.append(str,0,16);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateFinal, formatter);

    }

    public static int avgRide(ArrayList<Travel> travels){
        int count  =0;
        int sum =0;
        for(Travel e: travels){
            sum+=e.calcMinutesBeetweenStartEnd();
            count++;
        }
        return sum/count;
    }

    public static int sumRidesTime(ArrayList<Travel> travels){
        int sum =0;
        for(Travel e: travels){
            sum+=e.calcMinutesBeetweenStartEnd();
        }
        return sum;
    }

    public static ArrayList<Travel> dataToArray() throws IOException {
        Scanner scanner = new Scanner(Path.of("C:\\Users\\Marcin\\IdeaProjects\\PodstawyJava\\src\\w4_23102021\\Rowery\\3.csv"));
        ArrayList<Travel> travels = new ArrayList<>();

        while(scanner.hasNext()){
            String nextLineTravel = scanner.nextLine();
            Travel travel = readData(nextLineTravel);
            travels.add(travel);
        }
        return travels;

    }



}
