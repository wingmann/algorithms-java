package org.wingmann.algorithms.search;

import org.wingmann.algorithms.utilities.search.SearchAlgorithm;

/**
 * Implements binary search algorithm.
 * @see <a href="https://en.wikipedia.wiki/Binary_search_algorithm">Wikipedia</a>
 */
public class BinarySearchRecursive implements SearchAlgorithm {
    /**
     * Finds the first occurrence of the target element.
     * @param data   an array where the element should be found.
     * @param target an element which should be found.
     * @return index of the first occurrence of the target element, or -1 if it is not found.
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
