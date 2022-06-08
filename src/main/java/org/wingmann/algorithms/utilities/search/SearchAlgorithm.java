package org.wingmann.algorithms.utilities.search;

/**
 * Common interface of most search algorithms.
 */
public interface SearchAlgorithm {
    /**
     * Finds the first occurrence of the target element.
     * @param data   an array where the element should be found.
     * @param target an element which should be found.
     * @return index of the first occurrence of the target element, or -1 if it is not found.
     * @param <T> comparable type.
     */
    <T extends Comparable<T>> int find(T[] data, T target);
}
