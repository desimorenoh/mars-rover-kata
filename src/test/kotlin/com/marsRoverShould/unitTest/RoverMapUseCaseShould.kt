package com.marsRoverShould.unitTest

import com.marsRover.application.RoverMapUseCase
import com.marsRover.domain.Id
import com.marsRover.domain.RoverMap
import com.marsRover.domain.RoverMapRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RoverMapUseCaseShould {

    @Mock
    private lateinit var roverMapRepository: RoverMapRepository

    @InjectMocks
    private lateinit var roverMapUsecase: RoverMapUseCase

    @Test
    fun `save map`() {
        roverMapUsecase.saveMap("uuid",5,5)

        Mockito.verify(roverMapRepository).save(RoverMap(Id("uuid"), 5, 5))
    }
}