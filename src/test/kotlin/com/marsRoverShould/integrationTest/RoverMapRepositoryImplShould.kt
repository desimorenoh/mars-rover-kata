package com.marsRoverShould.integrationTest

import com.marsRover.domain.RoverMap
import com.marsRover.infrastructure.MapRoverRepositoryInMemoryImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RoverMapRepositoryImplShould {

    private val mapRoverRepositoryImpl: MapRoverRepositoryInMemoryImpl = MapRoverRepositoryInMemoryImpl()

    @Test
    fun `save and load a map`() {
        val map = RoverMap(5, 5)
        mapRoverRepositoryImpl.save(map)

        val loadedMap = mapRoverRepositoryImpl.load()

        assertEquals(map, loadedMap)
    }
}