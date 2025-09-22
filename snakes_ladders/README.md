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

```mermaid
classDiagram
	%% Classes and interfaces
	class Tile {
		-int index
		+Tile(int index)
		+int getIndex()
		+boolean isSpecial()
	}

	class SpecialTile {
		-int endIndex
		+SpecialTile(int index, int endIndex)
		+int getEndIndex()
		+boolean isSpecial()
	}

	class NormalTile {
		+NormalTile(int index)
	}

	class Snake {
		+Snake(int headIndex, int tailIndex)
		+String toString()
	}

	class Ladder {
		+Ladder(int bottomIndex, int topIndex)
		+String toString()
	}

	class Board {
		-List tiles
		-int size
		+Board(int size)
		-void setupBoard()
		-void addSpecial(SpecialTile st)
		+Tile getTile(int index)
		+int getSize()
	}

	class Player {
		-String name
		-int position
		-boolean skipNextTurn
		+Player(String name)
		+String getName()
		+int getPosition()
		+void setPosition(int position)
		+void move(int steps)
		+boolean isSkipNextTurn()
		+void setSkipNextTurn(boolean skipNextTurn)
		+String toString()
	}

	class IRollable <<interface>> {
		+int roll()
	}

	class Dice {
		-int sides
		-Random random
		+Dice(int sides)
		+Dice()
		+int roll()
		+int getSides()
	}

	class IRuleEngine <<interface>> {
		+void applyRules(Player player, Board board)
	}

	class DefaultRuleEngine {
		+void applyRules(Player player, Board board)
	}

	class Game {
		-List players
		-Board board
		-IRollable roller
		-IRuleEngine ruleEngine
		-int currentPlayerIndex
		-Player winner
		+Game(List, Board, IRollable, IRuleEngine)
		+void start()
		+void playTurn(Player p)
		+boolean hasWinner()
	}

	class Main {
		+static void main(String[] args)
	}

	%% Inheritance / implementation
	Tile <|-- SpecialTile
	Tile <|-- NormalTile
	SpecialTile <|-- Snake
	SpecialTile <|-- Ladder
	IRuleEngine <|.. DefaultRuleEngine
	IRollable <|.. Dice

	%% Associations
	Board "1" *-- "*" Tile : tiles
	Game "1" o-- "*" Player : players
	Game "1" o-- "1" Board : board
	Game "1" o-- "1" IRollable : roller
	Game "1" o-- "1" IRuleEngine : ruleEngine
	DefaultRuleEngine --> Player : applyRules(player, board)
	DefaultRuleEngine --> Board : applyRules(player, board)

```

Notes and assumptions:
- The diagram lists visible fields and public methods present in the source.
- Constructors and toString methods are included for clarity.
- The `Board.tiles` collection is shown as a composition to Tile instances (1..*).
- PlantUML rendering requires a PlantUML renderer or the web editor at https://plantuml.com/.

