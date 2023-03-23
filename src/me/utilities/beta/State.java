package me.utilities.beta;


public abstract class State
    implements Transitable, Comparable<State>{

    State parrent = null;

    State best = null;
    
    float cost = .0f;

    @Override
    public int compareTo(State node){
        
        if(this.cost > node.cost)
            return 1;
        
        if(this.cost < node.cost)
            return -1;

        return 0;
    }
}
