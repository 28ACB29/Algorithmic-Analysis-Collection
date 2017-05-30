/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Arthur C. Baroi
 */
public class CoinChange
{

    private ArrayList<Integer> denominations;

    private int maxAmount;

    private int[][] denominationAmounts;

    public CoinChange()
    {
        this.denominations = new ArrayList<Integer>();
        this.maxAmount = 1;
        this.denominationAmounts = new int[this.maxAmount][this.maxAmount];
    }

    /**
     *
     * @param denominations
     */
    public CoinChange(ArrayList<Integer> denominations)
    {
        this.denominations = denominations;
        Collections.sort(this.denominations);
        this.maxAmount = this.denominations.get(this.denominations.size() - 1);
        this.denominationAmounts = new int[this.maxAmount][this.denominations.size()];
        this.calculateCoinAmounts();
    }

    /**
     *
     * @param denominations
     * @param maxAmount
     */
    public CoinChange(ArrayList<Integer> denominations, int maxAmount)
    {
        this.denominations = denominations;
        Collections.sort(this.denominations);
        this.maxAmount = maxAmount;
        this.denominationAmounts = new int[this.maxAmount][this.denominations.size()];
        this.calculateCoinAmounts();
    }

    /**
     * @return the denominations
     */
    public ArrayList<Integer> getDenominations()
    {
        return this.denominations;
    }

    /**
     * @param denominations the denominations to set
     */
    public void setDenominations(ArrayList<Integer> denominations)
    {
        this.denominations = denominations;
        this.denominationAmounts = new int[this.maxAmount][this.denominations.size()];
    }

    /**
     * @return the maxAmount
     */
    public int getMaxAmount()
    {
        return this.maxAmount;
    }

    /**
     * @param maxAmount the maxAmount to set
     */
    public void setMaxAmount(int maxAmount)
    {
        this.maxAmount = maxAmount;
    }

    private void calculateCoinAmounts()
    {
        int minCoins;
        int index;
        int amountWithoutCoin;
        for(int i = 0; i < this.denominationAmounts.length; i++)
        {
            minCoins = Integer.MAX_VALUE;
            index = -1;
            for(int j = 0; j < denominations.size(); j++)
            {
                amountWithoutCoin = i - this.denominations.get(j);
                if(amountWithoutCoin > -1 && minCoins > CoinChange.arraySum(this.denominationAmounts[amountWithoutCoin]))
                {
                    minCoins = CoinChange.arraySum(this.denominationAmounts[amountWithoutCoin]);
                    index = j;
                }
            }
            amountWithoutCoin = i - this.denominations.get(index);
            System.arraycopy(this.denominationAmounts[amountWithoutCoin], 0, this.denominationAmounts[i], 0, this.denominationAmounts[i].length);
            this.denominationAmounts[i][index]++;
        }
    }

    private static int arraySum(int[] array)
    {
        int sum;
        sum = 0;
        for(int element : array)
        {
            sum += element;
        }
        return sum;
    }

    /**
     *
     * @param amount
     * @return
     */
    public int minNumberOfCoins(int amount)
    {
        return CoinChange.arraySum(this.denominationAmounts[amount]);
    }

    /**
     *
     * @return
     */
    public long numberOfWays()
    {
        return 0;
    }

    /**
     *
     * @param amount
     * @return
     */
    public ArrayList<Integer> amountInCoins(int amount)
    {
        ArrayList<Integer> coins;
        int[] tempAmounts;
        int index;
        coins = new ArrayList<Integer>(this.minNumberOfCoins(amount));
        tempAmounts = this.denominationAmounts[amount];
        index = 0;
        for(int i = 0; i < coins.size(); i++)
        {
            while(tempAmounts[index] < 1 && index < this.denominations.size())
            {
                index++;
            }
            if(tempAmounts[index] > 0)
            {
                coins.set(i, this.denominations.get(index));
                tempAmounts[index]--;
            }
        }
        return coins;
    }
}
