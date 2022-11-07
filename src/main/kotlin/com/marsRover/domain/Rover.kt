package com.marsRover.domain

import com.marsRover.domain.OrientationValue.NORTH
import com.marsRover.domain.OrientationValue.SOUTH
import com.marsRover.domain.OrientationValue.EAST
import com.marsRover.domain.OrientationValue.WEST

data class Rover(val id: Id, val coordinate: Coordinate, val orientation: Orientation) {
    fun moveForward(mapRover: RoverMap): Rover {
        val movement = nextForwardMovement(coordinate)
        val coordinate = checkForwardMovement(movement, mapRover, coordinate)
        return this.copy(coordinate = coordinate)
    }

    fun moveBackward(mapRover: RoverMap): Rover {
        val movement = nextBackwardMovement()
        val coordinate = checkBackwardMovement(movement, mapRover)
        return this.copy(coordinate = coordinate)
    }

    fun moveRight(): Rover {
        val orientation =
            when (orientation.value) {
                NORTH -> Orientation(EAST)
                SOUTH -> Orientation(WEST)
                EAST -> Orientation(SOUTH)
                WEST -> Orientation(NORTH)
            }
        return this.copy(orientation = orientation)
    }

    fun moveLeft(): Rover {
        val orientation =
            when (orientation.value) {
                NORTH -> Orientation(WEST)
                SOUTH -> Orientation(EAST)
                EAST -> Orientation(NORTH)
                WEST -> Orientation(SOUTH)
            }
        return this.copy(orientation = orientation)
    }

    private fun nextForwardMovement(coordinate: Coordinate) = when (orientation.value) {
        NORTH -> Coordinate(coordinate.x, coordinate.y + 1)
        SOUTH -> Coordinate(coordinate.x, coordinate.y - 1)
        EAST -> Coordinate(coordinate.x + 1, coordinate.y)
        WEST -> Coordinate(coordinate.x - 1, coordinate.y)
    }

    private fun checkForwardMovement(
        movement: Coordinate,
        mapRover: RoverMap,
        coordinate: Coordinate
    ): Coordinate {
        return if (movement.y == mapRover.verticalSize + 1) {
            Coordinate(coordinate.x, (-mapRover.verticalSize))
        } else if (movement.y == -mapRover.verticalSize - 1) {
            Coordinate(coordinate.x, mapRover.verticalSize)
        } else if (movement.x == mapRover.horizontalSize + 1) {
            Coordinate((-mapRover.horizontalSize), coordinate.y)
        } else if (movement.x == -mapRover.horizontalSize - 1) {
            Coordinate(mapRover.horizontalSize, coordinate.y)
        } else movement
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

    private fun checkBackwardMovement(movement: Coordinate, mapRover: RoverMap): Coordinate {
        return if (movement.y == -mapRover.verticalSize - 1) {
            Coordinate(movement.x, mapRover.verticalSize)
        } else if (movement.y == mapRover.verticalSize + 1) {
            Coordinate(movement.x, (-mapRover.verticalSize))
        } else if (movement.x == -mapRover.horizontalSize - 1) {
            Coordinate(mapRover.horizontalSize, movement.y)
        } else if (movement.x == mapRover.horizontalSize + 1) {
            Coordinate((-mapRover.horizontalSize), movement.y)
        } else movement
    }
}