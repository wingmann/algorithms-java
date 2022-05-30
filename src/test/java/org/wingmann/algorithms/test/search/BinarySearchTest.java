package org.wingmann.algorithms.test.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.wingmann.algorithms.search.BinarySearch;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinarySearchTest {
    @Test
    void correct() {
        Random r = ThreadLocalRandom.current();

        var size = 100;
        var maxElement = 100_000;

        List<Integer> integers = IntStream.generate(() -> r.nextInt(maxElement))
                .limit(size)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        // The element that should be found
        var shouldBeFound = integers.get(r.nextInt(size - 1));

        var atIndex = new BinarySearch().find(integers, shouldBeFound);
        var toCheck = Arrays.binarySearch(integers.toArray(), shouldBeFound);

        Assertions.assertEquals(toCheck, atIndex);
    }
}
