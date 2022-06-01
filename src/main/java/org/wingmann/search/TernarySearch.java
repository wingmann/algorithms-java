package org.wingmann.search;

import org.wingmann.utilities.search.SearchAlgorithm;

/**
 * Ternary search algorithm.
 */
public class TernarySearch implements SearchAlgorithm {
    /**
     * Finds the first occurrence of the target element.
     *
     * @param data an array where the element should be found.
     * @param target an element which should be found.
     * @return Index of the first occurrence of the target element, or -1 if it is not found.
     */
    @Override
    public <T extends Comparable<T>> int find(T[] data, T target) {
        final var length = data.length;
        return (length != 0) ? find(data, target, 0, length) : -1;
    }

    /**
     * Finds the first occurrence of the target element.
     *
     * @param data an array where the element should be found.
     * @param target an element which should be found.
     * @param left lower bound.
     * @param right upper bound.
     * @return Index of the first occurrence of the target element, or -1 if it is not found.
     * @param <T> comparable type.
     */
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
