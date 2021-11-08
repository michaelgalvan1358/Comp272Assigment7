import java.util.*;

public class Selection<E extends Comparable<E>> {
    List<E> ints;
    static int k;

    public Selection(){
        ints = new ArrayList<>();
        k =0;
    }
    public void setK(int l)
    {
        k =l;
    }
    public static int findKthLargest(List<Integer> ints)
    {
        if (ints == null || ints.size() < k) {
            System.exit(-1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(ints.subList(0, k));

        // do for remaining array elements
        for (int i = k; i < ints.size(); i++)
        {
            // if the current element is more than the root of the heap
            if (ints.get(i) > pq.peek())
            {
                //System.out.println("hi");
                // replace root with the current element
                pq.poll();
                pq.add(ints.get(i));
            }
        }

        // return the root of min-heap
        return pq.peek();
    }
    public static int findKthSmallest(List<Integer> ints)
    {
        if (ints == null || ints.size() < k) {
            System.exit(-1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(ints.subList(k -1 , ints.size() ));
        //the root is the poistion of k smallest to the highest values,index 0 is the kth smallest poistion
        return pq.peek();
    }
    public void bubbleSort(List<Integer> array) {
        //for n 100000 the time this would take is 89 seconds and 60 milli seconds
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.size() - j; i++) {
                if (array.get(i) > array.get(i+1)) {
                    tmp = array.get(i);
                    array.set(i,array.get(i+1)) ;
                    array.set(i+1,tmp);
                    swapped = true;
                }
            }
        }
        System.out.println(array);
    }

     public static void main(String[] args)
    {

        //Arrays.asList(7, 4, 6, 3, 9, 1);
        Selection s1 = new Selection();
        s1.setK(50000);

        for(int i =1; i<=100000;i++)
        {
            s1.ints.add((int)Math.floor(Math.random()*(100000)+1));
        }
        //System.out.println(ints);
        long start = System.currentTimeMillis();
        s1.bubbleSort(s1.ints);     //when using example of n = 1799868 it took more then 30 mins to finish
        long end = System.currentTimeMillis();

        System.out.println("Total time of sort is: " + ((end -start)/1000) + " seconds and " + ((end-start)%1000) + " milliseconds");
        start = System.currentTimeMillis();
        System.out.println("k'th smallest array element is " + findKthSmallest(s1.ints));
        end = System.currentTimeMillis();
        System.out.println("Total time of A is: " + ((end -start)/1000) + " seconds and " + ((end-start)%1000) + " milliseconds");
        start = System.currentTimeMillis();
        System.out.println("k'th largest array element is " + findKthLargest(s1.ints));
        end = System.currentTimeMillis();
        System.out.println("Total time of B is: " + ((end -start)/1000) + " seconds and " + ((end-start)%1000) + " milliseconds");
    }
}
