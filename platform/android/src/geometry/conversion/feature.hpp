#pragma once

#include "../../conversion/conversion.hpp"

#include <mbgl/util/optional.hpp>
#include <mapbox/geometry.hpp>
#include <jni/jni.hpp>

#include <string>
#include <array>
#include <vector>
#include <sstream>

namespace mbgl {
namespace android {
namespace conversion {


template <class T>
struct Converter<jni::jobject*, mapbox::geometry::feature<T>> {
    Result<jni::jobject*> operator()(jni::JNIEnv& env, const mapbox::geometry::feature<T>& value) const {
        static jni::jclass* javaClass = jni::NewGlobalRef(env, &jni::FindClass(env, "com/mapbox/services/commons/geojson/Feature")).release();
        static jni::jmethodID* fromGeometry = &jni::GetStaticMethodID(env, *javaClass, "fromGeometry", "(Lcom/mapbox/services/commons/geojson/Geometry;)Lcom/mapbox/services/commons/geojson/Feature;");
        /**, TODO: converted geometry**/
        return {reinterpret_cast<jni::jobject*>(jni::CallStaticMethod<jni::jobject*>(env, *javaClass, *fromGeometry, (jni::jobject*) nullptr))};
    }
};

template <class T>
struct Converter<jni::jarray<jni::jobject>*, std::vector<mapbox::geometry::feature<T>>> {
    Result<jni::jarray<jni::jobject>*> operator()(jni::JNIEnv& env, const std::vector<mapbox::geometry::feature<T>>& value) const {
        static jni::jclass* featureClass = jni::NewGlobalRef(env, &jni::FindClass(env, "com/mapbox/services/commons/geojson/Feature")).release();
        jni::jarray<jni::jobject>& jarray = jni::NewObjectArray(env, value.size(), *featureClass);

        for(size_t i = 0; i < value.size(); i = i + 1) {
            Result<jni::jobject*> converted = convert<jni::jobject*, mapbox::geometry::feature<T>>(env, value.at(i));
            jni::SetObjectArrayElement(env, jarray, i, *converted);
        }

        return {&jarray};
    }
};

} // namespace conversion
} // namespace android
} // namespace mbgl
