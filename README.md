# ARCADE

Will have several fun games that supports several different currencies and credits.

## Current Priorities:
* Images
* Animation
* BlackJack Game

## Purpose

The initial purpose of this class is to rebuild the BlackJack game using good OOP practices and SOLID principles.
The classes will be extensible to several other Casino/Arcade games.

## Update

All 5 buttons on ShoeTest working!
Have implemented the Cheat and HonorCode interface.
  The Cheat is the parent of several interfaces that will allow access to private members.
  The HonorCode has a single boolean function that determines if the Arcade item is rogue or potentially rogue.

## Next Master Push Goals
- [ ] Test GUI with Buttons Draw Card, Discard Card, Shuffle, Reset.
  - [ ] Draw/Generate new images (vector graphics)
    - [ ] Build 2D image of BlackJackCard (Front and Back).
    - [ ] Build the ImgFetcher Class in order pull images from resources.
    - [ ] Build the AnimationFactory Class in order to draw the 2D Cards

## High level structure

The "arcade" package will be treated as a library (will be reusable in different projects).
The "animation" package will be treated as a library (will be reusable in different projects).
The "app" package will utilize the arcade and animation libraries as necessary.
