package org.wingmann.search;

import org.wingmann.utilities.search.SearchAlgorithm;

/**
 * Implements linear search algorithm.
 * @see <a href="https://en.wikipedia.org/wiki/Linear_search">Wikipedia</a>
 */
public class LinearSearch implements SearchAlgorithm {
    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Comparable<T>> int find(T[] data, T target) {
        final var length = data.length;

        if (length == 0) {
            return -1;
        }

        for (int i = 0; i < length; i++) {
            if (data[i].compareTo(target) == 0) {
                return i;
            }
        }
        return -1;
    }
}
