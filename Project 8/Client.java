import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	private static final int port = 1337;
	
	public static void main(String[] args) {
		Socket socket = null;
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		
		try {
			InetAddress address = InetAddress.getLocalHost();
			socket = new Socket(address, port);
			
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
		
			inputStream = new ObjectInputStream(socket.getInputStream());
			
			Scanner input = new Scanner(System.in);
			System.out.println("Enter an integer (! to send): ");
			
			while(true) {
				String inputStr = input.next();
				if (inputStr.compareTo("!") == 0) {
					outputStream.writeObject(numberList);
					outputStream.flush();
					System.out.println("Client sent: " + numberList);
					break;
				}
					try {
						Integer number = Integer.parseInt(inputStr);
						numberList.add(number);
						System.out.println("Enter an integer (! to send): ");	
					
					} catch (NumberFormatException ex) {
						ex.printStackTrace();
						System.out.println("Invalid input type. Enter an integer (! to send): ");
					}
			}
			primeList = (ArrayList<Integer>) inputStream.readObject();
			System.out.print("Client recieved: " + primeList);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			try {
				
				if (socket != null) {
					socket.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
