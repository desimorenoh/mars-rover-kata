package com.marsRoverShould.unitTest

import com.marsRover.application.StartRoverUseCase
import com.marsRover.domain.Coordinate
import com.marsRover.domain.ForbiddenDirection
import com.marsRover.domain.Orientation
import com.marsRover.domain.OrientationValue.NORTH
import com.marsRover.domain.Rover
import com.marsRover.domain.RoverMapRepository
import com.marsRover.domain.RoverRepository
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class StartRoverUseCaseShould {

    @Mock
    private lateinit var roverRepository: RoverRepository

    @Mock
    private lateinit var roverMapRepository: RoverMapRepository

    @InjectMocks
    private lateinit var startRoverUseCase: StartRoverUseCase

    @Test
    fun `start rover`() {
        val expectedSavedRover = Rover(Coordinate(0, 0), Orientation(NORTH))

        startRoverUseCase.startRover(0, 0, "n")

        Mockito.verify(roverRepository).save(expectedSavedRover)
    }

    @Test
    fun `start rover with not valid direction`() {

        assertThrows<ForbiddenDirection>{
            startRoverUseCase.startRover(0, 0, "z")
        }
    }
}