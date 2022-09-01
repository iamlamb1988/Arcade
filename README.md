# ARCADE

Will have several fun games that supports several different currencies and credits.
Current Priorities:
BlackJack

## Purpose

The initial purpose of this class is to rebuild the BlackJack game using good OOP practices and SOLID principles.
The classes will be extensible to several other Casino/Arcade games.

## Update

The Application successfully transfers from MainMenu to ShoeTest instances.
The ShoeTest is able to shuffle cards and draw 1 card. Will crash upon full depleting Shoe.

## Next Master Push Goals
- [ ] Test BlackJackShoe with the debug temporary class ShoeTest
- [ ] Test GUI with Buttons Draw Card, Discard Card, Shuffle, Reset.
  - [ ] Build animation library
  - [ ] Build 2D image of BlackJackCard (Front and Back)
  - [ ] Build the ImageDrawing Class (Undecided Name)
    NOTE: The Image Drawing class will have a few responsibilities:
    - [ ] Extract hard images from source folder
    - [ ] Draw/Generate new images (vector graphics)
- [ ] Figure out a way to create DEBUG inheritance for Junit testing.
- [ ] Create Issues within github for this list.

## Versions
Will be using Java 17 LTS. Swing library will be used. Original implementation I used was javaFX.
JavaFX is no longer a default installation with Java 17, do not feel like downloading JavaFX separately therefore Java Swing will be used.

## High level structure.

The "arcade" package will be treated as a library (will be reusable in different projects).
The "animation" package will be treated as a library (will be reusable in different projects).
The "app" library will utilize the arcade and animation libraries as necessary.
The app will also tightly couple objects as necessary for improved performance.