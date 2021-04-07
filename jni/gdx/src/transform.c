#include "gdx/transform.h"
#include <stdlib.h>

struct GdxPosition {
    float x;
    float y;
};

struct GdxTransform {
    float x;
    float y;
    float angle;
};

GdxTransform* gdxTransformNew() {
    GdxTransform* transform = (GdxTransform*) malloc(sizeof(GdxTransform));
    transform->x = 0;
    transform->y = 0;
    transform->angle = 0;
    return transform;
}

void gdxTransformFree(GdxTransform* transform) {
    free(transform);
}

void gdxTransformSetPosition(GdxTransform* transform, float x, float y) {
    transform->x = x;
    transform->y = y;
}

GdxPosition gdxTransformGetPosition(GdxTransform* transform) {
    GdxPosition position;
    position.x = transform->x;
    position.y = transform->y;
    return position;
}

void gdxTransformSetAngle(GdxTransform* transform, float angle) {
    transform->angle = angle;
}

float gdxTransformGetAngle(GdxTransform* transform) {
    return transform->angle;
}
