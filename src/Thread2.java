import java.util.ArrayList;
import java.util.Random;

public class Thread2 extends Thread{
   
    int total=0;

   
    @Override
    public void  run() {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rand = new Random();
        for (int index = 0; numbers.size() <= 50000000; index++) {
            numbers.add(rand.nextInt(10));
        }
        for(int index=0; index<numbers.size();index++){
            total+=numbers.get(index);
        }

    }

    public int returnTotal(){
        return total;
    }
    
}