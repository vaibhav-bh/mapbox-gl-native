package com.mapbox.mapboxsdk.annotations;

import java.util.List;
import java.util.Map;

public class MultiPolylineFeature extends MultiPolyline implements Feature {
    private long featureId;
    private Map<String, Object> attributes;

    public MultiPolylineFeature(List<Polyline> polylineList) {
        super(polylineList);
    }

    @Override
    public long getFeatureId() {
        return featureId;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Object getAttribute(String key) {
        return attributes.get(key);
    }
}
