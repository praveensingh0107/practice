package intbit.binarysearch;

import java.util.List;

/*N number of books are given.
The ith book has Pi number of pages.
You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated at least one book. Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

NOTE: Return -1 if a valid assignment is not possible

Input:

List of Books
M number of students
Your function should return an integer corresponding to the minimum number.

Example:

P : [12, 34, 67, 90]
M : 2

Output : 113

There are 2 number of students. Books can be distributed in following fashion :
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113.
*/
public class AllocateBook {

    public int books(List<Integer> a, int b) {
        if (a.size() < b) {
            return -1;
        }
        int lo = a.stream().max(Integer::compareTo).get();
        int hi = a.stream().mapToInt(Integer::intValue).sum();
        while (lo < hi) {
            int mid = lo + (hi -lo)/2;
            int getStudent = getRequiredStudent(a, mid);
            if (getStudent <= b) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /**
     *
     * @param a
     * @param maxPagePerStudent
     * @return
     */
    private int getRequiredStudent(List<Integer> a, int maxPagePerStudent) {
        int total = 0,count = 1;
        for (int i : a) {
            total += i;
            if (total > maxPagePerStudent) {
                total = i;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AllocateBook obj = new AllocateBook();
        List<Integer> a = List.of(12, 34, 67, 90);
        System.out.println(obj.books(a, 2));
    }
}
