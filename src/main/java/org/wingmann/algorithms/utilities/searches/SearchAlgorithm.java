package org.wingmann.algorithms.utilities.searches;

import java.util.List;

/**
 * The common interface of most searching algorithms
 */
public interface SearchAlgorithm {
    /**
     * @param target is an element which should be found
     * @param data is a list where the element should be found
     * @param <T> Comparable type
     * @return first found index of the element
     */
    <T extends Comparable<T>> int find(List<T> data, T target);
}