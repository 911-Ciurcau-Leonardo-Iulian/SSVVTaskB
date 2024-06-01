import org.apache.commons.lang3.tuple.Pair;
import org.example.Friends;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestAddCow {
    private static final int cow = 4;
    private List<Integer> animals;

    @BeforeEach
    void setUp() {
        animals = new ArrayList<>(List.of(1, 2, 3, 4, 3));
    }

    @Test
    void testInsertCow() throws IOException {
        Pair<Integer, Integer> animalPair = Pair.of(0, 1);
        Friends.insertCow(animals, animalPair);
        Assertions.assertEquals(6, animals.size());
        Assertions.assertEquals(cow, animals.get(1));
    }

    @Test
    void testInsertWithOutOfBoundsIndex() {
        Pair<Integer, Integer> animalPair = Pair.of(0, 10);
        Assertions.assertThrows(IOException.class, () -> Friends.insertCow(animals, animalPair));
    }
}