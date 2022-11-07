package com.marsRover

import com.marsRover.application.MoveRoverUseCase
import com.marsRover.application.RoverMapUseCase
import com.marsRover.application.StartRoverUseCase
import com.marsRover.infrastructure.MapRoverRepositoryInMemoryImpl
import com.marsRover.infrastructure.MarsRoverController
import com.marsRover.infrastructure.RoverRepositoryInMemoryImpl

open class Application {

    fun initialize() {
        val roverMapRepository = MapRoverRepositoryInMemoryImpl()
        val roverRepository = RoverRepositoryInMemoryImpl()
        val roverMapUseCase = RoverMapUseCase(roverMapRepository)
        val moveRoverUseCase = MoveRoverUseCase(roverRepository, roverMapRepository)
        val startRoverUseCase = StartRoverUseCase(roverRepository)

        MarsRoverController(
            roverMapUseCase,
            moveRoverUseCase,
            startRoverUseCase
        ).execute()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application().initialize()
        }
    }
}