package org.wingmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.wingmann.search.LinearSearch;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class LinearSearchTest {
    @Test
    void correct() {
        Random random = ThreadLocalRandom.current();

        var size = 100;
        var maxElement = 100;

        var integers = IntStream.generate(() -> random.nextInt(maxElement))
                .limit(size)
                .sorted()
                .boxed()
                .toArray(Integer[]::new);

        var shouldBeFound = integers[random.nextInt(size - 1)];

        var atIndex = new LinearSearch().find(integers, shouldBeFound);
        var toCheck = Arrays.binarySearch(integers, shouldBeFound);

        Assertions.assertEquals(toCheck, atIndex);
    }
}
