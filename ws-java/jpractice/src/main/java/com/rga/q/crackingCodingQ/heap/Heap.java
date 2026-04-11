package com.rga.q.heap;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;



public class Heap {


    class Employee implements Comparable<Employee>{
        String name;
        int age;

        public Employee(String name, int age){
            this.name = name;
            this.age = age; 
        }

        @Override
        public int compareTo(Employee other){
            return Integer.compare(this.age, other.age);
        }
    }

    static Employee[] genEmployee(int len){
        Employee[] empArr = new Employee[len];
        for(int i=0; i<len; i++){
            empArr[i] = new Heap().new Employee("emp-"+i, (int)Math.random()*len);
            //System.out.println("randomEmp---" + empArr[i].name + "-" + empArr[i].age);
        }
        return empArr;
    }


    /**
     * MINHEAP
     * 
     * 
     */
    static void minHeapOper(int[] arr){

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i=0; i< arr.length; i++){
            minHeap.offer(arr[i]);        
        }

        //offer - add 
        minHeap.offer(11);
        //poll - remove and get element
        System.out.println("minHeap-poll "+ minHeap.poll());
        //peek
        System.out.println("minHeap-peek " + minHeap.peek());
        System.out.println("minHeap-peek-again " + minHeap.peek());
    }

    static void maxHeapOper(int[] arr){

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i=0; i<arr.length;i++){
            maxHeap.offer(arr[i]);
        }        
        //poll
        System.out.println("mHeap-Poll "+maxHeap.poll());
        //peek
	    System.out.println("mHeap-Peek "+maxHeap.peek());
        System.out.println("mHeap-Peek-again "+maxHeap.peek());
    }

    /**
     * Time Complexity - O(k log n) - k is comparisons
     * 
     */
    static void tupleHeapOper(){
	
        int[][] arr = {{2,5}, {1,3}, {4,3}, {1,9}, {4,4}, {5,6}, {2,9}, {5,9}, {5,1}};

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b) -> {
            for(int i=0; i< Math.min(a.length, b.length); i++){
                if(a[i] != b[i]){
                    return Integer.compare(a[i], b[i]);
                }
            }
            return Integer.compare(a.length, b.length);
        });

        for(int[] tup: arr){
            heap.offer(tup);
        }
        //print the heap without removing elements
        System.out.println("tuple-heap-peek " + heap.peek()[0] + "," + heap.peek()[1]);
        

        //poll
        System.out.println("tuple-heap-poll" + heap.poll()[0]);

        //peek
        System.out.println("tuple-heap-peek" + heap.peek()[0]);

        //offer
        heap.offer(new int[]{1,7});

        //peek
        System.out.println("tuple-heap-peek-again" + heap.peek()[0]);

    }

    /**
     * 
     * topk definition - Given an array of integers, find the top k largest elements in the array.
     * minHeap used to return max topk values
     * MaxHeap used to return min topk
     * 
     * Time Complexity - O(n log k) - n is number of elements in array and k is size of heap
     * Space Complexity - O(k) - size of heap
     * 
     * Approach: topkMax
     * 1. Create a min heap of size k
     * 2. Iterate through the array and add elements to the heap
     * 3. If the size of the heap exceeds k, remove the minimum element from the heap
     * 4. After iterating through the array, the heap will contain the maxTopk values
     */
    static int[] topkMax(int[] arr, int k){
       //Create MinHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i=0; i<arr.length; i++){
            minHeap.offer(arr[i]);
            
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        //store in reverse order to get max elements
        for(int i=k-1; i>=0; i--){
            result[i] = minHeap.poll();
        }
        return result;
    }

    /**
     * 
     * topk definition - Given an array of integers, find the top k largest elements in the array.
     * minHeap used to return max topk values
     * MaxHeap used to return min topk
     * 
     * Time Complexity - O(n log k) - n is number of elements in array and k is size of heap
     * Space Complexity - O(k) - size of heap
     * 
     * Approach topkMin:
     * 1. Create a max heap of size k
     * 2. Iterate through the array and add elements to the heap
     * 3. If the size of the heap exceeds k, remove the minimum element from the heap
     * 4. After iterating through the array, the heap will contain the min topk values
     */
    static int[] topkMin(int[] arr, int k){
        //create maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        

        for (int i=0; i<arr.length; i++) {
            maxHeap.offer(arr[i]);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[] result = new int[k];
       //store in reverse order to get max elements
        for(int i=k-1; i>=0; i--){
            result[i] = maxHeap.poll();
        }
        return result;
    }


    static Employee[] empTopkMin(Employee[] arr, int k){
        //create maxHeap
        PriorityQueue<Employee> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i=0; i<arr.length; i++) {
            maxHeap.offer(arr[i]);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        Employee[] result = new Employee[k];
       //store in reverse order to get max elements
        for(int i=k-1; i>=0; i--){
            result[i] = maxHeap.poll();
        }
        return result;
    }

    static int[] genArray(int len){
        int[] arr = new int[len];
        for(int i=0; i<len; i++){
            arr[i] = (int)(Math.random() * len);
            //System.out.println("random---" + arr[i]);
        }
        return arr; 
    }

    /**
     * 
     * My performance is O(n log n) time and O(n) space - 
     * because I am building a full max-heap of the array and then polling k times 
     * to get the kth largest element.
     * 
     * Improvement Performance: build a full max-heap then poll k times (O(n log n) time,
     * O(n) space). For large n and small k, 
     * 
     * Prefer a min-heap of size k to get O(n log k) time and O(k) space. 
     * Example replacement for the heap logic:
     * 
     * Anoher approach is to sort Array and return kth element from end - O(n log n) time 
     * and O(1) space
     * Sample code for array sorting approach:
     *   Arrays.sort(nums); // time complexity O(n log n) it uses TimSort
     *  return nums[nums.length - k];
     * 
     * Small to Medium Arrays: Use Arrays.sort(arr).
     * Massive Arrays (>10^5 elements): Use Arrays.parallelSort(arr).      
     */
    static Integer topKth(int[] nums, int k){
        
        //Validation checks
        if(nums == null || nums.length==0 || k < 0 || k > nums.length){
            throw new IllegalArgumentException("Illegal input arguements");
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        
        //Offer elements to Heap 
        for(int i=0; i<nums.length; i++){
            heap.offer(nums[i]);
        }

        //poll k element
        Integer result = null;
        for (int i=0; i<k; i++){
            result = heap.poll();
        }
        return result;

    }


    static Integer topKthImproved(int[] nums, int k){
        //Validation checks
        if(nums == null || nums.length==0 || k < 0 || k > nums.length){
            throw new IllegalArgumentException("Illegal input arguements");
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            if (minHeap.size() < k) minHeap.offer(num);
            else if (num > minHeap.peek()) { minHeap.poll(); minHeap.offer(num); }
        }
        return minHeap.peek();
        
    }

    
    /**
     * Approach:
        1. Create a max heap of size k to store the closest points.
        2. Iterate through the list of points and calculate the distance of each point from the origin.
        3. formula - √(x - a)² + (y - b)² 
        4. Can be simplified to x² + y² since a and b are 0.
        5. If the size of the heap exceeds k, remove the farthest point from the heap.
        6. After iterating through the list of points, the heap will contain the k closest points.
     * 
     *   Time Complexity: O(n log k) - n is the number of points and k is the size of the heap.
     * Space Complexity: O(k) - size of the heap.
     */
    static int[][] findTopKClosestPoints(int[][] points, int k){
            
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> Integer.compare(b[0], a[0]));
            //This comparator uses only the first value ([0]) and is reversed, 
            // so it behaves like a max-heap on x-coordinate. 


            // add elements to heap 
            for (int i=0; i<points.length; i++){
                int x = points[i][0];
                int y = points[i][1];
                int distance = x*x + y*y;

                //<k
                if(maxHeap.size()<k){
                    maxHeap.offer(new int[]{distance, i});
                }else if (distance < maxHeap.peek()[0]){ //>k
                    maxHeap.poll();
                    maxHeap.offer(new int[]{distance, i});
                }
                
            }
            //pick topk from heap and add to result
            int[][] result = new int[k][];
            for (int[] point: maxHeap){
                result[--k] = points[point[1]];
            }
            return result;
    }    


    /**
     * 
     * Find K Closest Elements
     * Given a sorted array nums, a target value target, and an integer k,
     * find the k closest elements to target in the array, where "closest" is 
     * the absolute difference between each element and target. 
     * Return these elements in array, sorted in ascending order.
     * 
     * Time Complexity: O(n log k) - n is the number of elements in the array and k is the size of the heap.
     * Space Complexity: O(k) - size of the heap.
     * 
     */
    static int[] findkClosest(int[] nums, int target, int k){
        int[] result = new int[k];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> Integer.compare(b[0], a[0]));
        for (int num : nums){
            int diff = Math.abs(num - target);
            if(maxHeap.size() < k){
                maxHeap.offer(new int[]{diff, num});
            }else if(diff < maxHeap.peek()[0]){
                maxHeap.poll();
                maxHeap.offer(new int[]{diff, num});
            }
        }
        // for (int i=0; i<k; i++){
        //     result[i] = maxHeap.poll()[1];
        // }
        for (int[] point: maxHeap){
            result[--k] = point[1];
        }
                
        return result;
    }


    /**
     *  sorted array using a min-heap approach.
     * 
     */
    static int[] mergeKSortedLists(List<int[]> nums){
        // 1. Calculate total length and validate input
    int totalLen = 0;
    for (int[] list : nums) {
        if (list != null) {
            totalLen += list.length;
        }
    }
    
    // 2. Create result array
    int[] merged = new int[totalLen];
    
    // 3. Create min-heap with [value, listIndex, indexWithinList]
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> 
        Integer.compare(a[0], b[0])
    );
    
    // 4. Add first element from each list to heap
    for (int listIdx = 0; listIdx < nums.size(); listIdx++) {
        int[] list = nums.get(listIdx);
        if (list != null && list.length > 0){
            minHeap.offer(new int[]{list[0], listIdx, 0});
        }
    }
    //print minheap elements without removing
    System.out.println("minHeap for merging k sorted lists:");
    for (int[] tup : minHeap) {
        System.out.println("value: " + tup[0] + ", listIdx: " + tup[1] + ", indexWithinList: " + tup[2]);
    }


    // 5. Poll min element, write to result, add next element from same list
    int write = 0;
    while (!minHeap.isEmpty()){
        int[] current = minHeap.poll();
        merged[write++] = current[0];
        
        int listIdx = current[1];
        int nextIndex = current[2] + 1;
        int[] source = nums.get(listIdx);
        if (source != null && nextIndex < source.length){
            minHeap.offer(new int[]{source[nextIndex], listIdx, nextIndex});
        }
    }
        return merged;
    }

    
    
    public static void main(String[] args){
        
        int[] arr = {3,1,4,5,6,7};
        minHeapOper(arr);

        maxHeapOper(arr);
        
        tupleHeapOper();


        //topk - max elements
        arr = genArray(100);
        int[] ar = topkMax(arr, 3);
        for (int elem : ar){
            System.out.println("topkMax " + elem); 
        }

        //topk - min elements
        ar = topkMin(arr, 3);
        for(int a: ar){
            System.out.println("topkMin "+ a);
        }


        //topk of Employee heap 
        Employee[] empArr = genEmployee(10);
        Employee[] empTopk = empTopkMin(empArr, 3);
        for(Employee a: empTopk){
            System.out.println("empTopkMin "+ a.name + "-" + a.age);
        }


        /**
         * Write a function that takes an array of unsorted integers nums and an integer k, 
         * and returns the kth largest element in the array. 
         * This function should run in O(n log k) time, where n is the length of the array.
         * 
         * nums = [5, 3, 2, 1, 4] | k = 2
         * Output: 4
         */
        int[] input = {5,3,2,1,4};
        System.out.println("kth largest element is: " + topKth(input, 2));

        //Improved version with O(n log k) time and O(k) space
        System.out.println("kth largest element is: " + topKthImproved(input, 2));



         /*
        Given a list of points in the form [[x1, y1], [x2, y2], ... [xn, yn]] and an integer k, 
        find the k closest points to the origin (0, 0) on the 2D plane.

        The distance between two points (x, y) and (a, b) is calculated using the formula:

        √(x - a)² + (y - b)²

        Return the k closest points in any order.
        
        Approach:
        1. Create a max heap of size k to store the closest points.
        2. Iterate through the list of points and calculate the distance of each point from the origin.
        3. formula - √(x - a)² + (y - b)² 
        4. Can be simplified to x² + y² since a and b are 0.
        5. If the size of the heap exceeds k, remove the farthest point from the heap.
        6. After iterating through the list of points, the heap will contain the k closest points.
        
        Time Complexity: O(n log k) - n is the number of points and k is the size of the heap.
        Space Complexity: O(k) - size of the heap. 

        Edge cases:
        1. When k is greater than the number of points in the list. -- can return all points in this case or throw an exception based on requirements.
        2. When k is equal to the number of points in the list. -- can return all points in this case.
        3. When k is 0 or negative. -- can return an empty list in this case.
        4. When the list of points is empty. -- can return an empty list in this case.

        */


        int[][] inputs = {{3,4},{2,2},{1,1},{0,0},{5,5}};
        int k = 3;
        int[][] result = findTopKClosestPoints(inputs, k);
        
        System.out.println("----- topK coordinates -----");
        for (int[] point: result){
            System.out.println(point[0] + "," + point[1]);
        }




        /**
         * Find K Closest Elements
         * Given a sorted array nums, a target value target, and an integer k,
         * find the k closest elements to target in the array, where "closest" is 
         * the absolute difference between each element and target. 
         * Return these elements in array, sorted in ascending order.
         * 
         * Approach:
         * 1. Create a minHeap
         * 2. Diff - No - target stored in the min heap 
         * 3. The heap size == k
         * 4. heap.size < k - add
         *  4.1 offer
         * 5. Diff < heap   
         *  5.1 poll 
         *  5.2 offer
         * Time Complexity: O(n log k) - n is the number of elements in the array and k is the size of the heap.
         * Space Complexity: O(k) - size of the heap.
         *
         */

        int[] nums = {5, 6, 7, 8, 9};//{-1,0,1,4,6};
        int target = 10;//1;
        k = 2;//3;

        int[] r4 = findkClosest(nums, target, k);
        System.out.println("-------K closest ------");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int n : r4) {
            sb.append(n).append(",");
            
        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        System.out.println(sb.toString());



        /**
         * Merging k sorted lists
         * Given k linked lists, each sorted in ascending order, in a list lists, 
         * write a function to merge the input lists into one sorted linked list.
         * 
         * Input - 
         * lists = [[3,4,6],[2,3,5],[-1,6]]
         * 
         */

        List<int[]> lists = new ArrayList<>();
        lists.add(new int[]{3,4,6}); 
        lists.add(new int[]{2,3,5}); 
        lists.add(new int[]{-1,6});
        System.out.println("-------Merged k sorted lists------"); 
        int[] merged = mergeKSortedLists(lists);
        
        System.out.print("["); 
        for (int i = 0; i < merged.length; i++){
            System.out.print(merged[i]);
            if (i < merged.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");        
    }
   
}


/**
 * summary 
 * 
 * PriorityQueue<Integer> minHeap = new PriorityQueue<>();
 * 
 * PriorityQueue<Employee> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
 * 
 *  //Validation checks
 *   if(nums == null || nums.length==0 || k < 0 || k > nums.length){
 *       throw new IllegalArgumentException("Illegal input arguements");
 *   }
 * 
 * 
 * x,y disatnce from 0,0
 * Your lambda is just a short way to write that comparator.
 * 
 * PriorityQueue<int[]> minHeap = new ProirityQueue<>((a,b)-> {
 *             for(int i=0; i< Math.min(a.length, b.length); i++){
 *                 if (a[i] != b[i]) {
 *                     return Integer.compare(a[i], b[i]);
 *                 }
 *             }
 *             return Integer.compare(a.length, b.length);
 * 
 *         });
 * 
 *         formula (x-a)^2 + (y-b)^2 -> since a,b, 0,0 -> x^2 + b^2
 * 
 * 
 *  PriorityQueue<int[]> maxHeap = new ProirityQueue<>((a,b)-> {
 *             for(int i=0; i< Math.min(a.length, b.length); i++){
 *                 if (a[i] != b[i]) {
 *                     return Integer.compare(b[i], a[i]); //reverse
 *                 }
 *             }
 *             return Integer.compare(b.length, a.length); //reverse
 * 
 *         });
 * 
 *     ?? if this ie mean heap 
 *
 * 
 */
