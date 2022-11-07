package com.marsRover.domain

interface RoverRepository {
  fun save(rover: Rover)
  fun load(id: Id): Rover?
}