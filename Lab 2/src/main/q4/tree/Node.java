package q4.tree;

import q4.visitor.VisitorTree;

public interface Node {
	
	void accept(VisitorTree tree);
}
