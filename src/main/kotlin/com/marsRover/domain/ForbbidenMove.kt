package com.marsRover.domain

import java.lang.RuntimeException

class ForbiddenMove(override val message: String) : RuntimeException(message)