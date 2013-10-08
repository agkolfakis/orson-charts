/* =============
 * OrsonCharts3D
 * =============
 * 
 * (C)opyright 2013 by Object Refinery Limited.
 * 
 */

package com.orsoncharts.util;

/**
 * Represents an anchor point for a chart title and/or legend.  Instances
 * of this class are immutable.
 */
public final class Anchor2D {
    
    /** 
     * The reference point relative to some bounding rectangle (normally the 
     * bounds of the chart, never <code>null</code>). 
     */
    private ReferencePoint2D refPt;
    
    /**
     * The offsets to apply (never <code>null</code>).
     */
    private Offset2D offset;
    
    /**
     * Creates a default instance.
     */
    public Anchor2D() {
        this(ReferencePoint2D.TOP_LEFT);
    }
    
    /**
     * Creates a new <code>Anchor2D</code> instance with the specified 
     * reference point and offsets of <code>(4.0, 4.0)</code>.
     * 
     * @param refPt  the reference point (<code>null</code> not permitted).
     */
    public Anchor2D(ReferencePoint2D refPt) {
        this(refPt, new Offset2D(4.0, 4.0));    
    }
    
    /**
     * Creates a new anchor.
     * 
     * @param refPt  the reference point (<code>null</code> not permitted).
     * @param offset  the offset (<code>null</code> not permitted).
     */
    public Anchor2D(ReferencePoint2D refPt, Offset2D offset) {
        ArgChecks.nullNotPermitted(refPt, "refPt");
        ArgChecks.nullNotPermitted(offset, "offset");
        this.refPt = refPt;
        this.offset = offset;
    }

    /**
     * Returns the reference point.
     * 
     * @return The reference point (never <code>null</code>). 
     */
    public ReferencePoint2D getRefPt() {
        return this.refPt;
    }
    
    /**
     * Returns the offsets.
     * 
     * @return The offsets (never <code>null</code>). 
     */
    public Offset2D getOffset() {
        return this.offset;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Anchor2D)) {
            return false;
        }
        Anchor2D that = (Anchor2D) obj;
        if (!this.refPt.equals(that.refPt)) {
            return false;
        }
        if (!this.offset.equals(that.offset)) {
            return false;
        }
        return true;
    }
}
