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
    TreeNode root;


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

	//base case
	if ( root == null ) {
	    root = thing;
	    return;
	}
        insert( root, thing );
    }

    //recursive helper for insert(int)
    public void insert( TreeNode stRoot, TreeNode newNode ) {

	if ( newNode.getValue() < stRoot.getValue() ) {
	    //if no left child, make newNode the left child
	    if ( stRoot.getLeft() == null )
		stRoot.setLeft( newNode );
	    else //recurse down left subtree
		insert( stRoot.getLeft(), newNode );
	    return;
	}
	else { // new val >= curr, so look down right subtree
	    //if no right child, make newNode the right child
	    if ( stRoot.getRight() == null )
		stRoot.setRight( newNode );
	    else //recurse down right subtree
		insert( stRoot.getRight(), newNode );
	    return;
	}
    }



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav() 
    {
	preOrderTrav( root );//call overloaded preOrderTrav()	    
    }

    public void preOrderTrav( TreeNode t ) {
	if ( t == null ) { return; }
	System.out.print( t.getValue() + " " );//root-left-right
	preOrderTrav( t.getLeft() );
	preOrderTrav( t.getRight() );
    }

    public void inOrderTrav() 
    {
	inOrderTrav( root );//call overloaded inOrderTrav()	     	
    }

    public void inOrderTrav( TreeNode t ) {
	if ( t == null ) { return; }
	inOrderTrav( t.getLeft() );
	System.out.print( t.getValue() + " " );//left-root-right
	inOrderTrav( t.getRight() );
    }

    public void postOrderTrav() 
    {
	    postOrderTrav( root );//call overloaded postOrderTrav()
    }

    public void postOrderTrav( TreeNode t ) {
	if ( t == null ) { return; }
	postOrderTrav( t.getLeft() );
	postOrderTrav( t.getRight() );
	System.out.print( t.getValue() + " " );//left-right-root
    }

    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
    	TreeNode t = root;
	TreeNode l = t.getLeft();
	TreeNode r = t.getRight();

	while ( l != null || r != null ) {
	    if ( t.getValue() == target ) {
		return t;
	    }
	    else if ( t.getValue() > target ) {
		t = t.getLeft();
		return t;
	    }
	    else if ( t.getValue() < target ) {
		t = t.getRight();
		return t;
	    }
	}
	return null;
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
    	return height( root );//call overloaded height()
    }

    public int height( TreeNode t ) {
	TreeNode l = t.getLeft();
	TreeNode r = t.getRight();

	if ( l == null ) {
	    if ( r == null ) {
		return 1;
	    }
	}
	else if ( l == null ) {
	    return height( r ) + 1;
	}
	else if ( r == null ) {
	    return height( l ) + 1;
	}
	else {
	    if ( height( l ) > height( r ) ) {
		return height( l ) + 1;
	    }
	    else if ( height( r ) > height( l ) ) {
		return height( r ) + 1;
	    }
	}
	return 0;
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return numLeaves( root );//call overloaded numLeaves()
    }

    public int numLeaves( TreeNode t ) {
	TreeNode l = t.getLeft();
	TreeNode r = t.getRight();

	if ( l == null ) {//tree only has root
	    if ( r == null ) {
		return 1;
	    }
	}
	else if ( l == null ) {
	    return numLeaves( r );
	}
	else if ( r == null ) {
	    return numLeaves( l );
	}
	else {
	    return numLeaves( l ) + numLeaves( r );
	}
	return 0;
    }

    //main method for testing
    public static void main( String[] args ) 
    {
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
	  System.out.println();
	  //insert your new test calls here...

	  System.out.println( "Testing search..." );
	  System.out.println( arbol.search( 1 ) );
	  System.out.println( arbol.search( 3 ) );

	  System.out.println( "Testing height..." );
	  System.out.println( arbol.height() );

	  System.out.println( "Testing numLeaves..." );
	  System.out.println( arbol.numLeaves() );
	  
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class
