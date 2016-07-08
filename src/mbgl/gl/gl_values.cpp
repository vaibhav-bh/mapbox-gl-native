#include "gl_values.hpp"

namespace mbgl {
namespace gl {

const StencilFunc::Type StencilFunc::Default;
const StencilMask::Type StencilMask::Default;
const StencilTest::Type StencilTest::Default;
const StencilOp::Type StencilOp::Default;
const DepthRange::Type DepthRange::Default;
const DepthMask::Type DepthMask::Default;
const DepthTest::Type DepthTest::Default;
const DepthFunc::Type DepthFunc::Default;
const Blend::Type Blend::Default;
const BlendFunc::Type BlendFunc::Default;
const BlendColor::Type BlendColor::Default;
const ColorMask::Type ColorMask::Default;
const ClearDepth::Type ClearDepth::Default;
const ClearColor::Type ClearColor::Default;
const ClearStencil::Type ClearStencil::Default;
const Program::Type Program::Default;
const LineWidth::Type LineWidth::Default;
const ActiveTexture::Type ActiveTexture::Default;
const BindTexture::Type BindTexture::Default;
const BindVAO::Type BindVAO::Default;

#ifndef GL_ES_VERSION_2_0
const PixelZoom::Type PixelZoom::Default;
const RasterPos::Type RasterPos::Default;
#endif // GL_ES_VERSION_2_0

} // namespace gl
} // namespace mbgl
