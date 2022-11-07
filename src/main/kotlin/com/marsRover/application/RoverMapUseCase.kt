package com.marsRover.application

import com.marsRover.domain.RoverMap
import com.marsRover.domain.RoverMapRepository

data class RoverMapUseCase(val roverMapRepository: RoverMapRepository) {
    fun saveMap(horizontalSize: Int, verticalSize: Int) {
        val roverMap = RoverMap(horizontalSize, verticalSize)
        roverMapRepository.save(roverMap)
    }
}