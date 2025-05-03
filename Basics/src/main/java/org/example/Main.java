package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /** List Interface */
//        List<String> names = new ArrayList<>();
        List<String> names = new LinkedList<>();

        names.add("Hanie");
        names.add("Hossein");
        names.add("John");
        names.add("Eric");

        Collections.reverse(names);
        System.out.println(names);
//
//        for (String s : names){
//            System.out.println(s);
//        }
//
//        System.out.println("Second name is "+names.get(1));
//
//        names.set(3,"Alice");
//        System.out.println("New list : "+names);
//
//        names.remove("Alice");
//        System.out.println("Updated list : "+names);


        /** Set Interface */
////        Set<String> namesSet = new HashSet<String>();
////        Set<String> namesSet = new TreeSet<>();
//        Set<String> namesSet = new LinkedHashSet<>();
//        namesSet.add("Hanie");
//        namesSet.add("Hossein");
//        namesSet.add("Hossein");
//        namesSet.add("Alice");
//        System.out.println(namesSet);

//        Set<Integer> a = new HashSet<Integer>();
//        a.addAll(Arrays.asList(new Integer[] {1,2,3,5,7,8,23}));
//
//        Set<Integer> b = new HashSet<Integer>();
//        b.addAll(Arrays.asList(new Integer[]{4,2,6,12,5}));
//
//        Set<Integer> union = new HashSet<>(a);
//        union.addAll(b);
//        System.out.println("Union of a and b : "+union);
//
//        Set<Integer> intersection = new HashSet<Integer>(a);
//        intersection.removeAll(b);
//        System.out.println("Intersection ofa and b : "+intersection);
//        System.out.println(a.contains(4));
//        a.remove(1);
//        System.out.println(a);
//
//        Iterator<Integer> numbers = a.iterator();
//        while (numbers.hasNext()){
//            System.out.println(numbers.next());
//        }
//
//        Set<status> statuses ;
//        statuses = EnumSet.of(status.PAID,status.UNPAID,status.PENDING);
//        System.out.println(statuses);
        /** Map Interface */
//        HashMap<String, Integer> localStorage = new HashMap<>();
//        HashMap<String, Integer> localStorage = new LinkedHashMap<>();
//        Map<String, Integer> localStorage = new TreeMap<>();

//        localStorage.put("token",2333);
//        localStorage.put("password",99333023);
//        System.out.println(localStorage);
//
//        for (Map.Entry<String,Integer> m : localStorage.entrySet()){
//            System.out.println(m.getKey()+" : "+m.getValue());
//        }
//        System.out.println(localStorage.get("token"));
//        localStorage.remove("token");
//        System.out.println(localStorage.get("token"));
        /** Queue Interface */
//        Queue<String> queue = new LinkedList<>();//FIFO
//        queue.add("task1");
//        queue.add("task2");
//        queue.add("task3");
//        queue.add("task4");
//        System.out.println(queue);
//
//        String peek = queue.peek();
//        System.out.println(queue.size()+" Peek : "+peek);
//
//        String front = queue.remove();
//        System.out.println(queue+" Front : "+front);
//
//        Queue<String> pq1 = new PriorityQueue<>();
//
//        pq1.add("Geeks");
//        pq1.add("For");
//        pq1.add("Geeks");
//
//        System.out.println(pq1);
//
//        Iterator<String> iterator = pq1.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//        // Creating empty priority queue
//        Queue<Integer> pq2
//                = new PriorityQueue<Integer>();
//
//        // Adding items to the pQueue
//        // using add()
//        pq2.add(10);
//        pq2.add(20);
//        pq2.add(15);
//
//        // Printing the top element of
//        // the PriorityQueue
//        System.out.println(pq2.peek());
//
//        // Printing the top element and removing it
//        // from the PriorityQueue container
//        System.out.println(pq2.poll());
//
//        // Printing the top element again
//        System.out.println(pq2.peek());
    }
    enum status {PAID , UNPAID , PENDING};
}