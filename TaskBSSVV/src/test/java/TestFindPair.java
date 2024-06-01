import org.apache.commons.lang3.tuple.Pair;
import org.example.Friends;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestFindPair {
    List<Integer> animalsWithPair;
    List<Integer> animalsWithoutPair;
    List<Integer> animalsinvalidPair;
    List<Integer> animalsinvalidPair2;
    @BeforeEach
    void setUp(){
        animalsWithPair = new ArrayList<>(List.of(1, 2, 3, 4, 3));
        animalsWithoutPair = new ArrayList<>(List.of(1, 4, 3, 4, 3));
        animalsinvalidPair = new ArrayList<>(List.of(5, 2, 3, 4, 3));
        animalsinvalidPair2 = new ArrayList<>(List.of(0, 2, 3, 4, 3));
    }

    @Test
    void testFindExistingPair() throws IOException {
        Pair<Integer,Integer> existingPair = Friends.findPair(animalsWithPair);
        Assertions.assertEquals(existingPair.getLeft(),0);
        Assertions.assertEquals(existingPair.getRight(),1);
    }

    @Test
    void testFindNoPair() throws IOException {
        Pair<Integer,Integer> noPair = Friends.findPair(animalsWithoutPair);
        Assertions.assertNull(noPair);
    }

    @Test
    void testFindInvalidPair(){
        try{
            Friends.findPair(animalsinvalidPair);
        } catch (Exception e){
            Assertions.assertTrue(true);
            return;
        }
        Assertions.fail();
    }

    @Test
    void testFindInvalidPair2(){
        try{
            Friends.findPair(animalsinvalidPair2);
        } catch (Exception e){
            Assertions.assertTrue(true);
            return;
        }
        Assertions.fail();
    }
}
