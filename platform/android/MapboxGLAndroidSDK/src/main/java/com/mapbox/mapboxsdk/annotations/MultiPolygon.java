package com.mapbox.mapboxsdk.annotations;

import java.util.ArrayList;
import java.util.List;

public class MultiPolygon extends Shape{

    private List<Polygon> polygons;

    public MultiPolygon() {
        polygons = new ArrayList<>();
    }

    public void addPolygon(Polygon polygon){
        polygons.add(polygon);
    }

    public List<Polygon> getPolygons() {
        return polygons;
    }
}
