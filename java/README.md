# Yatzy kata refactoring
This refactoring is about the logic that score a GIVEN roll in a GIVEN category. 
It does not implement the whole game with the actions of random rolling and placing a score into a category.

## Yatzy description

The game of Yatzy is a simple **dice** game. Each player **rolls** five **six-sided** dice. 
They can **re-roll** some or all of the dice up to three times (including the original roll).

The player then **places** the roll in a category, such as **ones**, **twos**, **fives**, **pair**, **two pairs** etc (see the rules below). If the roll is compatible with the category, the player gets a score for the roll according to the rules. If the roll is not compatible with the category, the player scores zero for the roll.

For example, suppose a player **scores** 5,6,5,5,2 in the fives category they would score 15 (three fives). 
The score for that go is then added to their total and the category cannot be used again in the remaining goes for that game. 
A full game consists of one go for each category. Thus, for their last go in a game, a **player** must choose their only remaining category.

## Ubiquitous language
Side: side of a dice, a side has a number representing the value of the side
Roll: read Sides of a roll, a roll can read 0 to x sides.
Score: score returned for a given category.

## Class diagram after refactoring
```mermaid
classDiagram
    class Yatzy {
        chance(Roll roll) Score
        yatzy(Roll roll) Score
        ones(Roll roll) Score
        twos(Roll roll) Score
        threes(Roll roll) Score
        fours(Roll roll) Score
        fives(Roll roll) Score
        sixes(Roll roll) Score
        pair(Roll roll) Score
        twoPair(Roll roll) Score
        threeOfKing(Roll roll) Score
        fourOfKing(Roll roll) Score
        smallStraight(Roll roll) Score
        largeStraight(Roll roll) Score
        fullHouse(Roll roll) Score
    }

    class Roll {

        +read() Side[]
        +counterSideTuples() CounterSideTuple[]
        +countBySide(Side side) Side[]
        +areAllSideEqual() boolean
        +atLeastNTime(int n) Side[]
    }
    class Side {
        +int number
        +score() Score
    }
    class Score {
        -value: int
        +sum(Score) Score
        +multiply(int) Score
    }
    
    class ScoringStrategy {
        +score(Roll roll) Score
    }
    <<Interface>> ScoringStrategy
    class ScoringStrategyFactory {
        +create(Category category) ScoringStrategy
    }
    <<Interface>> ScoringStrategyFactory

    class ScoringStrategyFactoryImpl {
    }
    class ChanceScoringStrategy {
    }
    class OtherConcreteScoringStrategy {
    }


    Yatzy ..>  Roll :"use"
    Yatzy ..>  Score : "use"
    ScoringStrategy ..> Score : "create"
    ScoringStrategyFactoryImpl ..> ScoringStrategy
    ScoringStrategyFactoryImpl ..> "Instantiate" ChanceScoringStrategy
    ScoringStrategyFactoryImpl ..> "Instantiate" OtherConcreteScoringStrategy

    Yatzy o-- ScoringStrategyFactory
    ScoringStrategyFactoryImpl --|> ScoringStrategyFactory
    ChanceScoringStrategy --|> ScoringStrategy
    OtherConcreteScoringStrategy --|> ScoringStrategy
    Roll *-- "*" Side : "sides"
    Side *-- "1" Score: "score"


```
