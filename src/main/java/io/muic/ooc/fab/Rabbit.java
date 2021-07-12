package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public class Rabbit extends Prey {
    // Characteristics shared by all rabbits (class variables).




    @Override
    protected double getBreedingProbability() {
        return 0.12;
    }

    @Override
    protected int getMaxLitterSize() {
        return 4;
    }

    @Override
    public int getMaxAge() {
        return 40;
    }

    @Override
    protected int getBreedingAge() {
        return 5;
    }

}
