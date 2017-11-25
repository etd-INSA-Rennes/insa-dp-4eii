package q4.tree;

import q4.visitor.VisitorTree;

public class Tree {
	
    protected Node root;
    protected String name;
    
    public Tree(final Node rootNode, final String treeName) {
    	super();
    	
    	if (rootNode == null || treeName == null)
    		throw new IllegalArgumentException("Null parameter");
    	
    	root = rootNode;
    	name = treeName;
    }

    public Node getRoot() {
		return root;
	}

	public String getName() {
		return name;
	}

	public void accept(VisitorTree visitor) {
		visitor.visitTree(this);
	}
}
