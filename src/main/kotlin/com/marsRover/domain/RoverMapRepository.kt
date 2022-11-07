package com.marsRover.domain

interface RoverMapRepository {
    fun save(map: RoverMap)
    fun load(): RoverMap
}