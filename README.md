hello dear source-diver! welcome to the Hextended Staves repository. stuff is different here after the rewrite, so enjoy this new and different readme. 
#
Hextended Staves is an addon mod for Hex Casting that primarily adds new tools for casters to play with. it was my gateway to modding, thanks to the templates and guides created by Object-object and others in the Hex Casting community. as such, it's been a learning experience through and through, so do pardon my dust! nowadays, with a little more experience under my belt, I've rewritten it from the ground up to be a little easier to work with.

features include the staves themselves, both aesthetic and mechanical. second to these are some other gear that try to add more variety to the average caster's loadout. the goal is to make the stuff each caster carries with them a little more personalized and unique, instead of providing mechanical advantages or changing balance.
#
before the rewrite, I had this tentative text file for ideas about what to implement, stowed away in the common folder. if you're looking for that plans doc, here it is... 
```
-------- Staves!! the mainstay. --------
    Extended(?) - DONE
        Normal staff but lorj, offers slightly more grid space (configurable)
        maybe I should change the lang for hex's staves to "wands" instead of calling it extended
	Notes:
	""like the long staves would come with 1 level of a grid expanding enchant for free, but
	you could still go out and apply the enchant manually if you wanted to use one of the
	small staves and get the same functionality"" -Chloe

	Original Staves - DONE
		- spoon staff but the extended version is comically large
			- "this staff's name is 'Spoon Theory' look him up on google"
		- also moss staff. need. flowering azalea variants. maybe an glow berrie?
		- prismarine staves for matching to aquatic players, dark variant
		- copper staves?
		- nether-related staves (not quartz, sam covered that), netherrack?
		- end staves > purpur, obsidian?

    Impermanent Staff / Improviser's Staff - DONE
        staff made from amethyst, for people who didn't bring wood into the geode
        - has a media buffer (like a phial, implements MediaHolderItem)
        - breaks like a cypher (cannot be recharged)

    Drawing Orb - DONE
        staff with less grid space
        - you can set it to scry/ponder a position
        - extends ambit to a single entity(?) or block
        - ambit is only granted when the orb is held (in either hand)

    Crossmod Staves
        mostly cosmetic, for aesthetic matching
        - Botania
            - manasteel, terrasteel, elementium,
            - livingrock, livingwood and dreamwood
		- Gloop's staves
		- Spectrum
		    - azurite (suggested by pantheon)
		- Bewitchment (suggested by The Old Serpent)
		- Haema (suggested by The Old Serpent)
		- Spell Engine Suite (suggested by The Old Serpent)
	
		# Forge mods:
		- Ars Nouveau? (no, added by Ars Scalaes)
		- Ice and Fire
			- dragonscale,
		- Hexerei (suggested by gchpaco)
		- The Graveyard (suggested by The Old Serpent)

    Combat Staves!
        staves with small attack damage bonuses, made from specific materials
        iron combat staff, caster's glamour to change skins
        - "caster's caestus", amethyst mace, tonfa-like, baton,
        - dancer sword w/ shards as blades, amethyst mjolnir

    Grand/Great(?) Staves
		casts a hex for each pattern drawn?
			--or--
        implements ItemPackagedHex (is a casting device) BUT:
        - does not have a media buffer of its own
        - has a chargeup time to cast its bound hex(?), as well as the usual cooldown
        - needs a music disc (or similar expensive item) to craft along with
        - cannot be cast from while in the grid
        takes the form of being etched into the wood, a trusty hex the wielder knows by heart

-------- Bookbinding! Customized Spellbooks --------
    Custom Spellbooks that have varying page counts, but with other effects
		- crafted from a base item (empty cover), needs chorus fruit
		- shapeless recipe like a firework to add features
			- focus for 8 pages, (or ancient scroll)
			- large/medium/small scrolls for <8
				- (4,2,1?) for granularity
			- hexbook for hexbook on rmb
			- book and quill for gui on rmb
				- maybe make this its own page
				so it has compat with scribes etc
			- artifact maybe? but idk if balanced
			- map for carbon-copy things
				- rclick to write to shelves
				- copy to the offand item
			- ribbon for bookmarks (special item? or)
				- scrolling while holding ctrl(?) flips 8 pages?
				- or maybe apply bookmark on use in mainhand
					- offhand spellbook's current page is marked
					- scrolling with ctrl skips thru marked pages
		- use nbt data to store rclick action & page count

		- special Novice's Bound Spellbook
			- doesn't use chorus
			- very low page count (4~8)
				- another firework-like handler
				- large scrolls worth 1, ancients worth 2

---------Other Hex gear and trinkets --------
    Caster's Head Mirror:
		head trinket, based on the old doctor's headband
		- maybe reflects raycasts?
			- return null if they hit the wearer
			- only when originating from a point in the caster's vision?
			- i.e. when norm(raycast) dot lookdir > 0

	DIADEMS - line of head curios
		Charged Amethyst Diadem:
			- crafted with an empty diadem and charged
			- amethyst on it shatters to prevent hex-related damage 
				- one-time, turns back into empty diadem after (recraft)
				- includes bloodcasting and damaging mishaps (like div0)
			- can be made pre-enlighten but is decorative at first, like slates
			- advancement for having it break for the first time
				- "It... saved me. ..."
				- (X) challenge for breaking it as your first bloodcast
					- ill-advised, locked forever post-enlightenment
	
	    Budding Amethyst Diadem: (bud diadem)
	        a headband that grows tiny clusters from its wearer's brain activity
	        - doing certain things can make it briefly go faster (see QUALIA)
	
	    Bloodletter's Diadem: (blood diadem)
			- a use for the Butcher in flaying!
			- keeps the wearer below a set amount of health, and refunds it as media
			    - conversion rate is better the lower the limit is (player chooses limit)
					- is implied to only be a half heart below max
						- add puzzle prog where they set it lower
					- range is 1/hp to 2/hp? tentative
					- also gets a bonus when a lot of hp is taken at once
			- "if my Enlightenment came from the grandest siphon my mind could take in a
				single instant, it follows that the inverse should be the least
				disruptive to passive thought. I shall design the piece this way,
				the sensation of breaking away thinned to something I might be able to bear.
				thus, the diadem siphons from my mind in small, sometimes imperceptible
				increments. 
				
				these increments, they are sometimes blurred by the thresholds
				I usually feel to determine my health, some twenty sums of amethyst dust.
				the diadem might award media while only taking some fraction of a dust,
				or a fraction between one of these thresholds"
			- but, the player sets the limit lower somehow, unlocking the next part:
				- tooltip "it seems to be lacking/hungry/only partially full"
				- flay more butchers into it, perhaps?
				- "the butcher's task is to apportion my psyche--my synapses. barring more... gruesome diction,
					it is what decides how much of me to take. through the level of the mind, I must take care
					to tune its... voracity. ill-accomplishing this control could spell nigh unimaginable pain.
					... (empty line)
					though... perhaps it could increase the yield? NO, no. perdition, all for thickened harvest?
					I should be so foolish.
					... (empty line, maybe page break?)
					But."
				- recipe takes level N (apprentice maybe?), but using >N solves the puzzle
			--------- after puzzle progression --------
			- "What might happen if you let it have more?" <- italic, beginning of unlocked page
			- will have like, spikes that lead into the skull (metal af) (maybe)
				- maybe these "grow in" after wearing it for an extended period of time?
					- or maybe they appear once progressing them
				- x has made the challenge [I... can't... take... this... off... Ever.]
				- provide aforementioned method of taking it off (other than death)
			- "it aches, OH HOW IT **ACHES**, but it fills my pockets..."
			- might charge to an internal reservoir, or to held items like rumination
				- choose which depending on what was flaid (base vs phial one?)
	
	Hex Gear: Rings!
	    - one to make a given spell cheaper
		- write a spell pattern to it, reduces the cost
		- constant or percentage? start with half & tweak/config
		- call it the "Ring of Signature Spells"? (D&D reference)
	    - Silk Touch/Fortune rings (modifies break block)
			- made obselete by hexical patterns, though may be useful for not incurring cost
	    - reach ring, that adds some proportion of your reach distance to your ambit
	        - could be a hand slot item
	
	QUALIA (kwah-lee-uh):
	    a multiplicative bonus stat with beneficial effects, like a Hexing Streak! tm
	    Qualia is increased by:
	        - staffcasting
	        - bloodcasting(?)
	        - activating spell circles
```
wow you really read that whole thing? I'm flattered. anyway, this is by no means what is set in stone, but I write things here when I want to keep from forgetting them - so make of that what you will. lol. 
