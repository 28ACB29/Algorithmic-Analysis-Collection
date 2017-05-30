/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Iterator;

/**
 *
 * @author Arthur C. Baroi
 * @param <T>
 */
public class SortedIterable<T extends Comparable<T>> implements Iterable<T>
{

    private Iterable<T> unsortedIterable;

    private SortedIterable()
    {
        this.unsortedIterable = null;
    }

    /**
     *
     * @param unsortedIterable
     */
    public SortedIterable(Iterable<T> unsortedIterable)
    {
        this.unsortedIterable = unsortedIterable;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<T> iterator()
    {
        return new SortedIterator();
    }

    private class SortedIterator implements Iterator<T>
    {
        private T currentMinimum;

        private Iterator<T> unsortedIterator;

        SortedIterator()
        {
            this.unsortedIterator = unsortedIterable.iterator();
            if(this.unsortedIterator.hasNext())
            {
                this.currentMinimum = this.unsortedIterator.next();
            }
            else
            {
                this.currentMinimum = null;
            }
        }

        @Override
        public boolean hasNext()
        {
            return this.currentMinimum != null && this.hasGreater();
        }

        @Override
        public T next()
        {
            T next;
            if(this.currentMinimum == null)
            {
                return null;
            }
            else
            {
                this.unsortedIterator = unsortedIterable.iterator();
                while(this.unsortedIterator.hasNext())
                {
                    next = this.unsortedIterator.next();
                    if(this.currentMinimum.compareTo(next) > 0 ||
                        (this.currentMinimum.compareTo(next) == 0 &&
                            this.currentMinimum != next))
                    {
                        this.currentMinimum = next;
                        return next;
                    }
                }
                return null;
            }
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("The operation remove is not supported.");
        }

        private boolean hasGreater()
        {
            T next;
            if(this.currentMinimum == null)
            {
                return false;
            }
            else
            {
                this.unsortedIterator = unsortedIterable.iterator();
                while(this.unsortedIterator.hasNext())
                {
                    next = this.unsortedIterator.next();
                    if(this.currentMinimum.compareTo(next) > 0)
                    {
                        return true;
                    }
                }
                return false;
            }
        }
    }

}
