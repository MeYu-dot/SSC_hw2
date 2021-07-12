package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public abstract class Animal {

    protected static final Random RANDOM = new Random();

    private Location location;

    protected Field field;

    private int age = 0;

    private boolean alive = true;

    public void initialize( boolean randomAge,Field field, Location location) {
        this.field = field;
        setLocation(location);
        if (randomAge) {
            age = RANDOM.nextInt(getMaxAge());
        }
    }

    protected abstract Location move();

    private void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }

    public void act(List<Animal> newAnimals){
        incrementAge();
        if (isAlive()) {
            giveBirth(newAnimals);
            Location newLocation = move();
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                setDead();
            }
        }
    }

    public boolean isAlive() {
        return alive;
    }

    protected void setDead() {
        alive = false;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    public Location getLocation() {
        return location;
    }

    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }




    protected abstract int getMaxAge();

    protected abstract double getBreedingProbability();

    protected abstract int getMaxLitterSize();

    protected abstract int getBreedingAge();
    private boolean canBreed() {
        return age >= getBreedingAge();
    }

    private int breed() {
        int births = 0;
        if (canBreed() && RANDOM.nextDouble() <= getBreedingProbability()) {
            births = RANDOM.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }


    private Animal createYoung(boolean randomAge, Field field, Location location){
        return AnimalFactory.createYoung(getClass(),field,location);
    }

    private void giveBirth(List<Animal> newAnimals) {
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for (int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Animal young = createYoung(false,field,loc);
            newAnimals.add(young);
        }
    }


}

