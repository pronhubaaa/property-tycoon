# Game Engine documentation
---

## CardAction Interface 

This interface dictates any transaction that can happen from an "Oppertunity knocks" or "Pot luck" card.

### Public Methods 

- #### payParking(Int): Void

This allows the player to pay free parking.

- #### payBank(Int): Void

This allows the player to pay the bank.

- #### pay(Int, Player): Void

This allows a player to pay another player.

- #### pay(Int, [Player]): Void

This allows a player to pay multiple players.

- #### receive(Int): Void

This allows a player to recieve money from the bank.

- #### goTo(Tile): Void

This sends a player to a specific tile.

---