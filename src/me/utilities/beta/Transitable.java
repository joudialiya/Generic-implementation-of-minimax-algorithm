package me.utilities.beta;

import java.util.*;

public interface Transitable{

    public List<State> neighbors();
    public float evaluate(int player_index);
}
