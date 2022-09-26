# ARCADE
Will have several fun games that supports several different currencies and credits.
Current Priorities:
BlackJack

## Purpose
The initial purpose of this class is to rebuild the BlackJack game using good OOP practices and SOLID principles.
The classes will be extensible to several other Casino/Arcade games.

Most games will have an Expected Value (EV) calculator that can generate how much currency you will win or lose over time.
Some systems will be much harder to implement than others.

As the focus is BlackJack for now, the program will simulate millions of hands and generate Basic Strategy tables using various counting system techniques.

## Update
Developing BlackJackSeat functions IOT allow Table to interact completely.

Beginning to think BlackJackTables should have a BuilderClass becuase there is a lot of different possiblilities for ShoeSize, Card Types, Currencies that can be generated.

The BuilderClass for BlackJackTables can have some hardcoded defaults that will fill all the parameters of a BlackJackTable.
Right now, the table is not big enough but will not be able to satisfy all conditions without several parameters.

### Single Responsibility Principle Violation
BlackJackTable interface has 2 responsibilities:
* Transfer cards to and from Shoe, Table and Players,
* Transfers currencies to and from Table and Players

Should there be a "money transfer" class that takes on the currency transfer? Yes.

## Next Master Push Goals
- [ ] Improve structure diagram. Elaborate more on 2D implementation.
- [ ] Verify Shoe interface has everything needed to implement Table simplicity.
- [ ] Develop Table Interface and Default Table implementation.
	- [x] Table instance.
	- [ ] Seat instance. (Currently calculating hand counts and values.)

	NOTE: Will not be working on currency transactions right now. Filler code is inserted at the moment.

	NOTE: Will not place Player instances in BlackJackSeat yet.

- [x] Packages "game" and "game_items" are in the same directory.

## High level structure.
![Generic Game Structure](readmesrcs/GameSetup.jpg)
The "arcade" package will be treated as a library (will be reusable in different projects).
The "animation" package will be treated as a library (will be reusable in different projects).
The "app" package will utilize the arcade and animation libraries as necessary.
The "debug" package will be destoryed in the future so good practices will not be focused. This will only exist until Test Case library OR separate implementation exists.