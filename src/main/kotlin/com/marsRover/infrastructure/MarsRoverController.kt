package com.marsRover.infrastructure

import com.marsRover.application.MoveRoverUseCase
import com.marsRover.application.RoverMapUseCase
import com.marsRover.application.StartRoverUseCase
import com.marsRover.domain.Id
import java.util.Scanner
import java.util.UUID


class MarsRoverController(
    private val roverMapUseCase: RoverMapUseCase,
    private val moveRoverUseCase: MoveRoverUseCase,
    private val startRoverUseCase: StartRoverUseCase
) {
    fun execute() {
        val reader = Scanner(System.`in`)
        println("Insert horizontal map size:")
        val mapHorizontalSize = reader.nextInt()
        println("Insert vertical map size:")
        val mapVerticalSize = reader.nextInt()
        println("Insert horizontal initial rover position:")
        val roverInitialHorizontalPosition = reader.nextInt()
        println("Insert vertical initial rover position:")
        val roverInitialVerticalPosition = reader.nextInt()
        println("Insert initial rover direction (n = north, e = east, w = west, s = south):")
        val roverInitialDirection = reader.next()

        val savedMap = roverMapUseCase.saveMap(Id(UUID.randomUUID().toString()), mapHorizontalSize, mapVerticalSize)

        val startRover = startRoverUseCase.startRover(
            Id(UUID.randomUUID().toString()),
            roverInitialHorizontalPosition,
            roverInitialVerticalPosition,
            roverInitialDirection,
            mapHorizontalSize,
            mapVerticalSize
        )

        do {
            println("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
            val command = reader.next()

            val rover = moveRoverUseCase.move(startRover.id, savedMap.id, command)

            println(
                String.format(
                    "Rover is at x:%d y:%d facing:%s",
                    rover.coordinate.x,
                    rover.coordinate.y,
                    rover.orientation.value.direction
                )
            )
        } while (true)
    }
}