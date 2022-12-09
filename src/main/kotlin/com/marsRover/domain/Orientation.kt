package com.marsRover.domain

import com.marsRover.domain.OrientationValue.*

data class Orientation(val value: OrientationValue) {

    fun rotateRight(): Orientation = when (value) {
        NORTH -> EAST
        SOUTH -> WEST
        EAST -> SOUTH
        WEST -> NORTH
    }
        .let { Orientation(it) }

    fun rotateLeft(): Orientation = when (value) {
        NORTH -> WEST
        WEST -> SOUTH
        SOUTH -> EAST
        EAST -> NORTH
    }
        .let { Orientation(it) }
}

enum class OrientationValue(val direction: String) {
    NORTH("n"),
    SOUTH("s"),
    EAST("e"),
    WEST("w")
}