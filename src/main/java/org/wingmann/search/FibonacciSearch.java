package org.wingmann.search;

import org.wingmann.utilities.search.SearchAlgorithm;

/**
 * Fibonacci search algorithm.
 * <p>
 * The fibonacci search technique is a method of searching a sorted array using a divide and conquer algorithm
 * that narrows down possible locations with the aid of Fibonacci numbers.
 * Compared to binary search where the sorted array is divided into two equal-sized parts,
 * one of which is examined further, fibonacci search divides the array into two parts that have sizes
 * that are consecutive fibonacci numbers.
 * On average, this leads to about 4% more comparisons to be executed,
 * but it has the advantage that one only needs addition and subtraction to calculate the indices of the
 * accessed array elements, while classical binary search needs bit-shift, division or multiplication,
 * operations that were less common at the time fibonacci search was first published.
 * Fibonacci search has an average- and worst-case complexity of O(log n).
 * <p>
 * The fibonacci sequence has the property that a number is the sum of its two predecessors.
 * Therefore, the sequence can be computed by repeated addition.
 * The ratio of two consecutive numbers approaches the golden ratio, 1.618...
 * Binary search works by dividing the seek area in equal parts (1:1).
 * Fibonacci search can divide it into parts approaching 1:1.618 while using the simpler operations.
 * <p>
 * If the elements being searched have non-uniform access memory storage
 * (i.e., the time needed to access a storage location varies depending on the location accessed),
 * the fibonacci search may have the advantage over binary search in slightly reducing the average
 * time needed to access a storage location.
 * If the machine executing the search has a direct mapped CPU cache,
 * binary search may lead to more cache misses because the elements that are accessed often tend to gather
 * in only a few cache lines; this is mitigated by splitting the array in parts that do not tend to be powers of two.
 * If the data is stored on a magnetic tape where seek time depends on the current head position,
 * a tradeoff between longer seek time and more comparisons may lead to a search algorithm that is skewed
 * similarly to fibonacci search.
 * <p>
 * Fibonacci search is derived from Golden section search,
 * an algorithm by Jack Kiefer (1953) to search for the maximum or minimum of a uni-modal function in an interval.
 */
public class FibonacciSearch implements SearchAlgorithm {
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
