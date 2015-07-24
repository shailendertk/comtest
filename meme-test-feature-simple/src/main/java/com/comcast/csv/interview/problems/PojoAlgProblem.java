package com.comcast.csv.interview.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Rectangle;
import java.util.Objects;

/**
 * Using absolute coordinates for EVERYTHING, implement the following methods to position the inner rectangle relative
 * to the outer rectangle.
 */
public class PojoAlgProblem {

    private final static Logger LOG = LoggerFactory.getLogger(PojoAlgProblem.class);

    private boolean isBottomRight;

    private boolean isMiddleCenter;

    public boolean isBottomRight() {
        return isBottomRight;
    }

    public boolean isMiddleCenter() {
        return isMiddleCenter;
    }

    /**
     * Put the inner rectangle so that it's bottom right corner aligns with the bottom right corner of the outer
     * rectangle.
     *
     * @param inner the inner rectangle to position
     * @param outer the outer rectangle to use as a reference
     */

    public void bottomRight(Rectangle inner, Rectangle outer) {
        LOG.debug("bottomRight()");
        Objects.requireNonNull(inner, "inner recntangle can't be null");
        Objects.requireNonNull(outer, "outer recntangle can't be null");
        if (outer.contains(inner)) {
            LOG.debug("Inner rectangle is inside outer rectangle");
            if (isBottomRightOverlap(outer, inner)) {
                isBottomRight = true;
                LOG.debug("Inner rectangle is overlapping with outer rectangle at the bottom");
            } else {
                LOG.debug("Inner rectangle is not overlapping with outer rectangle at the bottom");
            }
        } else {
            LOG.debug("Inner rectangle is not inside outer rectangle");
        }
    }

    /**
     * Put the inner rectangle so that it is centered vertically and horizontally
     *
     * @param inner the inner rectangle to position
     * @param outer the outer rectangle to use as a reference
     */
    public void middleCenter(Rectangle inner, Rectangle outer) {
        LOG.debug("middleCenter()");
        Objects.requireNonNull(inner, "inner recntangle can't be null");
        Objects.requireNonNull(outer, "outer recntangle can't be null");
        if (outer.contains(inner)) {
            if (isMiddleCenterOverlap(outer, inner)) {
                isMiddleCenter = true;
                LOG.debug("Inner rectangle is inside outer rectangle at middle/center");
            } else {
                LOG.debug("Inner rectangle is not overlapping with outer rectangle at middle/center");
            }
        } else {
            LOG.debug("Inner rectangle is not inside outer rectangle");
        }
    }

    /**
     * Check whether rectangle (r2) is overlapping with rectangle(r1) at bottom right.
     *
     * @param r1 the rectangle to position
     * @param r2 the rectangle to use as a reference
     */
    private boolean isBottomRightOverlap(Rectangle r1, Rectangle r2) {
        LOG.debug("isBottomRightOverlap()");
        Objects.requireNonNull(r1, "r1 recntangle can't be null");
        Objects.requireNonNull(r2, "r2 recntangle can't be null");
        double r1bx = r1.x + r1.width;
        double r1by = r1.y + r1.height;
        LOG.debug("Rectangle#1: (" + r1.x + ", " + r1.y + "), (" + r1bx + ", " + r1by + ")");
        double r2bx = r2.x + r2.width;
        double r2by = r2.y + r2.height;
        LOG.debug("Rectangle#2: (" + r2.x + ", " + r2.y + "), (" + r2bx + ", " + r2by + ")");

        return (r2bx <= r1bx && r2by <= r1by);
    }


    /**
     * Check whether rectangle (r2) is overlapping with rectangle(r1) at middle center.
     *
     * @param r1 the rectangle to position
     * @param r2 the rectangle to use as a reference
     */
    private boolean isMiddleCenterOverlap(Rectangle r1, Rectangle r2) {
        LOG.debug("isMiddleCenterOverlap()");
        Objects.requireNonNull(r1, "r1 recntangle can't be null");
        Objects.requireNonNull(r2, "r2 recntangle can't be null");
        double r1bx = r1.x + (r1.width / 2);
        double r1by = r1.y + (r1.height / 2);
        LOG.debug("Rectangle#1: (" + r1.x + ", " + r1.y + "), (" + r1bx + ", " + r1by + ")");
        double r2bx = r2.x + (r2.width / 2);
        double r2by = r2.y + (r2.height / 2);
        LOG.debug("Rectangle#2: (" + r2.x + ", " + r2.y + "), (" + r2bx + ", " + r2by + ")");

        return (r2bx <= r1bx && r2by <= r1by);
    }
}
