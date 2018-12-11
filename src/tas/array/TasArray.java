package tas.array;

import java.math.BigInteger;
import java.util.Arrays;

public class TasArray {
	private int currentSize = 1;
	private int capacity;
	private BigInteger[] elements;
	
	public int size() {
		return currentSize-1;
	}
	public int capacity() {
		return capacity;
	}
	
	public TasArray() {
		// TODO Auto-generated constructor stub
	}
	
	public TasArray(int cap) {
		capacity = cap;
		elements = new BigInteger[capacity];
	}
	
	public TasArray(int cap, BigInteger[] elts) {
		capacity = cap;
		currentSize = elts.length;
		elements = new BigInteger[capacity];
		for (int i = 0; i < elts.length; i++) {
			elements[i] = elts[i];
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private void doubleCapacity() {
		capacity*=2;
		BigInteger[] newElts = new BigInteger[capacity];
		for (int i = 0; i < currentSize; i++) {
			newElts[i] = elements[i];
		}
		elements = newElts;
	}
	

	public void insert(BigInteger el) {
		if(currentSize == capacity)
			doubleCapacity();
		elements[currentSize] = el;
		percolate_up();
		currentSize++;
	}
	
	public void percolate_up() {
		BigInteger el = elements[currentSize];
		int placeEl = currentSize;
		while(elements[1] != el && el.compareTo(elements[placeEl/2]) == -1) {
				BigInteger father = elements[placeEl/2];
				elements[placeEl/2] = el;
				elements[placeEl] = father;
				placeEl = placeEl/2;
		}
	}

	public void percolate_down() {
		int placeEl  = 1;
		int leftson  = placeEl*2;
		int rightson = leftson+1;
		while((elements[placeEl].compareTo(elements[leftson]) == 1 || elements[placeEl].compareTo(elements[rightson]) == 1) && leftson < this.currentSize) {
			BigInteger son;
			int idson;
			if(elements[leftson].compareTo(elements[rightson])>=0) {
				son = elements[rightson];
				idson = rightson;
			}
				
			else {
				son = elements[leftson];
				idson = leftson;
			}
			elements[idson] = elements[placeEl];
			elements[placeEl] = son;
			placeEl = idson;
			leftson  = placeEl*2;
			rightson = leftson+1;
		}
	}
	
	public void consIter(BigInteger[] elts) {
		for (int i = 0; i < elts.length; i++) {
			insert(elts[i]);

		}
		
	}
	
	public BigInteger delMin() {
		if(currentSize > 0) {
			BigInteger root = elements[1];
			elements[1] = elements[size()];
			currentSize--;
			percolate_down();
			return root;
		}
		return null;
	}

	
	public static TasArray union(TasArray t1, TasArray t2) {
		TasArray t3 = new TasArray(t1.capacity+t2.capacity);
		t3.consIter(Arrays.copyOfRange(t1.elements, 1, t1.size())); // on commence a insérer a 1 donc ici on prend le tableau privé de la première case vide
		t3.consIter(Arrays.copyOfRange(t2.elements, 1, t2.size()));
		return t3;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("[");
		for (int i = 1; i < currentSize; i++) {
			if(i == (currentSize- 1))
				str.append(elements[i]);
			else
				str.append(elements[i]+":");
		}
		str.append("]");
		return str.toString();
		/*String delimiter = "  ";
		int tabulationLevel = (int)Math.ceil((Math.log(size())/Math.log(2)));
		StringBuilder tree = new StringBuilder();
		int currentLevel = 0;
		Log2 log2 = (n) -> { return (int)(Math.log(n)/Math.log(2));};
		
		for (int i = 1; i < size(); i++) {
			int k = i+1;
			if(k == 1) {
				for (int j = 0; j < tabulationLevel+1; j++) {
					tree.append(delimiter);
				}
				tree.append(elements[i]);
			}
			else {
				if(log2.calcul(k) == currentLevel) {
					for (int j = 1; j < tabulationLevel; j++) {
						tree.append(delimiter);
					}
					tree.append(elements[i]);
					if(k == size())
						tree.append('\n');
				}
				else {
					tree.append('\n');
					tabulationLevel--;
					currentLevel++;
					for (int j = 1; j < tabulationLevel+1; j++) {
						tree.append(delimiter);
					}
					tree.append(elements[i]);
					if(k == size())
						tree.append('\n');
				}
			}
				
		}
		return tree.toString();*/
		
	}

}
