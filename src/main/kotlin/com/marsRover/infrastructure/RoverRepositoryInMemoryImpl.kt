package com.marsRover.infrastructure

import com.marsRover.domain.Id
import com.marsRover.domain.Rover
import com.marsRover.domain.RoverRepository

class RoverRepositoryInMemoryImpl : RoverRepository {
    private val rovers = mutableMapOf<String, Rover>()

    override fun save(newRover: Rover) {
        rovers.put(newRover.id.value, newRover)
    }

    override fun load(id: Id): Rover? {
        return rovers.get(id.value)
    }
}