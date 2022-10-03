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
ISSUE:
JFrame size and inner content do not match. The JFrame inner size is slightly smaller than the actual attached panels and over laps.
The Height seems to overlap by approximately 40 pixels.

Converted IMenu from an interface to an abstract class in order to reduce duplicate code.

Should there be a "money transfer" class that takes on the currency transfer? Yes.

resources and animation package is tightly coupled but shouldn't be. animation package must be completely separate from the app resources. Card2DAnimation should be in the app class because the images are app specific.

### Single Responsibility Principle Violation
1. BlackJackTable interface has 2 responsibilities:
* Transfer cards to and from Shoe, Table and Players,
* Transfers currencies to and from Table and Players

## Next Master Push Goals
- [x] Design and Implement GameMenu. This will house the GameField(s) and GamePanel(s).
- [ ] Plan unit test case structure. The goal is to be able to continually run this on each separate class.
- [ ] Improve structure diagram. Elaborate more on 2D implementation.

## High level structure.
![Generic Game Structure](readmesrcs/GameSetup.jpg)
The "arcade" package will be treated as a library (will be reusable in different projects).
The "animation" package will be treated as a library (will be reusable in different projects).
The "app" package will utilize the arcade and animation libraries as necessary.
The "debug" package will be destoryed in the future so good practices will not be focused. This will only exist until Test Case library OR separate implementation exists.