package com.mapbox.mapboxsdk.annotations;

import java.util.ArrayList;
import java.util.List;

public class FeatureWrapper {

    private List<Feature> features;

    public FeatureWrapper() {
        features = new ArrayList<>();
    }

    public void add(Feature feature) {
        features.add(feature);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Feature f : features) {
            builder.append("\n").append(f.getClass().getSimpleName());
        }
        return builder.toString();
    }
}
