# ARCADE

Will have several fun games that supports several different currencies and credits.
Current Priorities:
BlackJack

## Purpose

The initial purpose of this class is to rebuild the BlackJack game using good OOP practices and SOLID principles.
The classes will be extensible to several other Casino/Arcade games.

## Update

All 5 buttons on ShoeTest working!
Have implemented the Cheat and HonorCode interface.
  The Cheat is the parent of several interfaces that will allow access to private members.
  The HonorCode has a single boolean function that determines if the Arcade item is rogue or potentially rogue.
Focused on 2D Graphics for reusability in future Java Projects.

## Next Master Push Goals
- [x] Test BlackJackShoe with the debug temporary class ShoeTest
     - [x] BlackJackShoe now has an innerClass that extendes itself as an evil twin to allow this to be implemented.
- [ ] Test GUI with Buttons Draw Card, Discard Card, Shuffle, Reset.
  - [x] Build initial animation library
  - [ ] Build 2D Animation generator of BlackJackCard (Front and Back) (Card2DAnimationFactory.java)
  - [x] Build the ImageDrawing Class (CardImgFetcher.java)
    - [x] Extract hard images from source folder
    - [x] Draw/Generate new images (vector graphics) (needs some refactoring but successful)
- [x] Figure out a way to create DEBUG inheritance for Junit testing.
- [x] Create Issues within github for this list.

## High level structure.

The "arcade" package will be treated as a library (will be reusable in different projects).
The "animation" package will be treated as a library (will be reusable in different projects).
The "app" package will utilize the arcade and animation libraries as necessary.
