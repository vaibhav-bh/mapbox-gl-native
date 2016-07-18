package com.mapbox.mapboxsdk.annotations;

import java.util.List;

public class MultiPolyline extends Shape {

    private List<Polyline> polylines;

    public MultiPolyline(List<Polyline> polylines) {
        this.polylines = polylines;
    }

    public List<Polyline> getPolylines() {
        return polylines;
    }
}
