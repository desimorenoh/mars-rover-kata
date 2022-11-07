package com.marsRover.domain

data class Orientation(val value: OrientationValue)

enum class OrientationValue(val direction: String) {
    NORTH("n"),
    SOUTH("s"),
    EAST("e"),
    WEST("w")
}