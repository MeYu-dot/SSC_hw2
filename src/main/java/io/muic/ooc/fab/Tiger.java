package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;

public class Tiger extends Predator{

    @Override
    protected AnimalType[] getPrey() {
        return new AnimalType[]{AnimalType.RABBIT,AnimalType.FOX};
    }




    @Override
    protected int getMaxAge() {
        return 200;
    }

    @Override
    protected double getBreedingProbability() {
        return 0.08;
    }

    @Override
    protected int getMaxLitterSize() {
        return 2;
    }

    @Override
    protected int getBreedingAge() {
        return 30;
    }

}
