# ARCADE

Will have several fun games that supports several different currencies and credits.
Current Priorities:
BlackJack

## Purpose

The initial purpose of this class is to rebuild the BlackJack game using good OOP practices and SOLID principles.
The classes will be extensible to several other Casino/Arcade games.

## Update

Animation is relatively independant and extensible for mutually exclusive development.
The srcFactory classes are relatively tightly coupled. (Violate Diversion Independancy Principle)
This should be OK because this is not a graphically intensive program but need enough to show a visual aid.
Looking to provide some default hardcoded extensions for basic default templates.

Looking to create 2D classes or an interface that contains 2D animation located in the class folder
Animation works but now need to attach animations to all game items with no library dependancies. (After this set of Master Push Goals are complete.)

## Next Master Push Goals
- [ ] Implement interface for back button on the Panel Swap class. (will require careful planning, looking to avoid global references.)
- [x] Test GUI with Buttons Draw Card, Discard Card, Shuffle, Reset.
  - [x] Build initial animation library
  - [ ] Clean up some useless functions. Some functions have unused parameters.
  - [ ] Build 2D Animation generator of BlackJackCard (Front and Back) (Card2DAnimationFactory.java)

- [x] Looking to remove the AnimationTest class and allow the ShoeTest to cycle through cards
- [ ] ShoeTest should not crash after drawing all cards out of Deck.

## High level structure.

The "arcade" package will be treated as a library (will be reusable in different projects).
The "animation" package will be treated as a library (will be reusable in different projects).
The "app" package will utilize the arcade and animation libraries as necessary.
