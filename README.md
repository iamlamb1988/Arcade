# ARCADE

Will have several fun games that supports several different currencies and credits.
Current Priorities:
BlackJack

## Purpose

The initial purpose of this class is to rebuild the BlackJack game using good OOP practices and SOLID principles.
The classes will be extensible to several other Casino/Arcade games.

## Update

This master push demonstrates that test works primitively.

The Cards are not yet attached to the image.
The plan is to allow extensible image (Front and Back) to a BlackJackCard and/or BlackJackShoe.
The test shoed is only drawing according to the Card Drawn and the CardAnimator is not attached as a member to a card.

The "arcade" package will have interfaces for it's sub components. Any classes that implement will be in an "instances" folder. The filename of these instances will end in "_Default" and will end in "DefaultX" where X is an integer if there is more than 1.

The purpose of this is to allow simple classes in "app" to tightly couple by extending OR implementing the interfaces of the given objects to utilize DIP principle.

## Next Master Push Goals

- [ ] Implement interface for back button on the Panel Swap class. (will require careful planning, looking to avoid global references.)
  - [ ] Clean up some useless functions. Some functions have unused parameters.
  - [ ] Build 2D Animation generator of BlackJackCard (Front and Back) (Card2DAnimationFactory.java)

- [ ] ShoeTest should not crash after drawing all cards out of Deck.

## High level structure.

The "arcade" package will be treated as a library (will be reusable in different projects).
The "animation" package will be treated as a library (will be reusable in different projects).
The "app" package will utilize the arcade and animation libraries as necessary.