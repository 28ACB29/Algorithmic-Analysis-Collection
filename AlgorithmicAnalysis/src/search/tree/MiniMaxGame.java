/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.tree;

import java.util.Set;

/**
 *
 * @author Arthur C. Baroi
 */
public interface MiniMaxGame extends Comparable<MiniMaxGame>
{
    public static final String MAX = "max";

    public static final String MIN = "min";

    public int heuristic();

    public Set<MiniMaxGame> generateNextMoves(String player);
}
