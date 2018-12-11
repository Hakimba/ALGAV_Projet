package tas.tree;

import java.util.ArrayList;

public class TasMinTree<E extends Comparable<E>> extends Tree<E> {
	
	private E lastEl;
	
	public TasMinTree() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public TasMinTree(Node<E> el) {
		super(el);
	}
	
	public void consIter(ArrayList<E> els) {
		for (int i = 0; i < els.size(); i++) {
			insert(els.get(i));
		}
	}
	public void insert(E el) {
		lastEl = el;
		nbelements++;
		binaryTransform();
		root = insert(null,root,el,binaryRepresentation.size()-1);
		
		//percolateUp();
	}
	public Node<E> insert(Node<E> father, Node<E> r, E el, int id) {
		if(root == null) {
			return new Node<E>(father,el,null,null);
		}
		else {
			if(r == null) {
				return new Node<E>(father,el,null,null);
			}
			else {
				if(binaryRepresentation.get(id) == 0) {
					r.setLeftson(insert(r,r.getLeftson(),el,id-1));
				}
				else {
					r.setRightson(insert(r,r.getRightson(),el,id-1));
				}
					
			}
		}
		return r;
	}
	
	public void setLastEl(Node<E> r,int id) {
		if(id < 0) {
			lastEl = r.getElement();
		}
		else {
			if(binaryRepresentation.get(id) == 0) {
				setLastEl(r.getLeftson(),id-1);
			}
			else if(binaryRepresentation.get(id) == 1) {
				setLastEl(r.getRightson(),id-1);
			}
		}
	}
	
	public E delMin() {
		if(root == null)
			return null;
		if(root.getElement() == lastEl)
			return root.getElement();
		
		E tmp = root.getElement();
		root = delMin(root,binaryRepresentation.size()-1);
		root.setElement(lastEl);
		nbelements--;
		binaryTransform();
		setLastEl(root,binaryRepresentation.size()-1);
		return tmp;
	}
	public Node<E> delMin(Node<E> r, int id) {
			if(id >= 0) {
				if(binaryRepresentation.get(id) == 0) {
					r.setLeftson(delMin(r.getLeftson(),id-1));
				}
				else if(binaryRepresentation.get(id) == 1) {
					r.setRightson(delMin(r.getRightson(),id-1));
				}
			}
			else {
				return null;
			}
			return r;
	}
	
	public void percolateUp() {
		
	}
	public void percolateDown() {
		
	}
}
