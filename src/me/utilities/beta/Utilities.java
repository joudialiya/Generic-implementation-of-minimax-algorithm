package me.utilities.beta;

import java.util.*;

public class Utilities {

    /* 
     * perform() minimax custum implementation;
     * 
     * return the node and setting its "best" proprety to the best next move, 
     * and the "cost" proprety to the cost of the best.
     * 
     * first, we evaluate the state.
     * if we have a winner evaluate() will return a no 0 value
     * if we do not have a winner evaluate() will return 0.
     * in this case we check if we are at a end-game state [draw/tie] game by checking if it has neighbors,
     * if it does, then we are not at the end-game yet, so we call perform on them.
     * if not we return the state with the cost of 0.[end-game draw/tie].
     * 
     */
    
    public static <T extends State> T perform(T curr, boolean MAX, int player_index){
        
        curr.cost = curr.evaluate(player_index);

        /* getting the data neighbors */
        List<State> list = curr.neighbors();
        
        if(curr.cost !=0 || list.size() == 0){
            return curr;
        }

        /* apply perform() on the neighbors */
        for(int i=0; i<list.size(); ++i){

            Utilities.perform(list.get(i),(MAX)? false: true, player_index);
        }

        curr.best = (MAX)? Collections.max(list): Collections.min(list);

        /* elevate the cost to the curr node */
        curr.cost = curr.best.cost;

        return curr;
    }

    public static <T extends State> T best_next_move(T curr, int player_index){
        return (T) Utilities.perform(curr, true, player_index).best;
    }
    
}
