package com.marsRoverShould.integrationTest

import com.marsRover.domain.Id
import com.marsRover.domain.RoverMap
import com.marsRover.infrastructure.MapRoverRepositoryInMemoryImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RoverMapRepositoryImplShould {

    private val mapRoverRepositoryImpl: MapRoverRepositoryInMemoryImpl = MapRoverRepositoryInMemoryImpl()

    @Test
    fun `save and load a map`() {
        val map = RoverMap(Id("uuid"), 5, 5)
        mapRoverRepositoryImpl.save(map)

        val loadedMap = mapRoverRepositoryImpl.load(Id("uuid"))

        assertEquals(map, loadedMap)
    }
}