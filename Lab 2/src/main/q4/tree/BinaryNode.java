package q4.tree;

public abstract class BinaryNode implements Node {
	
    protected Node leftNode;
    protected Node rightNode;
    
	public BinaryNode(final Node left, final Node right) {
		super();
		
    	if (left == null || right == null)
    		throw new IllegalArgumentException("Null parameter");
		
		this.leftNode = left;
		this.rightNode = right;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}
}
