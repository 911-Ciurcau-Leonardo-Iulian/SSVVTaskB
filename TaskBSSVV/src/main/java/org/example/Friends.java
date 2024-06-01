package org.example;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Friends {
    static final int mouse = 1;
    static final int cat = 2;
    static final int dog = 3;
    static final int cow = 4;
    public static Pair<Integer,Integer> findPair(List<Integer> animals) throws IOException {

        for(int i = 0; i<animals.size() - 1; i++){
            if(animals.get(i) < 1 || animals.get(i) > 4) throw new IOException("There is no animal with that number");
            if((animals.get(i) == mouse && animals.get(i + 1) == cat) || (animals.get(i) == cat && animals.get(i + 1) == mouse) || (animals.get(i) == dog && animals.get(i + 1) == cat) ||(animals.get(i) == cat && animals.get(i + 1) == dog)){
                return new ImmutablePair<>(i,i+1);
            }
        }
        return null;
    }

    public static void insertCow(List<Integer> animals, Pair<Integer,Integer> animalPair) throws IOException {
        if(animalPair.getRight() < 0 || animalPair.getRight() >= animals.size())
        {
            throw new IOException("No cow can be inserted outside of the barn");
        }
        animals.add(animalPair.getRight(), cow);
    }

    public static void beFriends(List<Integer> animals) throws IOException {
        Pair<Integer,Integer> pair = findPair(animals);
        while(!Objects.isNull(pair)){
            insertCow(animals,pair);
            pair=findPair(animals);
        }
    }
}
