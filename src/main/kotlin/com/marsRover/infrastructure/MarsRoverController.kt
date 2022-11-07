package com.marsRover.infrastructure

import com.marsRover.application.MoveRoverUseCase
import com.marsRover.application.RoverMapUseCase
import com.marsRover.application.StartRoverUseCase
import java.util.Scanner

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

        // Save original map
        roverMapUseCase.saveMap(mapHorizontalSize, mapVerticalSize)
        // Start rover from initial position
        startRoverUseCase.startRover(roverInitialHorizontalPosition, roverInitialVerticalPosition, roverInitialDirection)

        do {
            println("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
            val command = reader.next()
            // Move rover to a new position
            val rover = moveRoverUseCase.move(command)
            // print the new position
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