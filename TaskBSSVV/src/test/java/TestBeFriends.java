import org.apache.commons.lang3.tuple.Pair;
import org.example.Friends;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestBeFriends {

    private List<Integer> animals;

    @BeforeEach
    void setUp() {
        animals = new ArrayList<>();
    }

    @Test
    void testNoPairFoundInitially() throws IOException {
        animals.add(1);
        animals.add(4);
        animals.add(3);
        Friends.beFriends(animals);
        Assertions.assertEquals(List.of(1, 4, 3), animals);
    }

    @Test
    void testOnePairFound() throws IOException {
        animals.add(1);
        animals.add(2);
        Friends.beFriends(animals);
        Assertions.assertEquals(List.of(1, 4, 2), animals);
    }

    @Test
    void testMultiplePairsFound() throws IOException {
        animals.add(1);
        animals.add(2);
        animals.add(3);
        animals.add(2);
        Friends.beFriends(animals);
        Assertions.assertEquals(List.of(1, 4, 2, 4, 3, 4, 2), animals);
    }

    @Test
    void testEmptyList() throws IOException {
        Friends.beFriends(animals);
        Assertions.assertTrue(animals.isEmpty());
    }
}
