package org.wingmann.search;

import org.wingmann.utilities.search.SearchAlgorithm;

/**
 * Binary search algorithm.
 * <p>
 * Binary search, also known as half-interval search, logarithmic search, or binary chop,
 * is a search algorithm that finds the position of a target value within a sorted array.
 * Binary search compares the target value to the middle element of the array.
 * If they are not equal, the half in which the target cannot lie is eliminated and the
 * search continues on the remaining half, again taking the middle element to compare to the target value,
 * and repeating this until the target value is found.
 * If the search ends with the remaining half being empty, the target is not in the array.
 * <p>
 * Binary search runs in logarithmic time in the worst case, making O(log n) comparisons,
 * where n is the number of elements in the array.
 * Binary search is faster than linear search except for small arrays.
 * However, the array must be sorted first to be able to apply binary search.
 * There are specialized data structures designed for fast searching, such as hash tables,
 * that can be searched more efficiently than binary search.
 * However, binary search can be used to solve a wider range of problems, such as finding the
 * next-smallest or next-largest element in the array relative to the target even if it is absent from the array.
 * <p>
 * There are numerous variations of binary search.
 * In particular, fractional cascading speeds up binary searches for the same value in multiple arrays.
 * Fractional cascading efficiently solves a number of search issues in computational geometry
 * and in numerous other fields.
 * Exponential search extends binary search to unbounded lists.
 * The binary search tree and B-tree data structures are based on binary search.
 * <p>
 * Worst-case performance O(log n), best-case performance O(1), average performance O(log n),
 * worst-case space complexity O(1)
 */
public class BinarySearch implements SearchAlgorithm {
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
        var median = (left + right) >>> 1;
        var comp = target.compareTo(data[median]);

        if (comp == 0) {
            return median;
        } else if (comp < 0) {
            return find(data, target, left, median - 1);
        } else {
            return find(data, target, median + 1, right);
        }
    }
}
