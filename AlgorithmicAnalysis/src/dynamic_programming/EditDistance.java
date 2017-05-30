/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_programming;

import java.util.List;

/**
 *
 * @author Arthur C. Baroi
 */
public class EditDistance<T extends Comparable<T>>
{

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public int LevenshteinDistance(List<T> a, List<T> b)
    {
        int m = a.size();
        int n = b.size();
        int[][] distances = new int[m + 1][n + 1];
        int distance;

        for(int i = 0; i < m; i++)
        {
            distances[i][0] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < n; i++)
        {
            distances[0][i] = Integer.MAX_VALUE;
        }
        distances[0][0] = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                distance = Math.abs(a.get(i).compareTo(b.get(j)));
                // distances[i][j + 1] insertion
                // distances[i + 1][j] deletion
                // distances[i][j] match
                distances[i][j] = distance + Math.min(Math.min(distances[i][j + 1], distances[i + 1][j]), distances[i][j]);
            }
        }

        return distances[m][n];
    }

}
