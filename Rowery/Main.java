package w4_23102021.Rowery;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Travel> travels = dataToArray();
        Calculation calculation = new Calculation(travels);

//        System.out.println(calculation.returnSumRidesTime(travels));
//        System.out.println(calculation.returnAvgRideTimeMINUTES(travels));
//        System.out.println(calculation.howManyBikesInUse(travels));
//        //System.out.println(calculation.returnTime(travels));
//        System.out.println(findPopular(travels));

 //       System.out.println(test4());
        //System.out.println(test5(travels));
        System.out.println(calculation.findPopular2(travels));

    }

    private static Travel readData(String input) {
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

        return new Travel(id, uid, bikeNumber, startDateObject, endDateObject, starStation, endStation);
    }

    private static LocalDateTime converDatetoLDT(String str) {
        //stary format daty z początku nextbike >>01.03.2016 00:33
        StringBuilder dateFinal = new StringBuilder("");
        dateFinal.append(str, 6, 10).append("-").append(str, 3, 5).append("-").append(str, 0, 2).append(" ").append(str, 11, 16);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateFinal, formatter);

    }

    private static LocalDateTime converDatetoLDT2(String str) {
        // format daty >> 2019-03-20 13:11:28
        StringBuilder dateFinal = new StringBuilder("");
        dateFinal.append(str, 0, 16);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateFinal, formatter);

    }

    public static ArrayList<Travel> dataToArray() throws IOException {
        Scanner scanner = new Scanner(Path.of("C:\\Users\\Marcin\\IdeaProjects\\PodstawyJava\\src\\w4_23102021\\Rowery\\3.csv"));
        ArrayList<Travel> travels = new ArrayList<>();

        while (scanner.hasNext()) {
            String nextLineTravel = scanner.nextLine();
            Travel travel = readData(nextLineTravel);
            travels.add(travel);
        }
        return travels;

    }

    public static String findPopular(ArrayList<Travel> travels) {
        ArrayList<String> test = new ArrayList<>();
        Iterator<Travel> iter = travels.iterator();
        while (iter.hasNext()) {
            test.add(iter.next().getBikeNumber());
        }
        Map<String, Integer> stringsCount = new HashMap<String, Integer>();
        for (String string : test) {
            if (string.length() > 0) {
                string = string.toLowerCase();
                Integer count = stringsCount.get(string);
                if (count == null) count = new Integer(0);
                count++;
                stringsCount.put(string, count);
            }
        }
        Map.Entry<String, Integer> mostRepeated = null;
        for (Map.Entry<String, Integer> e : stringsCount.entrySet()) {
            if (mostRepeated == null || mostRepeated.getValue() < e.getValue())
                mostRepeated = e;
        }
        try {
            return mostRepeated.getKey();
        } catch (NullPointerException e) {
            System.out.println("Cannot find most popular value at the List. Maybe all strings are empty");
            return "";
        }

    }



}




