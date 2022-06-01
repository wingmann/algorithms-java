package org.wingmann.search;

import org.wingmann.utilities.search.SearchAlgorithm;

/**
 * Linear search algorithm.
 * <p>
 * A linear search or sequential search is a method for finding an element within a list.
 * It sequentially checks each element of the list until a match is found or the whole list has been searched.
 * A linear search runs in at worst linear time and makes at most n comparisons,
 * where n is the length of the list.
 * If each element is equally likely to be searched,
 * then linear search has an average case of (n+1)/2 comparisons,
 * but the average case can be affected if the search probabilities for each element vary.
 * <p>
 * Worst-case performance O(n), best-case performance O(1), average performance O(n/2),
 * worst-case space complexity O(1) iterative
 */
public class LinearSearch implements SearchAlgorithm {
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
