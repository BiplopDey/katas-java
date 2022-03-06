# Katas

This repository has diferents types of Katas to practice the Domain logic using TDD.

### Objective of these katas :movie_camera:
The objective of these Katas is using TDD practice OOP (Abstraction, Encapsulation, Inheritance, Polymorphism and Interfaces), class relations,  Java Api(Junit 5, Mockito, Lambda) and SOLID.

## Shopping Kata :shopping_cart:
### Functional requirements :gear:
1. All products have **name** and **price**
2. A discount can be added to food products (`FoodProduct`):
     - The price of a product without discount is the original price of the product
     - The price of a discounted product is the original price with the assigned % discount
3. The shopping cart contains a number of products (it can be zero). The total cost of the cart is the sum of the prices of the products applying the discounts.
4. `Book` type products have an author and a description (in addition to name and price) and a discount can be added, but not more than 10%.

## Snakes and Ladders :snake: :ladder:
Snakes and Ladders is an ancient Indian board game regarded today as a worldwide classic. It is played between two or more players on a gameboard having numbered, gridded squares. A number of "ladders" and "snakes" are pictured on the board, each connecting two specific board squares.
### Functional requirements :gear:
1. There are two players and both start off the board on square 1.
2. Player 1 starts and alternates with player 2.
3. You follow the numbers up the board in order 1=>100.
4. If the value of both die are the same then that player will have another go.
5. Climb up ladders. The ladders on the game board allow you to move upwards and get ahead faster. If you land exactly on a square that shows an image of the bottom of a ladder, then you may move the player all the way up to the square at the top of the ladder. (even if you roll a double).
6. Slide down snakes. Snakes move you back on the board because you have to slide down them. If you land exactly at the top of a snake, slide move the player all the way to the square at the bottom of the snake or chute. (even if you roll a double).
7. Land exactly on the last square to win. The first person to reach the highest square on the board wins. But there's a twist! If you roll too high, your player "bounces" off the last square and moves back. You can only win by rolling the exact number needed to land on the last square. For example, if you are on square 98 and roll a five, move your game piece to 100 (two moves), then "bounce" back to 99, 98, 97 (three, four then five moves.)
8. If the Player rolled a double and lands on the finish square “100” without any remaining moves then the Player wins the game and does not have to roll again.
9. Game message:
    - Return `"Player n Wins!."` Where n is winning player that has landed on square 100 without any remainding moves left.
    - Return `"Game over!"` if a player has won and another player tries to play.
    - Otherwise return `"Player n is on square x."` Where n is the current player and x is the sqaure they are currently on.
10. It can work with any board (snakes and ladders position) and with any number of players.

## Die Bremer Stadtmusikanten Kata :musical_note:
The Bremen Town Musicians are a choir of little animals that meet to sing together:
### Functional requirements :gear:
1. Sprint 01
  - Cats and cats (Cat) should be started with a name and a sound with which they usually sing.
  - At first cats do not sing.
  - We can tell any Cat to start singing and also to stop singing.
  - Cat will tell us when he sings with a function returning “The cat {name} is singing {sound}” and when he doesn't sing he will tell us “the cat {name} doesn't want to sing”.
2. Sprint 02
  - The donkey and all the animals can do the same as the cat but its messages are “The donkey {name} is singing {sound} ” and when it does not sing it will tell us: “the donkey {name} does not want to sing”.
3. Sprint 03
- To direct the choir we have a director (`Director`) who has the ability to make several animals sing at the same time. We will instantiate this director with a list of animals and it must have the capacity of: (startSing() and stopSing()) functions in which the animals must start and stop singing regardless of their type or the number of participants in The chorus.
4. Sprint 04
- Suddenly we see comic characters (`ComicCharacter`) who also sing and want to join the choir. How can we make it so that the director can also integrate them into the animal choir?
