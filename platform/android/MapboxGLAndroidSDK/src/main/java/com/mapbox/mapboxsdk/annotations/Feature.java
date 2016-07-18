package com.mapbox.mapboxsdk.annotations;


import java.util.Map;

/**
 * The `Feature` protocol is used to provide details about geographic features
 * contained in a map view’s
 * <a href="https://www.mapbox.com/mapbox-gl-style-spec/#sources">tile sources</a>.
 * Each concrete subclass of `Shape` in turn has a subclass that conforms to
 * this protocol.
 * <p>
 * Typically,you do not create feature objects yourself but rather obtain them
 * using{
 *
 * @link com.mapbox.mapboxsdk.maps.MapboxMap#getVisibleFeatures(PointF)}
 * and related methods.Each feature object associates a shape with an identifier and
 * attributes as specified by the source.Like ordinary Annotation objects,some kinds of `Feature`
 * objects can also be added to a map view using `-[MGLMapView addAnnotations:]`
 * and related methods.
 */
public interface Feature extends Annotation {

    /**
     * A long that uniquely identifies the feature in its containing
     * <a href="https://www.mapbox.com/mapbox-gl-style-spec/#sources">tile source</a>.
     * <p>
     * The identifier corresponds to the
     * <a href="https://github.com/mapbox/vector-tile-spec/tree/master/2.1#42-features">feature identifier</a>
     * (`id`) in the tile source. If the source does not specify the feature’s
     * identifier, the value of this property is `nil`. If specified, the identifier
     * may be an integer, floating-point number, or string. These data types are
     * mapped to instances of the following Foundation classes:
     * <p>
     * For details about the identifiers used in most Mapbox-provided styles, consult
     * the
     * <a href="https://www.mapbox.com/vector-tiles/mapbox-streets/">Mapbox Streets</a>
     * layer reference.
     *
     * @return the identifier associated with this feature
     */
    long getFeatureId();

    /**
     * A Map of attributes for this feature specified by the
     * <a href="https://www.mapbox.com/mapbox-gl-style-spec/#sources">tile source</a>.
     * <p>
     * The keys and values of this dictionary are determined by the tile source. In
     * the tile source, each attribute name is a string, while each attribute value
     * may be a null value, Boolean value, integer, floating-point number, or string.
     * These data types are mapped to instances of the following Foundation classes:
     * For details about the attribute names and values found in Mapbox-provided
     * vector tile sources, consult the
     * <a href="https://www.mapbox.com/vector-tiles/mapbox-streets/">Mapbox Streets</a>
     * and
     * <a href="https://www.mapbox.com/vector-tiles/mapbox-terrain/">Mapbox Terrain</a>
     * layer references.
     */
    Map<String, Object> getAttributes();

    /**
     * Returns the feature attribute for the given attribute name.
     * <p>
     * See the `attributes` property’s documentation for details on keys and values
     * associated with this method.
     *
     * @param key the key associated to the attribute
     * @return the
     */
    Object getAttribute(String key);
}