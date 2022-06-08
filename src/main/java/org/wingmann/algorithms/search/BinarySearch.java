package org.wingmann.algorithms.search;

import org.wingmann.algorithms.utilities.search.SearchAlgorithm;

/**
 * Implements binary search algorithm.
 * @see <a href="https://en.wikipedia.wiki/Binary_search_algorithm">Wikipedia</a>
 */
public class BinarySearch implements SearchAlgorithm {
    /**
     * Finds the first occurrence of the target element.
     * @param data   an array where the element should be found.
     * @param target an element which should be found.
     * @return index of the first occurrence of the target element, or -1 if it is not found.
     */
    @Override
    public <T extends Comparable<T>> int find(T[] data, T target) {
        var leftIndex = 0;
        var rightIndex = data.length - 1;

        while (leftIndex <= rightIndex)
        {
            var middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            var compared = target.compareTo(data[middleIndex]);

            if (compared > 0) {
                leftIndex = middleIndex + 1;
            } else if (compared < 0) {
                rightIndex = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }
}
