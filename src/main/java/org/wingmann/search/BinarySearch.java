package org.wingmann.search;

import org.wingmann.utilities.search.SearchAlgorithm;

/**
 * Implements binary search algorithm.
 * @see <a href="https://en.wikipedia.wiki/Binary_search_algorithm">Wikipedia</a>
 */
public class BinarySearch implements SearchAlgorithm {
    /**
     * {@inheritDoc}
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
