package com.mapbox.mapboxsdk.annotations;

import java.util.List;

/**
 * The `MGLShapeCollection` class represents a shape consisting of one or more
 * distinct but related shapes that are instances of `MGLShape`. The constituent
 * shapes can be a mixture of different kinds of shapes.
 * <p>
 * `ShapeCollection` objects cannot be added to a map view using
 * {@link com.mapbox.mapboxsdk.maps.MapboxMap#addAnnotations} and related methods.
 * </p>
 */
public class ShapeCollection extends Shape {

    private List<Shape> shapes;

    public ShapeCollection(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
