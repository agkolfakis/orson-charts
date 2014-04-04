/* ============
 * Orson Charts
 * ============
 * 
 * (C)opyright 2013, 2014, by Object Refinery Limited.
 * 
 * http://www.object-refinery.com/orsoncharts/index.html
 * 
 * Redistribution of this source file is prohibited.
 * 
 */

package com.orsoncharts.data;

import java.io.Serializable;

import com.orsoncharts.util.ArgChecks;

/**
 * An object that references one data item in a {@link KeyedValues3D} data
 * structure.
 * 
 * @since 1.3
 */
public class KeyedValues3DItemKey<S extends Comparable<S>, 
        R extends Comparable<R>, C extends Comparable<C>> 
        implements ItemKey, Comparable<KeyedValues3DItemKey<S, R, C>>, 
        Serializable {
    
    /** The series key. */
    S seriesKey;
    
    /** The row key. */
    R rowKey;
    
    /** The column key. */
    C columnKey;
    
    /**
     * Creates a new instance.
     * 
     * @param seriesKey  the series key (<code>null</code> not permitted).
     * @param rowKey  the row key (<code>null</code> not permitted).
     * @param columnKey  the column key (<code>null</code> not permitted).
     */
    public KeyedValues3DItemKey(S seriesKey, R rowKey, C columnKey) {
        ArgChecks.nullNotPermitted(seriesKey, "seriesKey");
        ArgChecks.nullNotPermitted(rowKey, "rowKey");
        ArgChecks.nullNotPermitted(columnKey, "columnKey");
        this.seriesKey = seriesKey;
        this.rowKey = rowKey;
        this.columnKey = columnKey;
    }
    
    /**
     * Returns the series key.
     * 
     * @return The series key (never <code>null</code>). 
     */
    public S getSeriesKey() {
        return this.seriesKey;
    }
    
    /**
     * Returns the row key.
     * 
     * @return The row key (never <code>null</code>).
     */
    public R getRowKey() {
        return this.rowKey;
    }
    
    /**
     * Returns the column key.
     * 
     * @return The column key (never <code>null</code>). 
     */
    public C getColumnKey() {
        return this.columnKey;
    }
    
    @Override
    public int compareTo(KeyedValues3DItemKey<S, R, C> key) {
        int result = this.seriesKey.compareTo(key.getSeriesKey());
        if (result == 0) {
            result = this.rowKey.compareTo(key.rowKey);
            if (result == 0) {
                result = this.columnKey.compareTo(key.columnKey);
            }
        }
        return result;
    }
    
    /**
     * Tests this key for equality with an arbitrary object.
     * 
     * @param obj  the object (<code>null</code> permitted).
     * 
     * @return A boolean. 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeyedValues3DItemKey)) {
            return false;
        }
        KeyedValues3DItemKey that = (KeyedValues3DItemKey) obj;
        if (!this.seriesKey.equals(that.seriesKey)) {
            return false;
        }
        if (!this.rowKey.equals(that.rowKey)) {
            return false;
        }
        if (!this.columnKey.equals(that.columnKey)) {
            return false;
        }
        return true;
    }

    @Override
    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"seriesKey\": \"").append(this.seriesKey.toString());
        sb.append("\" ");
        sb.append("\"rowKey\": \"").append(this.rowKey.toString());
        sb.append("\" ");
        sb.append("\"columnKey\": \"").append(this.columnKey.toString());
        sb.append("\"}");
        return sb.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Values3DItemKey[series=");
        sb.append(seriesKey.toString()).append(",row=");
        sb.append(rowKey.toString()).append(",column=");
        sb.append(columnKey.toString());
        sb.append("]");
        return sb.toString();
    }

}