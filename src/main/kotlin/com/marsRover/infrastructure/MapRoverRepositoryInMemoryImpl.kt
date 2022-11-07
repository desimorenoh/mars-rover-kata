package com.marsRover.infrastructure

import com.marsRover.domain.Id
import com.marsRover.domain.RoverMap
import com.marsRover.domain.RoverMapRepository

class MapRoverRepositoryInMemoryImpl : RoverMapRepository {
    private val roverMap = mutableMapOf<String, RoverMap>()

    override fun save(newRoverMap: RoverMap) {
        roverMap.put(newRoverMap.id.value, newRoverMap)
    }

    override fun load(id: Id): RoverMap? {
        return roverMap.get(id.value)
    }
}