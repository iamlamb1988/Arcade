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
Setting up Eclipse GlassFish7 server with OpenJDK 11 and Maven setup. In progress.
Learning to deploy webapps that will execute the arcade library.
Less commits have been made due to learning curve of Jakarta EE.
Digital Ocean: 198.199.71.169

BlackJackShoe is now refactored for Generic BlackJackCard types.
Successfully modified Card2D to bo "face up" or "face down". The generic Drawable2D will draw IAW with face up or face down.

ShoeCycle brings up a concern of adding and removing IAppItems and GameItems. Need to modify some add and remove commands to handle IAppItem components and Non-IAppItem components safely. Right now there is not an easy way to add and remove these items.

Should there be a "money transfer" class that takes on the currency transfer? Yes.

resources and animation package is tightly coupled but shouldn't be. animation package must be completely separate from the app resources. Card2DAnimation should be in the app class because the images are app specific.

IMenu add override handles objects that ARE components that implement IAppItem.
We need a function (GameItem) that handles IAppItems that are NOT Components.
### Single Responsibility Principle Violation
1. BlackJackTable interface has 2 responsibilities:
* Transfer cards to and from Shoe, Table and Players,
* Transfers currencies to and from Table and Players

## Next Master Push Goals
- [x] Develop the ShoeCycle.
	NOTE: Not the most polished production. Enough to move forward and begin the TableCycle implementation.
- [ ] Develop the TableCycle (Except money transactions).
- [x] Destroy the debug package.
	- [x] Destroy the ShoeTest
	- [x] Destroy the TableTest
- [ ] Improve structure diagram. Elaborate more on 2D implementation.

## High level structure.
![Generic Game Structure](readmesrcs/GameSetup.jpg)
The "arcade" package will be treated as a library (will be reusable in different projects).
The "animation" package will be treated as a library (will be reusable in different projects).
The "app" package will utilize the arcade and animation libraries as necessary.
The "debug" package will be destoryed in the future so good practices will not be focused. This will only exist until Test Case library OR separate implementation exists.
