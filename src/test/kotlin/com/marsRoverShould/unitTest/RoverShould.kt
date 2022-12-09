package com.marsRoverShould.unitTest

import com.marsRover.domain.Coordinate
import com.marsRover.domain.Id
import com.marsRover.domain.Orientation
import com.marsRover.domain.OrientationValue.NORTH
import com.marsRover.domain.OrientationValue.EAST
import com.marsRover.domain.OrientationValue.SOUTH
import com.marsRover.domain.OrientationValue.WEST
import com.marsRover.domain.Rover
import com.marsRover.domain.RoverMap
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RoverShould {

    //move vertically
    @Test
    fun `should move forward`() {
        val givenRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(NORTH))
        val givenMap = RoverMap(Id("uuid"), 5, 5)
        val expectedRover = Rover(Id("uuid"), Coordinate(0, 1), Orientation(NORTH))

        val result = givenRover.moveForward(givenMap)

        assertEquals(expectedRover, result)
    }

    @Test
    fun `should move backward`() {
        val givenRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(NORTH))
        val givenMap = RoverMap( Id("uuid"), 5, 5)
        val expectedRover = Rover(Id("uuid"), Coordinate(0, -1), Orientation(NORTH))

        val result = givenRover.moveBackward(givenMap)

        assertEquals(expectedRover, result)
    }

    //rotate to the right
    @Test
    fun `should face east when turn right from north position`() {
        val givenRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(NORTH))
        val expectedRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(EAST))

        val result = givenRover.rotateRight()

        assertEquals(expectedRover, result)
    }

    @Test
    fun `should face south when turn right from east position`() {
        val givenRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(SOUTH))
        val expected = Rover(Id("uuid"), Coordinate(0, 0), Orientation(WEST))

        val result = givenRover.rotateRight()

        assertEquals(expected, result)
    }

    @Test
    fun `should face west when turn right from south position`() {
        val givenRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(EAST))
        val expectedRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(SOUTH))

        val result = givenRover.rotateRight()

        assertEquals(expectedRover, result)
    }

    @Test
    fun `should face north when turn right from west position`() {
        val givenRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(WEST))
        val expectedRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(NORTH))

        val result = givenRover.rotateRight()

        assertEquals(expectedRover, result)
    }

    //rotate to the left
    @Test
    fun `should face west when turn left from north position`() {
        val givenRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(NORTH))
        val expectedRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(WEST))

        val result = givenRover.rotateLeft()

        assertEquals(expectedRover, result)
    }

    @Test
    fun `should face north when turn left from east position`() {
        val givenRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(EAST))
        val expectedRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(NORTH))

        val result = givenRover.rotateLeft()

        assertEquals(expectedRover, result)
    }

    @Test
    fun `should face east when turn left from south position`() {
        val givenRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(SOUTH))
        val expectedRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(EAST))

        val result = givenRover.rotateLeft()

        assertEquals(expectedRover, result)
    }

    @Test
    fun `should face south when turn left from west position`() {
        val givenRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(WEST))
        val expectedRover = Rover(Id("uuid"), Coordinate(0, 0), Orientation(SOUTH))

        val result = givenRover.rotateLeft()

        assertEquals(expectedRover, result)
    }

    //Back to start when move to the edge vertically
    @Test
    fun `should move to the other side of the map when rover is at the edge of the map and move forward`() {
        val givenRover = Rover(Id("uuid"), Coordinate(0, 5), Orientation(NORTH))
        val givenMap = RoverMap(Id("uuid"), 5, 5)
        val expectedRover = Rover(Id("uuid"), Coordinate(0, -5), Orientation(NORTH))

        val result = givenRover.moveForward(givenMap)

        assertEquals(expectedRover, result)
    }

    @Test
    fun `should move to the other side of the map when rover is at the edge of the map and move backward`() {
        val givenRover = Rover(Id("uuid"), Coordinate(0, -5), Orientation(NORTH))
        val givenMap = RoverMap(Id("uuid"), 5, 5)
        val expectedRover = Rover(Id("uuid"), Coordinate(0, 5), Orientation(NORTH))

        val result = givenRover.moveBackward(givenMap)

        assertEquals(expectedRover, result)
    }

    //Mars is a sphere when move to the edge horizontally
    @Test
    fun `should move to the other side of the map when rover is at the edge of the map at size x and move forward`() {
        val givenRover = Rover(Id("uuid"), Coordinate(5, 0), Orientation(EAST))
        val givenMap = RoverMap(Id("uuid"), 5, 5)
        val expectedRover = Rover(Id("uuid"), Coordinate(-5, 0), Orientation(EAST))

        val result = givenRover.moveForward(givenMap)

        assertEquals(expectedRover, result)
    }

    @Test
    fun `should move to the other side of the map when rover is at the edge of the map at size x and move backward`() {
        val givenRover = Rover(Id("uuid"), Coordinate(-5, 0), Orientation(EAST))
        val givenMap = RoverMap(Id("uuid"), 5, 5)
        val expectedRover = Rover(Id("uuid"), Coordinate(5, 0), Orientation(EAST))

        val result = givenRover.moveBackward(givenMap)

        assertEquals(expectedRover, result)
    }
}