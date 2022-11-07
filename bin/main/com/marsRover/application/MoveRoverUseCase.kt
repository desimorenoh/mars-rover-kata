package com.marsRover.application

import com.marsRover.domain.ForbiddenMove
import com.marsRover.domain.Rover
import com.marsRover.domain.RoverMapRepository
import com.marsRover.domain.RoverRepository

class MoveRoverUseCase(
    private val roverRepository: RoverRepository,
    private val mapRoverRepository: RoverMapRepository
) {
    fun move(command: String): Rover {
        // load map to know the limits
        val mapRover = mapRoverRepository.load()
        // load previous rover position
        val rover = roverRepository.load()
        // Move rover to a new position
        val roverMoved: Rover =
            when (command) {
                "f" -> rover.moveForward(mapRover)
                "b" -> rover.moveBackward(mapRover)
                "l" -> rover.moveLeft()
                "r" -> rover.moveRight()
                else -> throw ForbiddenMove("move not allowed")
            }
        // save new rover position
        roverRepository.save(roverMoved)
        return roverMoved
    }
}