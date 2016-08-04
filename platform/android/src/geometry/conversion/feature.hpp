#pragma once

#include "../../conversion/conversion.hpp"

#include <mbgl/util/optional.hpp>
#include <jni/jni.hpp>

#include <string>
#include <array>
#include <vector>
#include <sstream>

namespace mbgl {
namespace android {
namespace conversion {

template <>
struct Converter<jni::jarray<jni::jobject>*, std::vector<Feature>> {
    Result<jni::jarray<jni::jobject>*> operator()(jni::JNIEnv& env, const std::vector<Feature>& value) const {
        static jni::jclass* featureClass = jni::NewGlobalRef(env, &jni::FindClass(env, "com/mapbox/mapboxsdk/geojson/Feature")).release();
        jni::jarray<jni::jobject>& jarray = jni::NewObjectArray(env, value.size(), *featureClass);
        return {&jarray};
    }
};

} // namespace conversion
} // namespace android
} // namespace mbgl
