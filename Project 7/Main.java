import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class Main {


	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(100);
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Producer producer1 = new Producer(queue, "Producer 1");
		
		Consumer consumer1 = new Consumer(queue, "Consumer 1");
		Consumer consumer2 = new Consumer(queue, "Consumer 2");
		Consumer consumer3 = new Consumer(queue, "Consumer 3");
		
		executor.execute(producer1);
		
		executor.execute(consumer1);
		executor.execute(consumer2);
		executor.execute(consumer3);
		
		
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.MINUTES);
	}
}
