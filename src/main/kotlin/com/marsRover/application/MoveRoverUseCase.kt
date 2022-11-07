package com.marsRover.application

import com.marsRover.domain.ForbiddenMove
import com.marsRover.domain.Id
import com.marsRover.domain.MapNotFound
import com.marsRover.domain.Rover
import com.marsRover.domain.RoverMapRepository
import com.marsRover.domain.RoverNotFound
import com.marsRover.domain.RoverRepository

class MoveRoverUseCase(
    private val roverRepository: RoverRepository,
    private val mapRoverRepository: RoverMapRepository
) {
    fun move(roverId: Id, mapId: Id, command: String): Rover {
        val mapRover = mapRoverRepository.load(mapId) ?: throw MapNotFound("map not found")
        val rover = roverRepository.load(roverId) ?: throw RoverNotFound("rover not found")

        val roverMoved: Rover =
            when (command) {
                "f" -> rover.moveForward(mapRover)
                "b" -> rover.moveBackward(mapRover)
                "l" -> rover.moveLeft()
                "r" -> rover.moveRight()
                else -> throw ForbiddenMove("move not allowed")
            }
        roverRepository.save(roverMoved)
        return roverMoved
    }
}