# ARCADE

Will have several fun games that supports several different currencies and credits.
Current Priorities:
BlackJack

## Purpose

The initial purpose of this class is to rebuild the BlackJack game using good OOP practices and SOLID principles.
The classes will be extensible to several other Casino/Arcade games.

## Update

The Application successfully transfers from MainMenu to ShoeTest instances.
Unfortunately needed to reference the Singleton Class global App in each class..

## Next Master Push Goals
- [ ] Test GUI with Buttons Draw Card, Discard Card, Shuffle, Reset.
  - [ ] Build animation library
  - [ ] Build 2D image of BlackJackCard (Front and Back)
  - [ ] Build the ImageDrawing Class (Undecided Name)
    NOTE: The Image Drawing class will have a few responsibilities:
  - [ ] Extract hard images from source folder
  - [ ] Draw/Generate new images (vector graphics)

## History

BlackJack was successfully developed in the past in JavaFX GUI. The previous implementation severely violated Dependency Inversion Principle.
Will use SOLID principles to develop the entire system.

## Versions
Will be using Java 17 LTS. Swing library will be used. Original implementation I used was javaFX.
JavaFX is no longer a default installation with Java 17, do not feel like downloading JavaFX separately therefore Java Swing will be used.

## High level structure.

The "arcade" package will be treated as a library (will be reusable in different projects).
The "animation" package will be treated as a library (will be reusable in different projects).
The "app" library will utilize the arcade and animation libraries as necessary.
The app will also tightly couple objects as necessary for improved performance.

INTENTIONAL DIP VIOLATION
Card will remain a class. Shoe will now be an interface that references a class.
Considering tightly coupling JPanel Menus with the JFrame Application.
