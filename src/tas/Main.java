package tas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

import arbrerecherche.SearchTree;
import tas.array.TasArray;
import tas.tree.Node;
import tas.tree.TasMinTree;

public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TasMinTree heap = new TasMinTree();
		TasMinTree heap2 = new TasMinTree();
		
		BigInteger k1 = new BigInteger("0x9c1f03a0d9cf510f2765bd0f226ff5dc".substring(2),16);
		BigInteger k2 = new BigInteger("0x10fd1015413104a2f26018d0ab77a727".substring(2),16);
		BigInteger k3 = new BigInteger("0x2e73d8ce4bd45923286e966bc8cf2d95".substring(2),16);
		BigInteger k4 = new BigInteger("0x767accd0c60c603f71a68be994019c7e".substring(2),16);
		BigInteger k5 = new BigInteger("0x34c63c08abab99722b945e57081288e7".substring(2),16);
		BigInteger k6 = new BigInteger("0x6d481adc2aeed025f0374a5982b5c23c".substring(2),16);
		
		System.out.println(k2);
		System.out.println(k3);
		System.out.println(k5);
		System.out.println(k4);
		System.out.println(k1);
		
		System.out.println("\n ajout de k1 et k2 ");
		heap.consIter(new BigInteger[] {k1,k2});
		heap.prefix();
		System.out.println("\n ajout de k3 k4 k5");
		heap.consIter(new BigInteger[] {k3,k4});
		heap2.consIter(new BigInteger[] {k5,k6});
		System.out.println("heap 1 : ");
		heap.prefix();
		System.out.println("\nheap2 : ");
		heap2.prefix();
		System.out.println("\n");
		(TasMinTree.union(heap, heap2)).prefix();
		heap.binaryTransform(4);
		//System.out.println("NB : "+heap.getNbElements());
		
		//System.out.println("après del min : "+heap.delMin());
		
		
		
		//System.out.println(heap.root.getLeftson().getElement());
		//System.out.println(heap.root.getRightson().getElement());
		 //Test du tas array
		/*TasArray tas = new TasArray(4);
		TasArray tas2 = new TasArray(4);
		
		//Affichage du tas array en arbre
		BigInteger k1 = new BigInteger("0x9c1f03a0d9cf510f2765bd0f226ff5dc".substring(2),16);
		BigInteger k2 = new BigInteger("0x10fd1015413104a2f26018d0ab77a727".substring(2),16);
		BigInteger k3 = new BigInteger("0x2e73d8ce4bd45923286e966bc8cf2d95".substring(2),16);
		BigInteger k4 = new BigInteger("0x767accd0c60c603f71a68be994019c7e".substring(2),16);
		BigInteger k5 = new BigInteger("0x34c63c08abab99722b945e57081288e7".substring(2),16);
		BigInteger k6 = new BigInteger("0x6d481adc2aeed025f0374a5982b5c23c".substring(2),16);
		
		System.out.println("k1 "+k1);
		System.out.println("k2 "+k2);
		System.out.println("k3 "+k3);
		System.out.println("k4 "+k4);
		System.out.println("k5 "+k5);
		System.out.println("k6 "+k6);
		
		tas.consIter(new BigInteger[] {k1,k2,k3,k4});
		tas2.consIter(new BigInteger[]{k4,k5,k6});
		System.out.println("TAS 1 -------------------");
		System.out.println(tas);
		System.out.println("\nTAS 2 -------------------");
		System.out.println(tas2);
		
		tas.delMin();
		System.out.println("TAS 1 -------------------");
		System.out.println(tas);
		/*TasArray tasUnifie = TasArray.union(tas, tas2);
		System.out.println("\nTAS UNIFIÉ -------------------");
		System.out.println(tasUnifie);
		System.out.println(tasUnifie.capacity());
		System.out.println(tasUnifie.size());*/
		
		//arbre de recherche*/
		/*BufferedReader reader = null;
		SearchTree st = new SearchTree();

		try {
		    File file = new File("data/cles_alea/jeu_1_nb_cles_100.txt");
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    while ((line = reader.readLine()) != null) {
		    	BigInteger bi = new BigInteger(line.substring(2),16);
		        st.insert(bi);
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		System.out.println(st.getNbElements());
		System.out.println(st.search(new BigInteger("0x5eb1d3c4446ded76df352f88b1e44179".substring(2),16)));
		st.prefix();*/
		
		
	}

}
