package org.wingmann.algorithms.search;

import org.wingmann.algorithms.utilities.search.SearchAlgorithm;

/**
 * Implements linear search algorithm.
 * @see <a href="https://en.wikipedia.org/wiki/Linear_search">Wikipedia</a>
 */
public class LinearSearch implements SearchAlgorithm {
    /**
     * Finds the first occurrence of the target element.
     * @param data   an array where the element should be found.
     * @param target an element which should be found.
     * @return index of the first occurrence of the target element, or -1 if it is not found.
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
