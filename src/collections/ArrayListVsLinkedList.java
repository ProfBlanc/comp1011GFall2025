package collections;
import java.util.*;
public class ArrayListVsLinkedList {

    public static void main(String[] args) {

        example2();
    }

    static void example1(){

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        LinkedList<Double> linkedList = new LinkedList<>();

        linkedList.add(10D);

        byte n1 = (byte)10;
        short n2 = (short)10;
        arrayList1.add(100);
        // in Java, when you put a whole number, data type is assumed to
        // be integer. whole numbers => integer literals
        arrayList1.add(200);
        arrayList1.add(1, 150);

        int[] nums = {100,200};
        int index_to_override = 1;
        int value_to_add = 150;

        //step 1: make new arrray
        Integer[] nums_new = new Integer[nums.length + 1];
        //step 2: copy all values BEFORE index to insert
        for(int i = 0 ; i < index_to_override; i++){
            nums_new[i] = nums[i];
        }
        //step 3
        nums_new[index_to_override] = value_to_add;
        // step 4: copy all values AFTER index inser
        for(int i = index_to_override; i < nums.length; i++){
            nums_new[i] = nums[i];
        }

        //difference between iterator and for loo
        //Answer: as beginner, nothing
        //as advance personel, memics how program works

       Iterator<Integer> iterator1 = arrayList1.iterator();
        arrayList1.add(300);
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        ListIterator<Double> iterator2 = linkedList.listIterator();
        iterator2.previous();

        Object[] values = linkedList.toArray();

       List<Integer> a = Arrays.asList(nums_new);






























    }

    static void example2(){

        TreeSet<Integer> set1 = new TreeSet<>();
        set1.add(1);
        set1.add(100);
        set1.add(200);
        set1.add(-100);


       SortedSet<Integer> ss1 =  set1.tailSet(1);

       set1.addFirst(-200);
       set1.addLast(300);





























    }

    static void example3(){

        HashMap<String, Double> map1 = new HashMap<>();
        map1.put("Favourite", 123d);
        map1.put("Least Favourite", -987D);

        System.out.println(map1.get("Favourite"));

        Set<String> keys = map1.keySet();


    }





}
