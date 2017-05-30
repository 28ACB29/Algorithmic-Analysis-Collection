/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;

/**
 *
 * @author Arthur C. Baroi
 */
public class Modulo
{

    /**
     *
     * @param a
     * @param b
     * @param m
     * @return
     */
    public static int add(int a, int b, int m)
    {
        return (a % m + b % m) % m;
    }

    /**
     *
     * @param a
     * @param b
     * @param m
     * @return
     */
    public static int subtract(int a, int b, int m)
    {
        return (a % m - b % m) % m;
    }

    /**
     *
     * @param a
     * @param b
     * @param m
     * @return
     */
    public static int multiply(int a, int b, int m)
    {
        return (a % m * b % m) % m;
    }

    /**
     *
     * @param a
     * @param b
     * @param m
     * @return
     */
    public static int power(int a, int b, int m)
    {
        if(a == 0)
        {
            return 0;
        }
        else if(b == 0)
        {
            return 1;
        }
        else if(b % 2 == 0)
        {
            return power((a % m * a % m) % m, b / 2, m);
        }
        else if(b % 2 == 1)
        {
            return (a % m * power((a % m * a % m) % m, (b - 1) / 2, m)) % m;
        }
        else
        {
            //give obvious error
            return -1;
        }
    }
}
