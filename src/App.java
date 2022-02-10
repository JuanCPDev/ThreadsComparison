import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> numbers = new ArrayList<>();
        Random rand = new Random();
        int total = 0;

        // Single thread
        long startTime = System.nanoTime();
        for (int index = 0; numbers.size() <= 200000000; index++) {
            numbers.add(rand.nextInt(10));
        }
        for (int index = 0; index < numbers.size(); index++) {
            total += numbers.get(index);
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime + "ns for single threads");
        System.out.println(total + " total Single thread");

        // 2 Threads
        startTime = System.nanoTime();
        Thread1 oneHalf = new Thread1();
        Thread1 secondHalf = new Thread1();

        oneHalf.start();
        secondHalf.start();
        oneHalf.join();
        secondHalf.join();

        endTime = System.nanoTime();
        System.out.println(endTime - startTime + "ns for x2 threads");
        System.out.println(oneHalf.returnTotal() + secondHalf.returnTotal() + " total x2 threads");

        //4 threads
        startTime = System.nanoTime();
        Thread2 oneQuater = new Thread2();
        Thread2 twoQuater = new Thread2();
        Thread2 threeQuater = new Thread2();
        Thread2 fourQuater = new Thread2();

        oneQuater.start();
        twoQuater.start();
        threeQuater.start();
        fourQuater.start();
        oneQuater.join();
        twoQuater.join();
        threeQuater.join();
        fourQuater.join();

        endTime = System.nanoTime();
        System.out.println(endTime - startTime + "ns for x4 threads");
        System.out.println(oneQuater.returnTotal() + twoQuater.returnTotal()+threeQuater.returnTotal() +fourQuater.returnTotal() + " total x4 threads");

    }
}
