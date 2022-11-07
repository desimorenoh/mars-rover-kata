package com.marsRoverShould.unitTest

import com.marsRover.application.MoveRoverUseCase
import com.marsRover.domain.Coordinate
import com.marsRover.domain.ForbiddenMove
import com.marsRover.domain.Id
import com.marsRover.domain.Orientation
import com.marsRover.domain.OrientationValue.NORTH
import com.marsRover.domain.OrientationValue.EAST
import com.marsRover.domain.Rover
import com.marsRover.domain.RoverMap
import com.marsRover.domain.RoverMapRepository
import com.marsRover.domain.RoverRepository
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoveRoverUseCaseShould {

    @Mock
    private lateinit var roverRepository: RoverRepository

    @Mock
    private lateinit var roverMapRepository: RoverMapRepository

    @InjectMocks
    private lateinit var moveRoverUseCase: MoveRoverUseCase

    @Test
    fun `move rover forward`() {
        val expectedSavedRover = Rover(Id("uuid"), Coordinate(0, 1), Orientation(NORTH))
        Mockito.`when`(roverRepository.load(Id("uuid"))).thenReturn(Rover(Id("uuid"), Coordinate(0, 0), Orientation(NORTH)))
        Mockito.`when`(roverMapRepository.load(Id("uuid"))).thenReturn(RoverMap(Id("uuid"),5, 5))

        val result = moveRoverUseCase.move(Id("uuid"), Id("uuid"), "f")

        Mockito.verify(roverMapRepository).load(Id("uuid"))
        Mockito.verify(roverRepository).load(Id("uuid"))
        Mockito.verify(roverRepository).save(expectedSavedRover)
        assertEquals(expectedSavedRover, result)
    }

    @Test
    fun `move rover backward`() {
        val expectedSavedRover = Rover(Id("uuid"), Coordinate(0, -1), Orientation(NORTH))
        Mockito.`when`(roverRepository.load(Id("uuid"))).thenReturn(Rover(Id("uuid"), Coordinate(0, 0), Orientation(NORTH)))
        Mockito.`when`(roverMapRepository.load(Id("uuid"))).thenReturn(RoverMap(Id("uuid"), 5, 5))

        val result = moveRoverUseCase.move(Id("uuid"), Id("uuid"), "b")

        Mockito.verify(roverMapRepository).load(Id("uuid"))
        Mockito.verify(roverRepository).load(Id("uuid"))
        Mockito.verify(roverRepository).save(expectedSavedRover)
        assertEquals(expectedSavedRover, result)
    }

    @Test
    fun `turn left rover from east`() {
        val expectedSavedRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(NORTH))
        Mockito.`when`(roverRepository.load(Id("uuid"))).thenReturn(Rover(Id("uuid"), Coordinate(0, 0), Orientation(EAST)))
        Mockito.`when`(roverMapRepository.load(Id("uuid"))).thenReturn(RoverMap(Id("uuid"), 5, 5))

        val result = moveRoverUseCase.move(Id("uuid"), Id("uuid"), "l")

        Mockito.verify(roverMapRepository).load(Id("uuid"))
        Mockito.verify(roverRepository).load(Id("uuid"))
        Mockito.verify(roverRepository).save(expectedSavedRover)
        assertEquals(expectedSavedRover, result)
    }

    @Test
    fun `turn right rover from north`() {
        val expectedSavedRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(EAST))
        Mockito.`when`(roverRepository.load(Id("uuid"))).thenReturn(Rover(Id("uuid"), Coordinate(0, 0), Orientation(NORTH)))
        Mockito.`when`(roverMapRepository.load(Id("uuid"))).thenReturn(RoverMap(Id("uuid"), 5, 5))

        val result = moveRoverUseCase.move(Id("uuid"), Id("uuid"), "r")

        Mockito.verify(roverMapRepository).load(Id("uuid"))
        Mockito.verify(roverRepository).load(Id("uuid"))
        Mockito.verify(roverRepository).save(expectedSavedRover)
        assertEquals(expectedSavedRover, result)
    }

    @Test
    fun `move rover with not valid movement`() {
        Mockito.`when`(roverRepository.load(Id("uuid"))).thenReturn(Rover(Id("uuid"), Coordinate(0, 0), Orientation(NORTH)))
        Mockito.`when`(roverMapRepository.load(Id("uuid"))).thenReturn(RoverMap(Id("uuid"), 5, 5))

        assertThrows<ForbiddenMove>{
            moveRoverUseCase.move(Id("uuid"), Id("uuid"), "z")
        }
    }
}