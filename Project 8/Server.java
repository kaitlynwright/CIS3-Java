import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	private static final int port = 1337;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		
		try {
			serverSocket = new ServerSocket(port);
			socket = serverSocket.accept();
			
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			inputStream = new ObjectInputStream(socket.getInputStream());
		
			numberList = (ArrayList<Integer>) inputStream.readObject();
			System.out.println("Server Recieved: " + numberList);
			
			for (Integer number : numberList) {
				if (isPrime(number)) {
					primeList.add(number);
				}
			}	
			outputStream.writeObject(primeList);
			outputStream.flush();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
				if (socket!= null) {
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
	
	public static Boolean isPrime(Integer number) {
		if(number < 2) {
			return false;
		}
		if (number == 2) {
			return true;
		}
		if (number % 2 == 0) {
			return false;
		}
		for (int i = 3; i*i <= number; i+=2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;	
	}
}
