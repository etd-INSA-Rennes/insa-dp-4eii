package q4.visitor;

import q4.tree.BinaryNode;
import q4.tree.PlusNode;
import q4.tree.SubNode;
import q4.tree.Tree;
import q4.tree.ValueNode;

public class VisitorPrintPostfix implements VisitorTree {

	@Override
	public void visitTree(Tree tree) {
		tree.getRoot().accept(this);
	}

	@Override
	public void visitBinaryNode(BinaryNode node) {
		node.getLeftNode().accept(this);
		node.getRightNode().accept(this);
	}

	@Override
	public void visitPlusNode(PlusNode node) {
		visitBinaryNode(node);
		
		System.out.print("+ ");
	}

	@Override
	public void visitSubNode(SubNode node) {
		visitBinaryNode(node);
		
		System.out.print("- ");
	}

	@Override
	public void visitValueNode(ValueNode node) {
		System.out.print(node.getVal() + " ");
	}
}
