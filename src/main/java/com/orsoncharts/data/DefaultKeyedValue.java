/* ===========
 * OrsonCharts
 * ===========
 * 
 * (C)opyright 2013 by Object Refinery Limited.
 * 
 */

package com.orsoncharts.data;


import com.orsoncharts.util.ArgChecks;
import com.orsoncharts.util.ObjectUtils;
import java.io.Serializable;

/**
 * A data item where a key is associated with a numerical value.
 */
public final class DefaultKeyedValue<T> implements KeyedValue, Serializable {

    private Comparable key;

    private T value;

    /**
     * Creates a new instance.
     * 
     * @param key  the key (<code>null</code> not permitted).
     * @param value  the value.
     */
    public DefaultKeyedValue(Comparable key, T value) {
        ArgChecks.nullNotPermitted(key, "key");
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the key.
     * 
     * @return The key (never <code>null</code>). 
     */
    @Override
    public Comparable getKey() {
        return this.key;
    }

    /**
     * Returns the value.
     * 
     * @return The value (possibly <code>null</code>). 
     */
    @Override
    public T getValue() {
        return this.value;
    }
  
    /**
     * Sets the value.
     * 
     * @param value  the value (<code>null</code> permitted).
     */
    public void setValue(T value) {
        this.value = value;
    }
    
    /**
     * Tests this instance for equality with an arbitrary object.
     * 
     * @param obj  the object to test (<code>null</code> permitted).
     * 
     * @return A boolean.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultKeyedValue)) {
            return false;
        }
        DefaultKeyedValue that = (DefaultKeyedValue) obj;
        if (!this.key.equals(that.key)) {
            return false;
        }
        if (!ObjectUtils.equals(this.value, that.value)) {
            return false;
        }
        return true;
    }
  
    @Override
    public String toString() {
        return "(" + this.key.toString() + ", " + value + ")";
    }
}
