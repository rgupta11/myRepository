package com.rga.q.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Interval problems typically involve sorting the given intervals, and then 
 * processing each interval in sorted each order.
 *   Sorting intervals by start time
 *   Sorting intervals by end time
 *      
 *      Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
 * 
 * Sorting intervals by start time
 *  Overlapping intervals [Sorting intervals by start time]
 *      Sorting intervals by their start times makes it easy to merge two intervals that 
 *      are overlapping. After sorting by start time, an interval overlaps with the previous interval if it starts before the end time of the previous interval.
 *  
 *      Can Attend Meetings
 *         Detecting overlapping intervals is the basis of the question Can Attend Meetings,
 *         in which we are given a list of intervals representing the start and end times 
 *         of meetings, and we need to determine if a person can attend all meetings.
 * 
 *         We sort the intervals by their start times and iterate over each meeting. 
 *         If the current meeting overlaps with the previous one, we return False. 
 *         If we make it through the entire list without finding any overlaps, 
 *         we return True.
 * 
 *          
 * 
 *  Merging Intervals
 *      When an interval overlaps with the previous interval in a list of intervals sorted 
 *      by start times, they can be merged into a single interval.
 *      To merge two overlapping intervals, we take the start time of the first interval and
 *      the end time of the second interval.
 *          To merge an interval into a previous interval, we set the end time of the
 *          previous interval to be the max of either end time.
 *              prev_interval[1] = max(prev_interval[1], interval[1])
 * 
 * 
 * Sorting by End Time
 *  Finding the maximum number of non-overlapping intervals in a given list of intervals.
 *  Our solution will sort the intervals, and then greedily try to add each interval 
 *  to the set of non-overlapping intervals.
 * 
 *  If we sort by start time, we risk adding an interval that starts early but ends late, 
 *  which will block us from adding other intervals until that interval ends.
 *
 *
 */
public class Summary {

    public static void main(String[] args) {
      Integer[][] intervals = { {3,5}, {7,9}, {1,3}, {10,12} };
      printArray2D("unsorted intervals:", intervals);
      //sort using lambda
      sortArray2D(intervals);
      printArray2D("sorted intervals:", intervals);

      //attend meeting 
      canAttendMeeting(intervals);

      //Merge Intervals 
      Integer[][] newIntervals = {{1,5}, {8,10}, {3,6}, {15,18}, {16,17}};
      newIntervals = mergeIntervals(newIntervals);
      printArray2D("Merged intervals:", newIntervals);
      
      
      //Miscellaneous - TB Ignored
      Integer[] arr = {3,2,6,9,3,4,5};
      //sort using lambda
      sortArray(arr);
      printArray("Sorted arrays:", arr);  
    }

    public static Integer[][] mergeIntervals(Integer[][] intervals){
        if(intervals.length == 0 || intervals.length == 1)
            return intervals;
        
        //Sort intervals by start time
        sortArray2D(intervals);
        
        List<Integer[]> list = new ArrayList<Integer[]>();
        //Merge intervals 
        for(Integer[] interval: intervals){

            if(list.isEmpty() || interval[0] > list.get(list.size()-1)[1]){
                list.add(interval);
            }else{
                list.get(list.size()-1)[1] = Math.max(interval[1], list.get(list.size()-1)[1]);
            }
        }
        return list.toArray(new Integer[list.size()][]);
    }


    public static void sortArray2D(Integer[][] intervals){
        if(intervals.length > 1)
            Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
    }

    public static void sortArray(Integer[] intervals){
        if(intervals.length > 1)
            Arrays.sort(intervals, (a,b)-> a-b);
    }

    
    public static void canAttendMeeting(Integer[][] intervals){
        if(intervals.length > 1){
            for (int i=1; i<intervals.length; i++){
                if(intervals[i][0]<intervals[i-1][1]){
                    System.out.println("Meeting status: Can't attend all meetings");
                    return;
                }   
            }
        }
        System.out.println("Meeting status: Can attend all meetings");
    }

    public static void printArray(String msg, Integer[] arr){
         if(arr.length > 1){
            System.out.println(msg);
            for(int i: arr){
                System.out.print(i);
            }
            System.out.println("");
         }
        
    }
    public static void printArray2D(String msg, Integer[][] intervals){
        if(intervals.length > 1){
            System.out.println(msg);
            for (Integer[] interval : intervals) {
                System.out.print(Arrays.toString(interval) + " ");
            }
            System.out.println("");
        }
    }

}
