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
    final String MAX = "max";

    final String MIN = "min";

    int heuristic();

    Set<MiniMaxGame> generateNextMoves();
}
