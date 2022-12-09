package com.marsRover.domain

data class RoverMap(val id: Id, val horizontalSize: Int, val verticalSize: Int) {
    fun checkForwardMovement(
        movement: Coordinate,
        mapRover: RoverMap,
        coordinate: Coordinate
    ): Coordinate {
        return if (movement.y == mapRover.verticalSize + 1) {
            Coordinate(coordinate.x, (-mapRover.verticalSize))
        } else if (movement.y == -mapRover.verticalSize - 1) {
            Coordinate(coordinate.x, mapRover.verticalSize)
        } else if (movement.x == mapRover.horizontalSize + 1) {
            Coordinate((-mapRover.horizontalSize), coordinate.y)
        } else if (movement.x == -mapRover.horizontalSize - 1) {
            Coordinate(mapRover.horizontalSize, coordinate.y)
        } else movement
    }

    fun checkBackwardMovement(
        movement: Coordinate,
        mapRover: RoverMap,
        coordinate: Coordinate
    ): Coordinate {
        return if (movement.y == -mapRover.verticalSize - 1) {
            Coordinate(coordinate.x, mapRover.verticalSize)
        } else if (movement.y == mapRover.verticalSize + 1) {
            Coordinate(coordinate.x, (-mapRover.verticalSize))
        } else if (movement.x == -mapRover.horizontalSize - 1) {
            Coordinate(mapRover.horizontalSize, coordinate.y)
        } else if (movement.x == mapRover.horizontalSize + 1) {
            Coordinate((-mapRover.horizontalSize), coordinate.y)
        } else movement
    }
}