import java.util.*;
import java.util.Map.Entry;

public class OccurrenceSet<T> implements Set<T>{
	
	HashMap<T, Integer> hashMap = new HashMap<T, Integer>();

	@Override
	public int size() {
		return hashMap.size();
	}

	@Override
	public boolean isEmpty() {
		return hashMap.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return hashMap.containsKey(o);
	}

	@Override
	public Iterator<T> iterator() {
		Set<Map.Entry<T, Integer>> entries = hashMap.entrySet();
		ArrayList<Map.Entry<T, Integer>> sortMap = new ArrayList<Map.Entry<T, Integer>>(entries);
		ArrayList<T> sortKeys = new ArrayList<T>();
		
		Collections.sort(sortMap, new Comparator<Map.Entry<T, Integer>>() {

				@Override
				public int compare(Entry<T, Integer> o1, Entry<T, Integer> o2) {
					return o1.getValue().compareTo(o2.getValue());
				}
		});
		for(Map.Entry<T, Integer> entry : sortMap) {
			sortKeys.add(entry.getKey());
		}
		return sortKeys.iterator();
	}

	@Override
	public Object[] toArray() {
		Iterator<T> mapIterate = iterator();
		ArrayList<T> sortArray = new ArrayList<T>();
		
		while (mapIterate.hasNext() ) {
			sortArray.add(mapIterate.next());
		}
		return sortArray.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		ArrayList<T> sortArray = new ArrayList<T>();
		Iterator<T> iterate = (Iterator<T>) iterator();
		
		while(iterate.hasNext()) {
			sortArray.add(iterate.next());
		}
		return sortArray.toArray(a);
	}

	@Override
	public boolean add(T e) {
		int value = 1;
		
		if (hashMap.containsKey(e)) {
			value = hashMap.get(e) + 1;
		}
		
		return hashMap.put(e, value) != null;
	}

	@Override
	public boolean remove(Object o) {
		return hashMap.remove(o, hashMap.get(o));
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean output = false;
		
		for (Object o : c) {
			output = contains(o);
		}
		return output;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		
		boolean output = false;
		
		for (T entry : c) {
			output = add(entry);
		}
		return output;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		
		boolean output = false;
		
		for (Object o : c) {
			if(c.contains(hashMap.get(o))) {
				output = remove(o);
			}
		}
		return output;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean output = false;
		
		for(Object o : c) {
			output = remove(o);
		}
		return output;
	}

	@Override
	public void clear() {
		hashMap.clear();
	}
	
	public String toString() {
		Iterator<T> iterate = iterator();
		ArrayList<T> string = new ArrayList<T>();
		
		while(iterate.hasNext()) {
			string.add(iterate.next());
		}
		return "" + string + "";
	}
}
