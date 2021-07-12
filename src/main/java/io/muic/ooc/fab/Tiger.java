package io.muic.ooc.fab;

public class Tiger extends Predator{


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

    @Override
    protected AnimalType[] getPrey() {
        return new AnimalType[]{AnimalType.RABBIT,AnimalType.FOX};
    }
}
