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
public class TimeWarp
{

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static long TimeWarpDistance(List<Long> a, List<Long> b)
    {
        int m = a.size();
        int n = b.size();
        long[][] distances = new long[m + 1][n + 1];
        long distance;

        for(int i = 0; i < m; i++)
        {
            distances[i][0] = Long.MAX_VALUE;
        }
        for(int i = 0; i < n; i++)
        {
            distances[0][i] = Long.MAX_VALUE;
        }
        distances[0][0] = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                distance = Math.abs(a.get(i) - b.get(j));
                // distances[i, j + 1] a[i] deletion, b[j] insertion
                // distances[i + 1, j] a[i] insertion, b[j] deletion
                // distances[i, j] a[i], b[j] match
                distances[i][j] = distance + Math.min(Math.min(distances[i][j + 1], distances[i + 1][j]), distances[i][j]);
            }
        }

        return distances[m][n];
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static double TimeWarpDistanceFloat(List<Long> a, List<Long> b)
    {
        int m = a.size();
        int n = b.size();
        double[][] distances = new double[m + 1][n + 1];
        double distance;

        for(int i = 0; i < m; i++)
        {
            distances[i][0] = Double.MAX_VALUE;
        }
        for(int i = 0; i < n; i++)
        {
            distances[0][i] = Double.MAX_VALUE;
        }
        distances[0][0] = 0.0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                distance = Math.abs(a.get(i) - b.get(j));
                // distances[i, j + 1] a[i] deletion, b[j] insertion
                // distances[i + 1, j] a[i] insertion, b[j] deletion
                // distances[i, j] a[i], b[j] match
                distances[i][j] = distance + Math.min(Math.min(distances[i][j + 1], distances[i + 1][j]), distances[i][j]);
            }
        }

        return distances[m][n];
    }

    /**
     *
     * @param a
     * @param b
     * @param d
     * @return
     */
    public static long TimeWarpDistance(List<Long> a, List<Long> b, int d)
    {
        int m = a.size();
        int n = b.size();
        long[][] distances = new long[m + 1][n + 1];
        long distance;

        // adapt window size
        int window = Math.max(d, Math.abs(m - n));

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                distances[i][j] = Long.MAX_VALUE;
            }
        }
        distances[0][0] = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = Math.max(0, i - window); j < Math.min(n, i + window); j++)
            {
                distance = Math.abs(a.get(i) - b.get(j));
                // distances[i, j + 1] a[i] deletion, b[j] insertion
                // distances[i + 1, j] a[i] insertion, b[j] deletion
                // distances[i, j] a[i], b[j] match
                distances[i][j] = distance + Math.min(Math.min(distances[i][j + 1], distances[i + 1][j]), distances[i][j]);
            }

        }
        return distances[m][n];
    }

    /**
     *
     * @param a
     * @param b
     * @param d
     * @return
     */
    public static double TimeWarpDistanceFloat(List<Long> a, List<Long> b, int d)
    {
        int m = a.size();
        int n = b.size();
        double[][] distances = new double[m + 1][n + 1];
        double distance;

        // adapt window size
        int window = Math.max(d, Math.abs(m - n));

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                distances[i][j] = Double.MAX_VALUE;
            }
        }
        distances[0][0] = 0.0;

        for(int i = 0; i < m; i++)
        {
            for(int j = Math.max(0, i - window); j < Math.min(n, i + window); j++)
            {
                distance = Math.abs(a.get(i) - b.get(j));
                // distances[i, j + 1] a[i] deletion, b[j] insertion
                // distances[i + 1, j] a[i] insertion, b[j] deletion
                // distances[i, j] a[i], b[j] match
                distances[i][j] = distance + Math.min(Math.min(distances[i][j + 1], distances[i + 1][j]), distances[i][j]);
            }

        }
        return distances[m][n];
    }
}
