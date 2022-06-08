package org.wingmann.algorithms.search;

import org.wingmann.algorithms.utilities.search.SearchAlgorithm;

/**
 * Implements ternary search algorithm.
 * @see <a href="https://en.wikipedia.org/wiki/Ternary_search">Wikipedia</a>
 */
public class TernarySearchRecursive implements SearchAlgorithm {
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
        var first_median = left + (right - left) / 3;
        var second_median = left + 2 * (right - left) / 3;

        if (target.compareTo(data[first_median]) == 0) {
            return first_median;
        } else if (target.compareTo(data[second_median]) == 0) {
            return second_median;
        } else if (target.compareTo(data[first_median]) < 0) {
            return find(data, target, left, --first_median);
        } else if (target.compareTo(data[second_median]) > 0) {
            return find(data, target, ++second_median, right);
        } else {
            return find(data, target, first_median, second_median);
        }
    }
}
