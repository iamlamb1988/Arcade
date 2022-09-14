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

Card2D and BlackJackShoe2D are successfully implemented using DIP principles.
The generic Card Object is still the only generic that is a class while others are interfaces. (May be a DIP violation later but have no intentions of ever changing the basic definition.)

Cards still cycle through as before and drawing the image attached in the field.

The resource and srcfactory classes need some work but successfully do the job.
Looking to add some hardened simple values that extend Card2DAnimationFactory to keep this design simple.

Future plan is to overhaul the readme with development diagrams to paint the clear structural development design.

## Next Master Push Goals

- [ ] Implement interface for back button on the Panel Swap class. (will require careful planning, looking to avoid global references.)
  - [ ] Clean up some useless functions. Some functions have unused parameters.
  - [x] Build 2D Animation generator of BlackJackCard (Front and Back) (Card2DAnimationFactory.java)

- [x] ShoeTest should not crash after drawing all cards out of Deck.

## High level structure.

The "arcade" package will be treated as a library (will be reusable in different projects).
The "animation" package will be treated as a library (will be reusable in different projects).
The "app" package will utilize the arcade and animation libraries as necessary.
