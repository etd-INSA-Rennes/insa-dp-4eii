package q4.tree;

import q4.visitor.VisitorTree;

public class PlusNode extends BinaryNode {
	
	public PlusNode(final Node left, final Node right) {
		super(left, right);
	}
	
	@Override
	public void accept(VisitorTree visitor) {
		visitor.visitPlusNode(this);
	}
}
