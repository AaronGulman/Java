import java.util.*;

public class VectorTesting {
    public static void main(String[] args) throws InterruptedException {

        int size = 1000000;
        List<Integer> arrayList = Collections.synchronizedList(new ArrayList<>());
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Added " + size + " elements to ArrayList in: " + (end - start) + "ms");

        List<Integer> vector = new Vector<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            vector.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Added " + size + " elements to Vector in: " + (end - start) + "ms");

        List<Integer> multithreadedList = new ArrayList<>();
        start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedList.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedList.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        end = System.currentTimeMillis();

        System.out.println("Added elements to a multithreaded way to ArrayList in: " + (end - start) + "ms");

        List<Integer> multithreadedVector = new Vector<>();
        start = System.currentTimeMillis();

        t1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedVector.add(i);
            }
        });
        t2 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedVector.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        end = System.currentTimeMillis();

        System.out.println("Added elements to a multithreaded way to Vector: " + (end - start) + "ms");

    }
}
