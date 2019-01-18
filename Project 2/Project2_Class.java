import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Project2_Class {
	public static void main(String[] args) {
		int arrayLength = 0;
		double arrayDensity = -1;
		Scanner input = new Scanner(System.in);
	
		while (arrayLength <=0) {
			System.out.println("Enter Array Length: ");
			arrayLength = input.nextInt();
		}
	
		while (arrayDensity < 0.0 || arrayDensity > 1.0 ) {
			System.out.println("Enter Array Density: ");
			arrayDensity = input.nextDouble();	
		}
	}
	
	// Question 2
	public static int[] createDenseArray (int length, double density) {
		final long starttime = System.nanoTime();
		int[] a = new int[length];
		for (int i = 0; i < length; i++) {
			Random rand = new Random();
			if (density < rand.nextDouble()) {
				a[i] = 0;
			}
			else {
				a[i] = rand.nextInt(1000000);
			}
		} 
		final long endtime = System.nanoTime();
		final double time = (double)(endtime - starttime)/1000000;
		System.out.print("Run Time: " + time + "milliseconds");
		return a;
	}	
	
	// Question 3
	public static ArrayList<int[]> createSparseArray (int length, double density) {
		final long starttime = System.nanoTime();
		ArrayList<int[]> array = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			Random rand = new Random();
			if (density < rand.nextDouble()) {
				int[] a = new int[2];
				a[0] = i;
				a[1] = rand.nextInt(1000000);
				array.add(a);
			}
		}
		final long endtime = System.nanoTime();
		final double time = (double)(endtime - starttime)/1000000;
		System.out.print("Run Time: " + time + "milliseconds");
		return array;	
	}
	
	// Question 4
	public static ArrayList<int[]> DenseToSparse (int[] densearray) {
		final long starttime = System.nanoTime();
		ArrayList<int[]> sparsearray = new ArrayList<>();
		for (int i = 0; i < densearray.length; i++) {
			if (densearray[i] != 0) {
				int[] a = new int[2];
				a[0] = i;
				a[1] = densearray[i];
				sparsearray.add(a);			
			}
		}
		final long endtime = System.nanoTime();
		final double time = (double)(endtime - starttime)/1000000;
		System.out.print("Run Time: " + time + "milliseconds");
		return sparsearray;
	}
	
	// Question 5
	public static int[] SparseToDense (ArrayList<int[]> sparsearray, int arrayLength) {
		final long starttime = System.nanoTime();
		int[] densearray = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			densearray[i] = 0;
		}
		
		for (int i = 0; i < sparsearray.size(); i++) {
			int[] smallarray = sparsearray.get(i);
			int index = smallarray[0];
			int value = smallarray[1];
			densearray[index] = value;
		}
		final long endtime = System.nanoTime();
		final double time = (double)(endtime - starttime)/1000000;
		System.out.print("Run Time: " + time + "milliseconds");
		return densearray;
	}
	
	// Question 6
	public static void MaxValue_Dense (int[] densearray) {
		final long starttime = System.nanoTime();
		int maxvalue = 0;
		int index = 0;
		for (int i = 0; i < densearray.length; i++) {
			if (maxvalue < densearray[i]) {
				maxvalue = densearray[i];
				index = i;
			}
		}
		final long endtime = System.nanoTime();
		final double time = (double)(endtime - starttime)/1000000;
		System.out.print("Run Time: " + time + "milliseconds");
		System.out.println("Max Value: " + maxvalue);
		System.out.println("Index: " + index);
	}
	
	// Question 7
	public static void MaxValue_Sparse (ArrayList<int[]> sparsearray) {
		final long starttime = System.nanoTime();
		int maxvalue = 0;
		int index = 0;
		for (int i = 0; i < sparsearray.size(); i++) {
			int[] smallarray = sparsearray.get(i);
			if (smallarray[1] > maxvalue) {
				maxvalue = smallarray[1];
				index = smallarray[0];
			}
		}
		final long endtime = System.nanoTime();
		final double time = (double)(endtime - starttime)/1000000;
		System.out.print("Run Time: " + time + "milliseconds");
		System.out.println("Max Value: " + maxvalue);
		System.out.println("Index: " + index);
	}
}

				