package org.wingmann.search;

import org.wingmann.utilities.search.SearchAlgorithm;

/**
 * Implements binary search algorithm.
 * @see <a href="https://en.wikipedia.wiki/Binary_search_algorithm">Wikipedia</a>
 */
public class BinarySearchRecursive implements SearchAlgorithm {
    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Comparable<T>> int find(T[] data, T target) {
        final var length = data.length;
        return (length != 0) ? find(data, target, 0, length) : -1;
    }

    private <T extends Comparable<T>> int find(T[] data, T target, int left, int right) {
        if (right < left) {
            return -1;
        }
        var median = (left + right) >>> 1;
        var comp = target.compareTo(data[median]);

        if (comp == 0) {
            return median;
        } else if (comp < 0) {
            return find(data, target, left, median - 1);
        } else {
            return find(data, target, median + 1, right);
        }
    }
}
