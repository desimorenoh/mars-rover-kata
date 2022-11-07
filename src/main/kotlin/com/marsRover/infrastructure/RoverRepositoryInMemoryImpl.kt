package com.marsRover.infrastructure

import com.marsRover.domain.Rover
import com.marsRover.domain.RoverRepository

class RoverRepositoryInMemoryImpl : RoverRepository {
    private var rover: Rover? = null

    override fun save(newRover: Rover) {
        rover = newRover
    }

    override fun load(): Rover {
        return rover!!
    }
}