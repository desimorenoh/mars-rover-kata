package com.marsRover.domain

import com.marsRover.domain.OrientationValue.NORTH
import com.marsRover.domain.OrientationValue.SOUTH
import com.marsRover.domain.OrientationValue.EAST
import com.marsRover.domain.OrientationValue.WEST

data class Rover(val id: Id, val coordinate: Coordinate, val orientation: Orientation) {
    fun moveForward(mapRover: RoverMap): Rover {
        val movement = nextForwardMovement(coordinate)
        val coordinate = mapRover.checkForwardMovement(movement, mapRover, coordinate)
        return this.copy(coordinate = coordinate)
    }

    fun moveBackward(mapRover: RoverMap): Rover {
        val movement = nextBackwardMovement()
        val coordinate = mapRover.checkBackwardMovement(movement, mapRover)
        return this.copy(coordinate = coordinate)
    }

    fun rotateRight() = this.copy(orientation = orientation.rotateRight())

    fun rotateLeft() = this.copy(orientation = orientation.rotateLeft())

    private fun nextForwardMovement(coordinate: Coordinate) = when (orientation.value) {
        NORTH -> Coordinate(coordinate.x, coordinate.y + 1)
        SOUTH -> Coordinate(coordinate.x, coordinate.y - 1)
        EAST -> Coordinate(coordinate.x + 1, coordinate.y)
        WEST -> Coordinate(coordinate.x - 1, coordinate.y)
    }

    private fun nextBackwardMovement(): Coordinate {
        val coordinate =
            when (orientation.value) {
                NORTH -> Coordinate(coordinate.x, coordinate.y - 1)
                SOUTH -> Coordinate(coordinate.x, coordinate.y + 1)
                EAST -> Coordinate(coordinate.x - 1, coordinate.y)
                WEST -> Coordinate(coordinate.x + 1, coordinate.y)
            }
        return coordinate
    }
}