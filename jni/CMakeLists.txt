cmake_minimum_required(VERSION 3.1)
project( GDX_GWT C )

set(CMAKE_C_STANDARD 99)

file(GLOB chipmunk_source_files "./gdx/src/*.c")
file(GLOB chipmunk_public_header "./gdx/include/gdx/*.h")

include_directories( ./gdx/include )
add_library(chipmunk STATIC ${chipmunk_source_files})
target_link_libraries( chipmunk )
