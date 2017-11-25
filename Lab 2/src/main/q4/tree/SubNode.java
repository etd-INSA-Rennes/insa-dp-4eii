package q4.tree;

import q4.visitor.VisitorTree;

public class SubNode extends BinaryNode {
	
	public SubNode(final Node left, final Node right) {
		super(left, right);
	}
	
	@Override
	public void accept(VisitorTree visitor) {
		visitor.visitSubNode(this);
	}
}
