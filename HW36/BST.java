// Maggie Xia
// APCS2 pd1
// HW36 -- Prune Your Tree
// 2017-05-06

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
    public void insert( TreeNode old, TreeNode node ) {

	if ( node.getValue() < old.getValue() ) {//go down left	    
	    if ( old.getLeft() == null )
		old.setLeft( node );
	    else //recurse down left subtree
		insert( old.getLeft(), node );
	    return;
	}
	else {//go down right
	    if ( old.getRight() == null )
		old.setRight( node );
	    else //recurse down right subtree
		insert( old.getRight(), node );
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
	return search( target, root );
    }

    TreeNode search( int target, TreeNode node ) {
	//base case
	if ( node == null || node.getValue() == target ) {
	    return node;
	}
	else if ( target < node.getValue() ) {
	    return search( target, node.getLeft() );
	}
	else if ( target > node.getValue() ) {
	    return search( target, node.getRight() );
	}
	else {
	    return null;
	}
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
	//base case
	if ( t == null ) {
	    return 0;
	}
	else {
	    return 1 + Math.max( height( t.getLeft() ),
				 height( t.getRight() ));
	}	
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
	//base case
	if ( t == null ) {
	    return 0;
	}
	int leaves = 0;
	leaves += numLeaves( t.getLeft() );
	if ( isLeaf( t ) ) {
	    leaves += 1;
	}
	leaves +=numLeaves( t.getRight() );
	return leaves;
    }

    /*****************************************************
     * TreeNode remove( int )
     * if remVal is present, removes it from tree
     * Assumes no duplicates in tree.
     *****************************************************/    
    public TreeNode remove( int remVal )
    {
	TreeNode leader = root;  
	TreeNode follower = null; //piggybacker

	//first, walk leader down to target node w/ follower trailing...
	while ( leader.getValue() != remVal ) {
	    //keep follower one step behind
	    follower = leader;
	    //set leader to the TreeNode whose value is remVal
	    if ( leader.getValue() > remVal ) {
		leader = leader.getLeft();
	    }
	    else {
		leader = leader.getRight();
	    }
	}
	
	//CASE 1: removal node is a leaf
	//action: snip it
	if ( isLeaf(leader) ) {
	    //subcase: 1-node tree
	    if ( follower = null ) {
		leader = null;
	    }

	    //subcase: removal node is a left child
	    if ( follower.getLeft().equals( leader ) ) {
		follower.setLeft( null );
	    }

	    //subcase: removal node is a right child
	    if ( follower.getRight().equals( leader ) ) {
		follower.setRight( null );
	    }
	}

	//CASE 2: removal node has 1 subtree
	//action: replace node with only child
	else if ( leader.getRight()== null ) { //rem node's child is on left

	    //subcase: removal node is root
	    if ( follower == null ) {
		root = root.getLeft();
	    }

	    //subcase: removal node is a left child
	    if ( follower.getLeft().equals( leader ) ) {
		follower.setLeft( leader.getLeft() );
	    }

	    //subcase: removal node is a right child
	    if ( follower.getRight().equals( leader ) ) {
		follower.setRight( leader.getLeft() );
	    }
	}
	else if ( leader.getLeft()==null ) { //rem node's child is on right

	    //subcase: removal node is root
	    if ( follower == null ) {
		root = root.getRight();
	    }

	    //subcase: removal node is a left child
	    if ( follower.getLeft().equals( leader ) ) {
		follower.setLeft( leader.getLeft() );
	    }
	    
	    //subcase: removal node is a right child
	    if ( follower.getRight().equals( leader ) ) {
		follower.setRight( leader.getLeft() );
	    }
	}

	//CASE 3: removal node has 2 subtrees
	//action: overwrite removal node value with max value in left subtree
	//        (deepest node with no right child), then remove that node, 
	//        promoting its left child if exists
	else {
            TreeNode maxLST = leader.getLeft();
            while( maxLST.getRight() != null ) {
		maxLST = maxLST.getRight();
            }

	    //create replacement node for removal node
            TreeNode tmp = new TreeNode( maxLST.getValue() );
            tmp.setLeft( leader.getLeft() );
            tmp.setRight( leader.getRight() );

            remove( maxLST.getValue() );

	    //subcase: removal node is root
	    if ( follower == null ) {
		root = tmp;
	    }

	    //subcase: removal node is a left child
	    if ( follower.getLeft().equals( leader ) ) {
		    follower.setLeft( tmp );
	    }
	    
	    //subcase: removal node is a right child
	    if ( follower.getRight().equals( leader ) ) {
		follower.setRight( tmp );
	    }
	}
	return leader;
    }//end remove()    

    //~~~~~~~~~~~~~v~~MISC.HELPERS~~v~~~~~~~~~~~~~~~~~~~
    public boolean isLeaf( TreeNode node ) { 
	return ( node.getLeft() == null && node.getRight() == null );
    }
    //~~~~~~~~~~~~~^~~MISC.HELPERS~~^~~~~~~~~~~~~~~~~~~~

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
