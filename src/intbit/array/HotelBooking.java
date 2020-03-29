package intbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .
 *
 * Input:
 *
 *
 * First list for arrival time of booking.
 * Second list for departure time of booking.
 * Third is K which denotes count of rooms.
 *
 * Output:
 *
 * A boolean which tells whether its possible to make a booking.
 * Return 0/1 for C programs.
 * O -> No there are not enough rooms for N booking.
 * 1 -> Yes there are enough rooms for N booking.
 * Example :
 *
 * Input :
 *         Arrivals :   [1 3 5]
 *         Departures : [2 6 8]
 *         K : 1
 *
 * Return : False / 0
 *
 * At day = 5, there are 2 guests in the hotel. But I have only one room.
 */
public class HotelBooking {
/*    public static boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        if (arrive == null || depart == null || arrive.size() != depart.size()) return false;
        if (arrive.size() == 0 && K > 0) return true;
        ArrayList<Booking> list = new ArrayList<>();
        for (int i = 0; i < arrive.size() ; i++) {
        	list.add(new Booking(arrive.get(i), depart.get(i)));
        }
        list.sort(null);
        System.out.println(list);
        for (int i = 0 ; i < list.size() -K ; i++) {
        	if (list.get(i).d > list.get(i+K).s)
        		return false;
        }
        return true;
    }*/
    
    /*static class Booking implements Comparable<Booking>{
        Integer s, d;
        Booking(Integer s, Integer d) {
            this.s = s;
            this.d = d;
        }
        
        @Override
        public int compareTo(Booking obj) {
            int diff = this.d - obj.d;
            if (diff==0) {
                diff = this.s - obj.s;
            }
            return diff;
        }
        
        public String toString() {
        	return "[" + s + ", " + d + "]";
        }
    }*/

    public static boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        if (arrive == null || depart == null || arrive.size() != depart.size())
            return false;
        if (arrive.size() == 0 && K > 0)
            return true;
        arrive.sort(null);
        depart.sort(null);
        int arriveIndex = 0;
        int departIndex = 0;
        int roomCount = 0;
        while (arriveIndex < arrive.size()) {
            if (arrive.get(arriveIndex) < depart.get(departIndex)) {
                roomCount++;
                if (roomCount > K)
                    return false;
                arriveIndex++;
            } else if (arrive.get(arriveIndex) == depart.get(departIndex)) {
                // do not change room count , only change arrive and depart index
                arriveIndex++;
                departIndex++;
            } else {
                roomCount--;
                departIndex++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> arrive = new ArrayList<>();
        arrive.add(5);
        arrive.add(3);
        arrive.add(1);
        List<Integer> depart = new ArrayList<>();
        depart.add(8);
        depart.add(5);
        depart.add(2);
        System.out.println(hotel(arrive, depart, 1));
        Integer[] arr1 = new Integer[] {11, 0, 28, 23, 14, 12, 10, 18, 5, 5, 34, 21, 26};
        Integer[] arr2 = new Integer[] {35, 30, 35, 71, 59, 21, 59, 58, 48, 40, 59, 22, 27};
        arrive = Arrays.asList(arr1);
        depart = Arrays.asList(arr2);
        System.out.println(hotel(arrive, depart, 10));

    }
}
