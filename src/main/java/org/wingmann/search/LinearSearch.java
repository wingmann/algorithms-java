package org.wingmann.search;

import org.wingmann.utilities.searches.SearchAlgorithm;

/**
 * Linear search is the easiest search algorithm It works with sorted and unsorted arrays
 * (a binary search works only with sorted array).
 * This algorithm just compares all elements of an array to find a value.
 *
 * Worst-case performance O(n)
 * Best-case performance O(1)
 * Average performance O(n/2)
 * Worst-case space complexity O(1) iterative
 */
public class LinearSearch implements SearchAlgorithm {
    /**
     * @param data list where the element should be found.
     * @param target element which should be found.
     * @return first found index of the element.
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
