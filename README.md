# Mars Rover

Hello!!

Welcome to Mars Rover kata!

## Mars Rover refactoring kata

We need to improve the existing solution that translates commands sent from Earth to instructions that are understood by our Rover on Mars

Currently, the code is very complicated and tangled, so we'd like you to invest some time to clean it up

### Functional requirements
```
Given:
 - a two dimensional map of Mars
 - the initial starting point and direction of the Rover
 
When:
 - a command is received
   move `forward` or `backward` or rotate `left` or `right` (90 degrees)

Then:
 - move the Rover
   if the Rover disappears over the edge of the map (the horizon), continue on the other side (remember, Mars is a sphere)
```

#### Bonus point

After ensuring that the functional requirements have been met, as a bonus point (not necessary but more than welcome), add a new feature:
```
Given:
 - a list of obstacles with their exact location
 
When:
 - Rover moves

And:
 - Rover encounters an obstacle

Then:
 - report back the obstacle. The Rover should stay in its previous position
```

## Your solution

### Must have

- Fulfill the [Functional Requirements](#functional-requirements) stated in this readme.
- Refactor the provided code, creating new classes, methods or whatever needed.
- Be testable. This means that we should not need to run the main app in order to check that everything is working.
- Be self compiled.
- Be self executable.
- Have a SOLUTION.md containing all the relevant features of your provided solution.

### Should (Nice to have)

- Fulfill the [Bonus point](#bonus-point) section of this readme.
- Be bug free.
- Use any design patterns you know and feel that help solve this problem.
- Be extensible to allow the introduction of new features in an easy way.
- Use any package dependency mechanism.

