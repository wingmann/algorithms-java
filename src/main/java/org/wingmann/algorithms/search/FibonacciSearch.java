package org.wingmann.algorithms.search;

import org.wingmann.algorithms.utilities.search.SearchAlgorithm;

/**
 * Implements fibonacci search algorithm.
 * @see <a href="https://en.wikipedia.wiki/Fibonacci_search_technique">Wikipedia</a>
 */
public class FibonacciSearch implements SearchAlgorithm {
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
        var fibMinusFirst = 1;
        var fibMinusSecond = 0;
        var fibNumber = fibMinusFirst + fibMinusSecond;

        while (fibNumber < length) {
            fibMinusSecond = fibMinusFirst;
            fibMinusFirst = fibNumber;
            fibNumber = fibMinusSecond + fibMinusFirst;
        }
        var offset = -1;

        while (fibNumber > 1) {
            int i = Math.min(offset + fibMinusSecond, length - 1);

            if (data[i].compareTo(target) < 0) {
                fibNumber = fibMinusFirst;
                fibMinusFirst = fibMinusSecond;
                fibMinusSecond = fibNumber - fibMinusFirst;
                offset = i;
            } else if (data[i].compareTo(target) > 0) {
                fibNumber = fibMinusSecond;
                fibMinusFirst = fibMinusFirst - fibMinusSecond;
                fibMinusSecond = fibNumber - fibMinusFirst;
            } else {
                return i;
            }
        }

        if (fibMinusFirst == 1 && data[offset + 1] == target) {
            return offset + 1;
        }
        return -1;
    }
}
