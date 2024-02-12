package other;

import java.util.Arrays;

public class Heap
{
	//Declare the Heap
	private int[] Heap;
	
	//Declare the size variables of the heap
	private int size;
	private int maxsize;
	
	
	/** This method declares a new heap as an array
	 * @param maxsize the maximum number of nodes that the heap can type
	 * @param type the type of heap it is, whether a maximum or a minimum
	 */
	public Heap(int maxsize, String type)
	{
		
		//Set this heaps maximum size to be equal to the number set
		this.maxsize = maxsize;
		
		//set the initial size to 0
		this.size = 0;
		
		//Declare the heap as an array with a length 1 greater than the maximum size
		Heap = new int[maxsize + 1];
		
		//Check which type of heap it is
		switch(type)
		{
			//If the heap is a maximum heap, set the first position to be the maximum possible number
			case "max":
				Heap[0] = Integer.MAX_VALUE;
				break;
				
			//If the heap is a minimum heap, set the first position to be the minimum possible number
			case "min":
				Heap[0] = Integer.MIN_VALUE;
				break;
		
		}//end check type
		
		for (int i = 1; i < maxsize - 1; i++)
		{
			Heap[i] = 0;
		}
		
	}//end Heap
	
	/** Get the parent of a node
	 * @param pos
	 * @return pos/2
	 */
	public int getParent(int pos)
	{
		return pos/2;
	}
	
	/** Get the left child of a parent node
	 * @param pos
	 * @return 2 * pos
	 */
	public int getLeftChild(int pos)
	{
		return (2 * pos);
	}
	
	/** Get the right child of a parent node
	 * @param pos
	 * @return (2 * pos) + 1
	 */
	public int getRightChild(int pos)
	{
		return (2 * pos) + 1;
	}
	
	/** Check if a node is a leaf node i.e. doesn't have children
	 * @param pos
	 * @return boolean for if the node has children or not
	 */
	public boolean isLeafNode(int pos)
	{
		
		if (pos > (size / 2)) {
			return true;
		}

		return false;
	}
	
	/** Swaps two nodes in a heap
	 * @param pos1
	 * @param pos2
	 */
	public void swap(int pos1, int pos2)
	{
		int pos3;
		pos3 = Heap[pos1];

		Heap[pos1] = Heap[pos2];
		Heap[pos2] = pos3;
	}
	
	/** Insert a value as a node into a heap
	 * @param element
	 */
	public void insert(int element)
	{

		//Check if the size of the heap has reached its maximum, and exit the function if it has
		if (size >= maxsize) {
			return;
		}

		//If the size has not exceeded the maximum yet
		
		//Add the element to the last position in the heap
		Heap[++size] = element;
		
		//set a value to track the current size
		int current = size;

		if (Heap[0] == Integer.MIN_VALUE)
		{
			//This section will reorganize
			while (Heap[current] < Heap[getParent(current)]) {
				swap(current, getParent(current));
				current = getParent(current);
			}
		}
		else if (Heap[0] == Integer.MAX_VALUE)
		{
			//This section will reorganize
			while (Heap[current] > Heap[getParent(current)]) {
				swap(current, getParent(current));
				current = getParent(current);
			}
		}
	}

	/**
	 * Remove a node from a heap
	 * @param pos the position of the node to remove
	 */
	public void remove(int pos)
	{

		/*
		 * Replace the node to be removed with one of its children
		 * In a minimum heap, the smaller valued child replaces the parent node
		 * In a maximum heap, the larger valued child replaces the parent node
		 * After this, the heap is reorganized in order to accomodate for this change
		 */
		
		
		if (Heap[0] == Integer.MIN_VALUE)
		{
			Heap[pos] = Heap[getLeftChild(pos)] < Heap[getRightChild(pos)] ? getLeftChild(pos) : getRightChild(pos);
			heapify(pos);
		}
		else if (Heap[0] == Integer.MAX_VALUE)
		{
			Heap[pos] = Heap[getLeftChild(pos)] > Heap[getRightChild(pos)] ? getLeftChild(pos) : getRightChild(pos);
			heapify(pos);
		}
		
	}//end remove
	
	public void print()
	{
		
		System.out.println("ROOT : " + Heap[1]);
		
		for (int i = 2; i <= (size / 2); i++) {

			// Printing the parent and both childrens
			System.out.print(
					"\tPARENT : " + Heap[i]
							+ "\n\t\tLEFT CHILD : " + Heap[2 * i]
									+ "\n\t\tRIGHT CHILD : " + Heap[2 * i + 1]);

			// By here new line is required
			System.out.println();
		}
	}

	public void printAsArray()
	{
		System.out.println(Arrays.toString(Heap));
	}

	public int findIndex(int value)
	{
		for(int i = 1; i <= size / 2; i++)
		{
			if(Heap[i] == value)
			{
				return i;
			}
		}
		return -1;
	}

	
	/**This function reorganizes the heap
	 * @param pos the position to reorganize the heap
	 */
	public void heapify(int pos)
	{      
		//Check if the current node is a leaf node, and if not continue
		if(!isLeafNode(pos))
		{
			//declare the swap position variable
			int swapPos= pos;
			
			//Check if the right child exists
			if(getRightChild(pos)<=size)
			{
				//if its a minimum heap, find the lesser of the two children, and set the swap position to that child
				if (Heap[0] == Integer.MIN_VALUE)
				{
					swapPos = Heap[getLeftChild(pos)] < Heap[getRightChild(pos)] ? getLeftChild(pos) : getRightChild(pos);
				}//end if minimum heap
				
				//if its a maximum heap, find the greater of the two children, and set the swap position to that child
				else if (Heap[0] == Integer.MAX_VALUE)
				{
					swapPos = Heap[getLeftChild(pos)] > Heap[getRightChild(pos)] ? getLeftChild(pos) : getRightChild(pos);
				}//end if maximum heap
			}//end if right child exists
			
			//if the right child does not exist, set the swap position to the left child
			else
			{
				swapPos = getLeftChild(pos);
			}
			
			//If this is a minimum heap
			if (Heap[0] == Integer.MIN_VALUE)
			{
				//Check if the current node is greater than one of the children
				if(Heap[pos] > Heap[getLeftChild(pos)] || Heap[pos] > Heap[getRightChild(pos)]){
					//swap the two nodes
					swap(pos,swapPos);
					//call the heapify function again
					heapify(swapPos);
				}//end if node greater than child
			}//end if minimum heap
			
			//if this is a maximum heap
			else if (Heap[0] == Integer.MAX_VALUE)
			{
				//if the current node is less than one of the children
				if(Heap[pos] < Heap[getLeftChild(pos)] || Heap[pos] > Heap[getRightChild(pos)]){
					//swap the two nodes
					swap(pos,swapPos);
					//call the heapify function again
					heapify(swapPos);
				}//end if node is less than child
			}//end if maximum heap
		}//end if not leaf node       
	}//end heapify()

	public static void main(String[] args)
	{
		
		Heap Tasks = new Heap(13, "max");
		
		for (int a = 0; a < 9; a++)
		{
			int rnd = (int) (Math.random() * 20) + 1;
			Tasks.insert(rnd);
		}
		
		Tasks.print();
		
		Tasks.printAsArray();
		
		Tasks.insert(20);
		
		System.out.println("\n\n");
		
		Tasks.print();
		
		Tasks.printAsArray();
		
		
		
	}
	
	
}