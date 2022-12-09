package com.marsRover.application

import com.marsRover.domain.*

class StartRoverUseCase(
    private val roverRepository: RoverRepository,
) {
    fun startRover(
        id: Id,
        roverInitialHorizontalPosition: Int,
        roverInitialVerticalPosition: Int,
        roverInitialDirection: String,
        horizontalSize: Int,
        verticalSize: Int
    ): Rover {
        val directionOrigin = when (roverInitialDirection) {
            "n" -> Orientation(OrientationValue.NORTH)
            "s" -> Orientation(OrientationValue.SOUTH)
            "e" -> Orientation(OrientationValue.EAST)
            "w" -> Orientation(OrientationValue.WEST)
            else -> throw ForbiddenDirection("direction not allowed")
        }
        val coordinateOrigin = Coordinate(roverInitialHorizontalPosition, roverInitialVerticalPosition)
        val initialRover = Rover(id, coordinateOrigin, directionOrigin)
        val mapSize = Coordinate(horizontalSize, verticalSize)
        when {
            initialRover.coordinate.x > mapSize.x || initialRover.coordinate.y > mapSize.y -> {
                throw ForbiddenPosition("position not allowed")
            }
            initialRover.coordinate.x < -mapSize.x || initialRover.coordinate.y < -mapSize.y -> {
                throw ForbiddenPosition("position not allowed")
            }
            else -> {
                roverRepository.save(initialRover)
                return initialRover
            }
        }
    }
}