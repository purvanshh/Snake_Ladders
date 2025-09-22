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
