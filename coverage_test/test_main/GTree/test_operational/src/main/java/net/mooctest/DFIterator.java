package net.mooctest;

import java.util.Iterator;

/**
 * Depth-first
 */
public class DFIterator<T> implements Iterator<T> {

    TreeDFIterator<T> treeDFIterator;

    public DFIterator(Tree<T> tree) {
        treeDFIterator = new TreeDFIterator<T>(tree);
    }

    @Override
    public boolean hasNext() {
        return treeDFIterator.hasNext();
    }

    @Override
    public T next() {
        return treeDFIterator.next().getValue();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
