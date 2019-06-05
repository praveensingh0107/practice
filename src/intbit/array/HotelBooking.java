package intbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        //System.out.println(arrive);
        //System.out.println(depart);
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
                // do not change room count , onle change arrive and depart index
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
        arrive = (List<Integer>) Arrays.asList(arr1);
        depart = (List<Integer>) Arrays.asList(arr2);
        //System.out.println(arrive);
        //System.out.println(depart);
        System.out.println(hotel(arrive, depart, 10));

    }
}
