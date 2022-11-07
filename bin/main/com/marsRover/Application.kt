package com.marsRover

import com.marsRover.application.MoveRoverUseCase
import com.marsRover.application.RoverMapUseCase
import com.marsRover.application.StartRoverUseCase
import com.marsRover.infrastructure.MapRoverRepositoryInMemoryImpl
import com.marsRover.infrastructure.MarsRoverController
import com.marsRover.infrastructure.RoverRepositoryInMemoryImpl

open class Application {

  fun initialize() {
    // Initialize Repositories
    val roverMapRepository = MapRoverRepositoryInMemoryImpl()
    val roverRepository = RoverRepositoryInMemoryImpl()

    // Initialize Use cases
    val roverMapUseCase = RoverMapUseCase(roverMapRepository)
    val moveRoverUseCase = MoveRoverUseCase(roverRepository, roverMapRepository)
    val startRoverUseCase = StartRoverUseCase(roverRepository)

    // Start application
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