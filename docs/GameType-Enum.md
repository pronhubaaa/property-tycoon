---
id: GameType-Enum
title: Game Type Enum
sidebar_label: Game Type 
---

```java
public enum GameType
```

This enumeration will show different game type options, this could be added to. 

### Types
- #### FullGame
```java
FullGame,
```
In the full game there is no time limit. A winner is determined by whoever is the last player with funds.  

- #### AbridgedGame 
```java
AbridgedGame
```
In the abridged game there is a time limit defined in the UI. At the end of the time the winner is the player with the most assets. 

---