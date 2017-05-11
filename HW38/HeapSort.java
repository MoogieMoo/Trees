// Maggie Xia
// APCS2 pd1
// HW38 -- Sort of Like Magic
// 2017-05-11

/*****************************************************
 * class HeapSort
 * Uses  ALHeap to sort a dataset
 *****************************************************/

import java.util.ArrayList;

public class HeapSort
{
    //instance vars
    private ArrayList<Integer> _data;
    private ALHeap _heap;

    /*****************************************************
     * default constructor  ---  inits empty heap and ALHeap
     *****************************************************/
    public HeapSort()
    {
	_heap = new ALHeap();
    }

    /*****************************************************
     * add(Integer) 
     * Inserts an element in the ALHeap to sort
     * Postcondition: element is placed in its final resting pos
     *****************************************************/
    public void add( Integer addVal ) 
    { 
	_heap.add( addVal );//add the value to the ALHeap
    }

    /*****************************************************
     * sort() 
     * Returs a sorted data set of the added values 
     *****************************************************/
    public ArrayList<Integer> sort() 
    { 
	while ( _heap.peekMin() != null ) {
	    _data.add( _heap.removeMin() );
	}
	return _data;
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	HeapSort pile = new HeapSort();

	//add in random values to sort
	for ( int i = 0; i < 6; i ++ ) {
	    int rand = (int) ( Math.random() * 50 ) + 1;
	    pile.add( rand );
	    System.out.println( "Adding " + rand + " to data set... " );
	}

	System.out.println( pile.sort() );//returns sorted data set
    }
    
}//end class HeapSort
