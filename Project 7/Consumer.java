import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable {
	private LinkedBlockingQueue<String> blockingQueue;
	private String name;
	private int consumed;
	
	public Consumer(LinkedBlockingQueue<String> _queue, String _name) {
		blockingQueue = _queue;
		name = _name;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(name);
		
		while(!blockingQueue.isEmpty() || !Producer.complete()) {
			
			try {
				String data = blockingQueue.take();
				if (data != null) {
					consumed += 1;
			
					if(consumed % 100 == 0) {
						System.out.println("(" + Thread.currentThread().getName() + ")" + " Consumed: " + consumed + " Strings.");
					}
				}	
				Thread.sleep((long)(Math.random() * 10));
				
			} catch (InterruptedException e) {
				System.out.println("Interuppted: " + e);
			}
		}
		
		System.out.println("(" + Thread.currentThread().getName() + ")" + " Consumption done. " + consumed + " Strings consumed.");
	}
}
