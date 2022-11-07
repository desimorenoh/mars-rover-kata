# MY SOLUTION

## 🙋🏻‍♀️ Hello!

Let me present my `Rover Mars` solution.

I've converted the code to Kotlin, and I've used `gradle` because it's the build tool I'm most familiar with. I've made the `unit tests` for each use case to ensure that the code is working as expected. Then, I did a little code refactor to make it more readable and easy to understand for me.

I've added controller test and one controller to run the application end to end. Then I've added the functionality when the `Rover` disappears over the edge of the map, continue on the other side.

I've added **gradle configuration** to run **tests** and **build** the project.

Once I've really understood what `Rover` and `Mars` does, I've started to think about how to implement it using some **[Design Patterns](https://deviq.com/design-patterns/repository-pattern)**, **[DDD](https://es.wikipedia.org/wiki/Dise%C3%B1o_guiado_por_el_dominio)**, **[Hexagonal Architecture](https://es.wikipedia.org/wiki/Arquitectura_hexagonal_(software))** and **[SOLID](https://es.wikipedia.org/wiki/SOLID)** principles. I've created a Domain model with the `Rover` and `Map` as an entities; `coordinates` and `orientation` as a value objects; domain `exceptions` and domain `repositories interfaces`. Then, I've created the use cases for `Rover` and `Map` in the Application layer and implemented the `repositories interfaces` and `controller` in the Infrastructure layer.

Also, I've added the `Application` class to run the application end to end.


I've split the main `test` package:

- `unitTest` where I've put all the test corresponding to the use cases and rover entity (with all possible scenarios)
- `integrationTest` where I've put all the tests related to the repositories implementations
- `acceptanceTest` where I've put one application end-to-end test

To resume, I've applied the following:

- _TDD_
- _DDD_
- _Hexagonal Architecture_
- _SOLID principles_
- _Gradle_
- _Kotlin_
- _JUnit_
- _Mockito_

In order to run the application, you can use the following command:

    ./gradlew run

To run the tests:

    ./gradlew test

# I hope you like it! 😃