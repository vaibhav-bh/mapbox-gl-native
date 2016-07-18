package com.mapbox.mapboxsdk.annotations;

import java.util.Map;

public class PointFeature extends Marker implements Feature {

    private long featureId;
    private Map<String, Object>attributes;

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
