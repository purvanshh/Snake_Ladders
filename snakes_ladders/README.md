Snakes and Ladders - Java

Simple console implementation of Snakes and Ladders.

Structure:
- src/main/java/com/snakesladders - Java sources

How to build/run (from project root `snakes_ladders`):

Compile:

javac -d out $(find . -name "*.java")

Run:

java -cp out com.snakesladders.Main

Notes:
- Uses a default board with some preset snakes/ladders.
- Overshoot rule: if a roll would move past the last tile, the player stays in place.

UML Class Diagram (PlantUML)

Below is a PlantUML diagram that mirrors the Java source in `src/main/java/com/snakesladders`.
You can render it with PlantUML (paste into https://plantuml.com/ or use a local PlantUML tool).

```plantuml
@startuml
' Classes / Interfaces
abstract class Tile {
	-index: int
	+Tile(index: int)
	+getIndex(): int
	+isSpecial(): boolean
}

abstract class SpecialTile {
	-endIndex: int
	+SpecialTile(index: int, endIndex: int)
	+getEndIndex(): int
	+isSpecial(): boolean
}

class NormalTile {
	+NormalTile(index: int)
}

class Snake {
	+Snake(headIndex: int, tailIndex: int)
	+toString(): String
}

class Ladder {
	+Ladder(bottomIndex: int, topIndex: int)
	+toString(): String
}

class Board {
	-tiles: List<Tile>
	-size: int
	+Board(size: int)
	-setupBoard()
	-addSpecial(st: SpecialTile)
	+getTile(index: int): Tile
	+getSize(): int
}

class Player {
	-name: String
	-position: int
	-skipNextTurn: boolean
	+Player(name: String)
	+getName(): String
	+getPosition(): int
	+setPosition(position: int)
	+move(steps: int)
	+isSkipNextTurn(): boolean
	+setSkipNextTurn(skipNextTurn: boolean)
	+toString(): String
}

interface IRollable {
	+roll(): int
}

class Dice {
	-sides: int
	-random: Random
	+Dice(sides: int)
	+Dice()
	+roll(): int
	+getSides(): int
}

interface IRuleEngine {
	+applyRules(player: Player, board: Board)
}

class DefaultRuleEngine {
	+applyRules(player: Player, board: Board)
}

class Game {
	-players: List<Player>
	-board: Board
	-roller: IRollable
	-ruleEngine: IRuleEngine
	-currentPlayerIndex: int
	-winner: Player
	+Game(players: List<Player>, board: Board, roller: IRollable, ruleEngine: IRuleEngine)
	+start()
	+playTurn(p: Player)
	+hasWinner(): boolean
}

class Main {
	+main(args: String[])
}

' Inheritance / Implementation
Tile <|-- SpecialTile
Tile <|-- NormalTile
SpecialTile <|-- Snake
SpecialTile <|-- Ladder
IRuleEngine <|.. DefaultRuleEngine
IRollable <|.. Dice

' Associations
Board "1" *-- "*" Tile : tiles
Game "1" o-- "*" Player : players
Game "1" o-- "1" Board : board
Game "1" o-- "1" IRollable : roller
Game "1" o-- "1" IRuleEngine : ruleEngine
DefaultRuleEngine ..> Player : applyRules(player, board)
DefaultRuleEngine ..> Board : applyRules(player, board)

@enduml
```

Notes and assumptions:
- The diagram lists visible fields and public methods present in the source.
- Constructors and toString methods are included for clarity.
- The `Board.tiles` collection is shown as a composition to Tile instances (1..*).
- PlantUML rendering requires a PlantUML renderer or the web editor at https://plantuml.com/.

