package org.wingmann.algorithms.search;

import org.wingmann.algorithms.utilities.searches.SearchAlgorithm;

import java.util.List;

/**
 * Ternary search algorithm is a technique in computer science for finding the
 * minimum or maximum of a uni-modal function.
 * The algorithm determines either that the minimum or maximum cannot be in the first third of the domain
 * or that it cannot be in the last third of the domain, then repeats on the remaining third.
 *
 * Worst-case performance Θ(log3(N))
 * Best-case performance O(1)
 * Average performance Θ(log3(N))
 * Worst-case space complexity O(1)
 */
public class TernarySearch implements SearchAlgorithm {
    /**
     * @param data list where the element should be found
     * @param target element which should be found
     * @return first found index of the element
     */
    @Override
    public <T extends Comparable<T>> int find(List<T> data, T target) {
        return search(data, target, 0, data.size() - 1);
    }

    /**
     * @param data sorted list in which we will search the element.
     * @param target value that we want to search for.
     * @param start starting index from which we will start searching.
     * @param end ending index till which we will search.
     * @return index of the element if it is found, otherwise it returns -1.
     */
    private <T extends Comparable<T>> int search(List<T> data, T target, int start, int end) {
        if (start > end) {
            return -1;
        }
        // First boundary: add 1/3 of length to start.
        var first_median = start + (end - start) / 3;
        // Second boundary: add 2/3 of length to start.
        var second_median = start + 2 * (end - start) / 3;

        if (target.compareTo(data.get(first_median)) == 0) {
            return first_median;
        } else if (target.compareTo(data.get(second_median)) == 0) {
            return second_median;
        } else if (target.compareTo(data.get(first_median)) < 0) {
            // Search the first (1/3) rd part of the array.
            return search(data, target, start, --first_median);
        } else if (target.compareTo(data.get(second_median)) > 0) {
            // Search 3rd (1/3)rd part of the array.
            return search(data, target, ++second_median, end);
        } else {
            // Search middle (1/3)rd part of the array.
            return search(data, target, first_median, second_median);
        }
    }
}
