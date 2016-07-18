package com.mapbox.mapboxsdk.annotations;

import android.graphics.Color;

import com.mapbox.mapboxsdk.geometry.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Polyline is a geometry feature with an unclosed list of coordinates drawn as a line
 */
public class Polyline extends PointCollectionShape {

    private int color = Color.BLACK; // default color is black
    private float width = 10; // As specified by Google API Docs (in pixels)
    private List<LatLng> points;
    private float alpha = 1.0f;

    public Polyline() {
        super();
        points = new ArrayList<>();
    }

    /**
     * Returns a copy of the points.
     *
     * @return points - as a copy
     */
    public List<LatLng> getPoints() {
        return new ArrayList<>(points);
    }

    /**
     * Sets the points of this polyline. This method will take a copy
     * of the points, so further mutations to points will have no effect
     * on this polyline.
     *
     * @param points the points of the polyline
     */
    void setPoints(List<LatLng> points) {
        this.points = new ArrayList<>(points);
    }

    void addPoint(LatLng point) {
        points.add(point);
    }

    public float getAlpha() {
        return alpha;
    }

    void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public int getColor() {
        return color;
    }

    public float getWidth() {
        return width;
    }

    /**
     * Sets the color of the polyline.
     *
     * @param color - the color in ARGB format
     */
    void setColor(int color) {
        this.color = color;
    }

    /**
     * Sets the width of the polyline.
     *
     * @param width in pixels
     */
    void setWidth(float width) {
        this.width = width;
    }
}
