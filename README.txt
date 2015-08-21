Game made by Michael Zavarella
Learning a lot more Java

So for the sprite animation were going to have to have more animated states. Im
going to make somewhere between 5 and 10 animation states depending on how much
work I feel like putting into the sprite or if I can find a sprite sheet online
that I can use for this. I would like to make my own but I'm a programmer not an
artist. More skills can't hurt though.

But as far as the animation im going to have to some serious math to figure this
shit out... JK I love modular arithmatic

So we have an animation counter that goes from 0 to N, where N is one of two things.

Case 1 - I mirror the animated up state and use that for the down.

Case 2 - I make a full range of moion animation.

For case 1, N would have to be double the number of animated states minus one to
prevent the top state from occurring twice.

For case 2, it is trivial and honestly much more appealing than case 1 as far as
graphics go but much more work depending on whether I make my own sprites or get
them online.