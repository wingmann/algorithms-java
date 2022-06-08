package org.wingmann.algorithms.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class BinarySearchTest {
    @Test
    void correct() {
        var random = ThreadLocalRandom.current();
        var size = 100;
        var maxElement = 100_000;

        var data = IntStream
                .generate(() -> random.nextInt(maxElement))
                .limit(size)
                .sorted()
                .boxed()
                .toArray(Integer[]::new);

        var target = data[random.nextInt(size - 1)];

        var atIndex = new BinarySearch().find(data, target);
        var toCheck = Arrays.binarySearch(data, target);

        Assertions.assertEquals(atIndex, toCheck);
    }
}
