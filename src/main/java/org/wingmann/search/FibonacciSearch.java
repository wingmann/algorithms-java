package org.wingmann.search;

import org.wingmann.utilities.searches.SearchAlgorithm;

/**
 * Fibonacci Search is a popular algorithm which finds the position of a target value
 * in a sorted list.
 *
 * Time complexity O(log3(n))
 * Space complexity O(1)
 */
public class FibonacciSearch implements SearchAlgorithm {
    /**
     * @param data   list where the element should be found.
     * @param target element which should be found.
     * @return first found index of the element.
     */
    @Override
    public <T extends Comparable<T>> int find(T[] data, T target) {
        final var length = data.length;

        if (length == 0) {
            return -1;
        }

        var fibMinusOne = 1;
        var fibMinusTwo = 0;
        var fibNumber = fibMinusOne + fibMinusTwo;

        while (fibNumber < length) {
            fibMinusTwo = fibMinusOne;
            fibMinusOne = fibNumber;
            fibNumber = fibMinusTwo + fibMinusOne;
        }
        var offset = -1;

        while (fibNumber > 1) {
            int i = Math.min(offset + fibMinusTwo, length - 1);

            if (data[i].compareTo(target) < 0) {
                fibNumber = fibMinusOne;
                fibMinusOne = fibMinusTwo;
                fibMinusTwo = fibNumber - fibMinusOne;
                offset = i;
            } else if (data[i].compareTo(target) > 0) {
                fibNumber = fibMinusTwo;
                fibMinusOne = fibMinusOne - fibMinusTwo;
                fibMinusTwo = fibNumber - fibMinusOne;
            } else {
                return i;
            }
        }

        if (fibMinusOne == 1 && data[offset + 1] == target) {
            return offset + 1;
        }
        return -1;
    }
}
