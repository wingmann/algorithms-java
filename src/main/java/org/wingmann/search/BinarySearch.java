package org.wingmann.search;

import org.wingmann.utilities.searches.SearchAlgorithm;

/**
 * Binary search is one of the most popular algorithms The algorithm finds the position of a
 * target value within a sorted array.
 *
 * Worst-case performance O(log n)
 * Best-case performance O(1)
 * Average performance O(log n)
 * Worst-case space complexity O(1)
 */
public class BinarySearch implements SearchAlgorithm {
    /**
     * @param data list where the element should be found.
     * @param target element which should be found.
     * @param <T> is any comparable type.
     * @return first found index of the element.
     */
    @Override
    public <T extends Comparable<T>> int find(T[] data, T target) {
        final var length = data.length;
        return (length == 0) ? -1 : search(data, target, 0, length);
    }

    /**
     * Implements the generic binary search algorithm.
     * @param data array to make the binary search.
     * @param target number you are looking for.
     * @param left The lower bound.
     * @param right The upper bound.
     * @return the location of the key.
     */
    private <T extends Comparable<T>> int search(T[] data, T target, int left, int right) {
        if (right < left) {
            return -1;
        }
        int median = (left + right) >>> 1;
        int compare = target.compareTo(data[median]);

        if (compare == 0) {
            return median;
        } else if (compare < 0) {
            return search(data, target, left, median - 1);
        } else {
            return search(data, target, median + 1, right);
        }
    }
}
