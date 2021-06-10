package com.eltobeski.LeetCode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    Map<Integer, Pair<String,Double>> checkInMap = new HashMap<>();
    Map<String, Pair<Double,Double>> tripSummation = new HashMap<>();
        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id,new Pair<>(stationName,t*1.00));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String,Double> checkInMapPair = checkInMap.get(id);
            String checkInLocation = checkInMapPair.getKey();
            Double checkInTime = checkInMapPair.getValue();
            Double duration = t-checkInTime;
            String tripSummationKey = getLocationDestinationKeyPair(checkInLocation,stationName);
            Pair<Double,Double> currentTripSummation = tripSummation.getOrDefault(tripSummationKey,new Pair<>(0.00,0.00));
            tripSummation.put(tripSummationKey,new Pair<>(currentTripSummation.getKey()+duration,currentTripSummation.getValue()+1));

        }

        public double getAverageTime(String startStation, String endStation) {
            String tripSummationKey = getLocationDestinationKeyPair(startStation,endStation);
            Pair<Double,Double> currentTripSummation = tripSummation.get(tripSummationKey);
            return currentTripSummation.getKey()/currentTripSummation.getValue();


        }

    private String getLocationDestinationKeyPair(String currentLocation,String destination){
            return currentLocation+"@"+destination;
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        System.out.println( undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println( undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
    }
}
