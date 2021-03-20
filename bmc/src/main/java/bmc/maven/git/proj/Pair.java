package bmc.maven.git.proj;

import java.util.Comparator; 
import java.util.Map;

public class Pair<K,V> implements Map.Entry<K,V>{
	private K key;
	private V value;

	private Pair (K key, V value) {
		this.key = key; // better to do do defencive coping so user wont have access to keys from outside
		this.value = value;
	}

	public static <K,V> Pair<K,V> of(K key, V value){
		return new Pair<>(key, value);
	}

	public static <K,V> Pair<V,K> swap(Pair<K,V> pair){
		return new Pair<V,K>(pair.getValue(), pair.getKey()); //gerg prefers not to use infer - more excplicit type saftey
	}

	public static <T extends Comparable<T>> Pair<T,T>  minMax(T[] arr){//1.5n
		Comparator<T> cmp = (c1, c2) -> c1.compareTo(c2);

		return minMax(arr, cmp);
	}
	public static <T> Pair<T,T> minMax(T[] arr, Comparator<T> cmp){
		T min = arr[0], max = arr[0];    
		int start = 0, end = arr.length-1;

		while(start <= end) {
			if(cmp.compare(arr[start],arr[end]) > 0){
				if(cmp.compare(arr[start], max) > 0) {
					max = arr[start];
				} 
				if (cmp.compare(arr[end], min) < 0) {
					min = arr[end];
				}
			} else {
				if(cmp.compare(arr[end], max) > 0) {
					max = arr[end];
				} 
				if (cmp.compare(arr[start], min) < 0) {
					min = arr[start];
				}
			}
			++start;
			--end;
		}

		return new Pair<T,T>(min, max);
	}
	public K setKey(K key) {
		K oldKey = this.key;
		this.key = key;
		return oldKey;
	}
	@Override
	public K getKey() {
		return key;
	}
	@Override
	public V setValue(V value) {
		V oldVal = this.value;
		this.value = value;
		return oldVal;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return getKey().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair<K,V> other = (Pair<K,V>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	public boolean equals(Pair<K,V> obj) {
		return key.equals(obj.key);
	}
}

