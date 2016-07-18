package com.mapbox.mapboxsdk.annotations;

import android.graphics.Color;

import com.mapbox.mapboxsdk.geometry.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Polygon is a geometry annotation that's a closed loop of coordinates.
 */
public class Polygon extends PointCollectionShape {

    private List<LatLng> points;
    private float alpha = 1.0f;

    private int fillColor = Color.BLACK; // default fillColor is black
    private int strokeColor = Color.BLACK; // default strokeColor is black

    public Polygon() {
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

    public int getFillColor() {
        return fillColor;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    void setFillColor(int color) {
        fillColor = color;
    }

    void setStrokeColor(int color) {
        strokeColor = color;
    }
}
