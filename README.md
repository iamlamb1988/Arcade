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

DESIGN DECISION DILEMMA:
If we create a class BlackJackCard2D extends BlackJackCard then we have tightly coupled DIP violation. (Possible Animator interface?)
Right now, BlackJackShoe is a class (Should it be an interface.?)
IF BlackJackShoe becomes an interface, should default class implementations exist in an "instances" package?

Want to plan for 3D implementation (Not necessarily for blackjack but for ski-ball, roulette wheel, etc).
INDEPENDANCY is crucial.

## Next Master Push Goals
- [ ] Implement interface for back button on the Panel Swap class. (will require careful planning, looking to avoid global references.)
  - [ ] Clean up some useless functions. Some functions have unused parameters.
  - [ ] Build 2D Animation generator of BlackJackCard (Front and Back) (Card2DAnimationFactory.java)

- [ ] ShoeTest should not crash after drawing all cards out of Deck.

## High level structure.

The "arcade" package will be treated as a library (will be reusable in different projects).
The "animation" package will be treated as a library (will be reusable in different projects).
The "app" package will utilize the arcade and animation libraries as necessary.