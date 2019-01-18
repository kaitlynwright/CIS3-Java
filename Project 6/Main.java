
public class Main {
	
	public static void main(String[] args) {
		OccurrenceSet<Integer> intSet = new OccurrenceSet<Integer>();
		intSet.add(1);
		intSet.add(6);
		intSet.add(3);
		intSet.add(5);
		intSet.add(5);
		intSet.add(3);
		intSet.add(3);
		intSet.add(3);
		
		System.out.println(intSet.size()); //size() method test
		
		OccurrenceSet<String> stringSet = new OccurrenceSet<String>();
		stringSet.add("hello");
		stringSet.add("world");
		stringSet.add("hello");
		stringSet.add("hello");
		stringSet.add("here");
		System.out.println(stringSet);
		System.out.println(stringSet.contains("hello")); //contains() method test
		
		stringSet.remove("hello");  // remove() method test
		System.out.println(stringSet);
		System.out.println(stringSet.contains("hello"));
		
		stringSet.clear();  // clear() method test
		System.out.println(stringSet);
		
		
	}
}
