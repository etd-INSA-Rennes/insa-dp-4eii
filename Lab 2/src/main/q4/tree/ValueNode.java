package q4.tree;

import q4.visitor.VisitorTree;

public class ValueNode implements Node {
	protected int val;

	public ValueNode(final int valNode) {
		super();
		this.val = valNode;
	}

	public int getVal() {
		return val;
	}
	
	@Override
	public void accept(VisitorTree visitor) {
		visitor.visitValueNode(this);
	}
}
