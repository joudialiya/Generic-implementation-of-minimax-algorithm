package me.utilities.beta;

import java.io.*;
import java.util.Currency;

import me.utilities.beta.implementation.TicState;

public class Main {    

    public static TicState nextMove(TicState node, int index){

        TicState ret = node.copy();
        ret.board[index] = 'o';
        ret.switch_turn();
        return ret;

    }
    
    public static void main(String[] argv)
        throws IOException{

        TicState curr = new TicState();

        while(true){

            curr = Utilities.best_next_move(curr, 0);

            System.out.println(curr);
            int input = Integer.parseInt(new BufferedReader (new InputStreamReader(System.in)).readLine());

            if(curr == null)
                break;
            curr = nextMove(curr, input);
        } 
    }
}
