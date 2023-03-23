package me.utilities.beta.implementation;

import java.util.*;
import me.utilities.beta.State;

public class TicState extends State {

    public char[] board = new char[]{
        '.','.','.',
        '.','.','.',
        '.','.','.'
    };

    public char player_turn = 'x';
    
    @Override
    public List<State> neighbors(){

        ArrayList<State> list = new ArrayList<>();

        for(int i=0; i<9; ++i){
            if(board[i] == '.'){
                TicState new_one = this.copy();
                new_one.board[i] = player_turn;
                new_one.switch_turn();
                list.add(new_one);
            }
        }
        
        return list;
    };

    @Override
    public String toString(){
        String str = "";

        for(int h=0; h<3; ++h){
            for(int w=0; w<3; ++w)
                str += " " + board[3*h + w];
            str += '\n';
        }
        return str;
    }

    @Override 
    public float evaluate(int player_index){

        // horizontal
        for (int row = 0; row < 3; row++){

            if (board[index(row, 0)] == board[index(row, 1)] &&
                board[index(row, 0)] == board[index(row, 2)]){

                if (board[index(row,0)] == (player_index == 0? 'x': 'o'))
                    return +1;
                else if (board[index(row, 0)] != '.')
                    return -1;
            }
        }
    
        // vertical
        for (int col = 0; col < 3; col++){

            if (board[index(0, col)] == board[index(1, col)] &&
                board[index(1, col)] == board[index(2, col)]){

                if (board[index(0, col)] == (player_index == 0? 'x': 'o'))
                    return +1;
                else if (board[index(0, col)] != '.')
                    return -1;
            }
        }
    
        // diagonal
        if (board[index(0, 0)] == board[index(1, 1)] &&
            board[index(1, 1)] == board[index(2, 2)]){

            if (board[index(0, 0)] == (player_index == 0? 'x': 'o'))
                return +1;
            else if (board[index(0, 0)] != '.')
                return -1;
        }
    
        if (board[index(0, 2)] == board[index(1, 1)] && 
            board[index(1, 1)] == board[index(2, 0)]){

            if (board[index(0, 2)] == (player_index == 0? 'x': 'o'))
                return +1;
            else if (board[index(0, 2)] != '.')
                return -1;
        }
    
        return .0f;
    }


    private int index(int x, int y){
        return 3*y + x;
    }

    public void switch_turn(){
        player_turn = (player_turn == 'x')? 'o': 'x'; 
    }
    
    public TicState copy(){
        TicState ret = new TicState();
        ret.player_turn = this.player_turn;
        for(int i=0; i<9; ++i)
            ret.board[i] = this.board[i];
        return ret;
    }
}
