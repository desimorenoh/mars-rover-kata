package com.marsRover.application

import com.marsRover.domain.Id
import com.marsRover.domain.RoverMap
import com.marsRover.domain.RoverMapRepository

data class RoverMapUseCase(val roverMapRepository: RoverMapRepository) {
    fun saveMap(id: Id, horizontalSize: Int, verticalSize: Int): RoverMap {
        val roverMap = RoverMap(id, horizontalSize, verticalSize)
        roverMapRepository.save(roverMap)
        return roverMap
    }
}