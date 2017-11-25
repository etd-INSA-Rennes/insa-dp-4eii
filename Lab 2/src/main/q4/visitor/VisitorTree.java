package q4.visitor;

import q4.tree.BinaryNode;
import q4.tree.PlusNode;
import q4.tree.SubNode;
import q4.tree.Tree;
import q4.tree.ValueNode;

public interface VisitorTree {

	public void visitTree(Tree tree);
	
	public void visitBinaryNode(BinaryNode node);
	
	public void visitPlusNode(PlusNode node);
	
	public void visitSubNode(SubNode node);
	
	public void visitValueNode(ValueNode node);
}
