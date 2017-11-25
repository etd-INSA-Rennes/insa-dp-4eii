package q4;

import q4.tree.PlusNode;
import q4.tree.SubNode;
import q4.tree.Tree;
import q4.tree.ValueNode;
import q4.visitor.VisitorCompute;
import q4.visitor.VisitorPrintPostfix;

public class Main {
	
	public static void main(final String[] args) {
		SubNode  n2 = new SubNode(new ValueNode(3), new ValueNode(4));
		PlusNode n3 = new PlusNode(new ValueNode(1), new ValueNode(2));
		PlusNode n1 = new PlusNode(n3, n2);
		
		Tree tree = new Tree(n1, "my formula");

		// Q.4d
		
		System.out.println("Post-fix notation:");
		tree.accept(new VisitorPrintPostfix());
		
		// Q.4e
		
		System.out.println('\n');
		System.out.println("Compute:");
		VisitorCompute v = new VisitorCompute();
		tree.accept(v);
		System.out.println(v.getValue());
	}
}
