package org.gilgi.graph;

import java.util.List;

public interface Node<N extends Node<N>> {

	public abstract List<N> getNeighbors();

	public abstract void addNeighbor(N n);

	public abstract void removeNeighbor(N n);

	public abstract boolean hasNeighbor(N n);

}