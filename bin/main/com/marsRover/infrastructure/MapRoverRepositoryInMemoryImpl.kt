package com.marsRover.infrastructure

import com.marsRover.domain.RoverMap
import com.marsRover.domain.RoverMapRepository

class MapRoverRepositoryInMemoryImpl : RoverMapRepository {
    private var roverMap: RoverMap? = null

    override fun save(newRoverMap: RoverMap) {
        roverMap = newRoverMap
    }

    override fun load(): RoverMap {
        return roverMap!!
    }
}