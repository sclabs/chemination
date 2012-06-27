package org.gilgi.chemination.graph;

public class NodeFactory implements Factory<Node> {

	public Node create() {
		return new Node();
	}
	
}
