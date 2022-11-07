package com.marsRoverShould.integrationTest

import com.marsRover.domain.Coordinate
import com.marsRover.domain.Id
import com.marsRover.domain.Orientation
import com.marsRover.domain.OrientationValue.NORTH
import com.marsRover.domain.Rover
import com.marsRover.infrastructure.RoverRepositoryInMemoryImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RoverRepositoryImplShould {

    private val roverRepositoryImpl: RoverRepositoryInMemoryImpl = RoverRepositoryInMemoryImpl()

    @Test
    fun `save and load a rover`() {
        val rover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(NORTH))
        roverRepositoryImpl.save(rover)

        val loadedRover = roverRepositoryImpl.load(Id("uuid"))

        assertEquals(rover, loadedRover)
    }
}