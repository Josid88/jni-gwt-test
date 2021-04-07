#ifndef GDX_TRANSFORM_H
#define GDX_TRANSFORM_H

struct GdxPosition;
struct GdxTransform;

GdxTransform* gdxTransformNew();
void gdxTransformFree(GdxTransform* transform);
void gdxTransformSetPosition(GdxTransform* transform, float x, float y);
GdxPosition gdxTransformGetPosition(GdxTransform* transform);
void gdxTransformSetAngle(GdxTransform* transform, float angle);
float gdxTransformGetAngle(GdxTransform* transform);

#endif
