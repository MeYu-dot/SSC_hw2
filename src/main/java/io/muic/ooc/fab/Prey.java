package io.muic.ooc.fab;

public abstract class Prey extends Animal {

    @Override
    protected Location move(){
        return field.freeAdjacentLocation(getLocation());
    }

}