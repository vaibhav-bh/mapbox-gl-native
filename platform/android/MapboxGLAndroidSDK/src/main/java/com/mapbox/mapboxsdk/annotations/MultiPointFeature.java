package com.mapbox.mapboxsdk.annotations;

import java.util.Map;

public class MultiPointFeature extends MultiPoint implements Feature {

    private long featureId;
    private Map<String, Object> attributes;

    public MultiPointFeature() {
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
