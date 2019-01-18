import java.util.concurrent.LinkedBlockingQueue;
import java.lang.Math;

public class Producer implements Runnable {
	private LinkedBlockingQueue<String> buffer;
	private static int produced = 0;
	private static Boolean done = false;
	private static String name;
	
	
	public Producer(LinkedBlockingQueue<String> _buffer, String _name) {
		buffer = _buffer;
		name = _name;
	}

	@Override
	public void run() {
		for(int i = 1; i < 1001; i ++) {
			if (i % 100 == 0) {
				System.out.println("(" + Producer.name + ")" + " Produced: " + i + " Strings.");	
			}
			
			try {
				String randStr = ((Double) Math.random()).toString();
				buffer.put(randStr);
				produced = i;
			} catch (InterruptedException e) {
				System.out.println("Interuppted: " + e);
			}
		}
		System.out.println("(" + Producer.name + ")" + " Production done. " + produced + " Strings produced.");
		done = true;
	}
	
	public static Boolean complete() {
		return done;
	}
}
