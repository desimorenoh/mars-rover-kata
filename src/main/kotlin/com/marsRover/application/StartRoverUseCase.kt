package com.marsRover.application

import com.marsRover.domain.Coordinate
import com.marsRover.domain.ForbiddenDirection
import com.marsRover.domain.Id
import com.marsRover.domain.Orientation
import com.marsRover.domain.OrientationValue
import com.marsRover.domain.Rover
import com.marsRover.domain.RoverRepository

class StartRoverUseCase(
    private val roverRepository: RoverRepository,
) {
    fun startRover(
        id: Id,
        roverInitialHorizontalPosition: Int,
        roverInitialVerticalPosition: Int,
        roverInitialDirection: String,
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
        roverRepository.save(initialRover)
        return initialRover
    }
}