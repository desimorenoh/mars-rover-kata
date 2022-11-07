package com.marsRoverShould.acceptanceTest

import com.marsRover.application.MoveRoverUseCase
import com.marsRover.application.RoverMapUseCase
import com.marsRover.application.StartRoverUseCase
import com.marsRover.infrastructure.MapRoverRepositoryInMemoryImpl
import com.marsRover.infrastructure.MarsRoverController
import com.marsRover.infrastructure.RoverRepositoryInMemoryImpl
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MarsRoverControllerShould {

    @Test
    fun `should load the app`() {
        val marsRepository = MapRoverRepositoryInMemoryImpl()
        val roverRepository = RoverRepositoryInMemoryImpl()
        val input = ByteArrayInputStream("5 5 0 0 n f".toByteArray())
        System.setIn(input)
        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        val controller = MarsRoverController(
            RoverMapUseCase(marsRepository),
            MoveRoverUseCase(roverRepository, marsRepository),
            StartRoverUseCase(roverRepository)
        )
        assertThrows<NoSuchElementException> {
            controller.execute()
        }

        assertEquals(
            "Insert horizontal map size:\n" +
                    "Insert vertical map size:\n" +
                    "Insert horizontal initial rover position:\n" +
                    "Insert vertical initial rover position:\n" +
                    "Insert initial rover direction (n = north, e = east, w = west, s = south):\n" +
                    "Insert command (f = forward, b = backward, l = turn left, r = turn right):\n" +
                    "Rover is at x:0 y:1 facing:n\n" +
                    "Insert command (f = forward, b = backward, l = turn left, r = turn right):",
            output.toString().trim()
        )
    }
}