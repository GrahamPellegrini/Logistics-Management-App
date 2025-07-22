cmake_minimum_required(VERSION 3.10)
project(Q3Project)

# Set C++ Standard
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED True)

# Include directories
include_directories(${CMAKE_SOURCE_DIR}/include)
include_directories(${CMAKE_SOURCE_DIR}/include/Product)
include_directories(${CMAKE_SOURCE_DIR}/include/Shipment)
include_directories(${CMAKE_SOURCE_DIR}/include/Transport)

# Source files
file(GLOB SOURCES "src/*.cpp" "src/Product/*.cpp" "src/Shipment/*.cpp" "src/Transport/*.cpp")

# Add executable
add_executable(Q3Project ${SOURCES})

