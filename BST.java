/*****************************************************
 * class BST
 * <<< skeleton >>>
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST 
{
    //instance variables / attributes of a BST:
    private TreeNode root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) 
    {
	root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) 
    {
	//create new TreeNodes
	TreeNode thing = new TreeNode( newVal );
	TreeNode compare = root;

	//base case
	if ( root == null ) {
	    root = thing;
	    return;
	}

	for( ; ; ) {//infinitely running loop
	    //if newVal is less than the root, go to the left
	    if( compare.getValue() > newVal ) {
		//base case
		if ( compare.getLeft() == null ){
		    compare.setLeft( thing );
		    return;
		}
		else {
		    compare.getLeft().insert( newVal );
		}
	    }
	    //if newVal is more than the root, go to the right	    
	    else {
		//base case
		if ( compare.getRight() == null ){
		    compare.setRight( thing );
		    return;
		}
		else { 
		    compare.getRight().insert( newVal );
		}
	    }
	}


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav() 
    {
        if ( root != null ) {
	    TreeNode n = root;
	    System.out.print( n.getValue() + " " );
	    if ( n.getLeft() != null ) {
		n.getLeft().preOrderTrav();
	    }
	    if ( n.getRight() != null ) {
		n.getRight().preOrderTrav();
	    }
	}
    }

    public void inOrderTrav() 
    {
    	if ( root != null ) {
	    TreeNode n = root;	    
	    if ( n.getLeft() != null ) {
		n.getLeft().inOrderTrav();
	    }
	    System.out.print( n.getValue() + " " );
	    if ( n.getRight() != null ) {
		n.getRight().inOrderTrav();
	    }
	}
    }

    public void postOrderTrav() 
    {
    	if ( root != null ) {
	    TreeNode n = root;	    
	    if ( n.getLeft() != null ) {
		n.getLeft().postOrderTrav();
	    }
	    if ( n.getRight() != null ) {
		n.getRight().postOrderTrav();
	    }
	    System.out.print( n.getValue() + " " );
	}
    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main( String[] args ) 
    {
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  BST arbol = new BST();

	  arbol.insert( 4 );
	  arbol.insert( 2 );
	  arbol.insert( 5 );
	  arbol.insert( 6 );
	  arbol.insert( 1 );
	  arbol.insert( 3 );

	  System.out.println( "\npre-order traversal:" );
	  arbol.preOrderTrav();

	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav();
	
	  System.out.println( "\npost-order traversal:" );
	  arbol.postOrderTrav();	
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class
