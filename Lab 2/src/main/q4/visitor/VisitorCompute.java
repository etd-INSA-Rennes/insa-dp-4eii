package q4.visitor;

import java.util.ArrayList;
import java.util.List;

import q4.tree.BinaryNode;
import q4.tree.PlusNode;
import q4.tree.SubNode;
import q4.tree.Tree;
import q4.tree.ValueNode;

public class VisitorCompute implements VisitorTree {

	List<Integer> values = new ArrayList<>();
	
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
		
		int res = values.get(values.size() - 2) + values.get(values.size() - 1);
		
		values.remove(values.get(values.size() - 2));
		values.remove(values.get(values.size() - 1));
		
		values.add(res);
	}

	@Override
	public void visitSubNode(SubNode node) {
		visitBinaryNode(node);
		
		int res = values.get(values.size() - 2) - values.get(values.size() - 1);
		
		values.remove(values.get(values.size() - 2));
		values.remove(values.get(values.size() - 1));
		
		values.add(res);
	}

	@Override
	public void visitValueNode(ValueNode node) {
		values.add(node.getVal());
	}
	
	public int getValue() {
		return values.get(0);
	}
}
