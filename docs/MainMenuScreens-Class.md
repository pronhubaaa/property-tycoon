---
id: MainMenuScreens-Class
title: Main Menu Screens class
sidebar_label: Main Menu Screens
---

This class returns a scene which loads the main menu for the player.

## Public Methods
### getMainMenu
```java
public static Scene getMainMenu(UI ui, GameEngine gameEngine)
```

*Parameters*: The UI object.
*Returns*: A scene containing the main menu.

Returns a scene containing the main menu.


### getMainMenuButton
```java
private static Button getMainMenuButton(String buttonText, String buttonId, EventHandler<ActionEvent> actionEvent)
```

*Parameters*: The text for the button, the button name and an event handler
*Returns*: A new button object.

Returns a new button with the given parameters.

### getNewGame
```java
public static Scene getNewGame(UI ui, GameEngine gameEngine)
```

*Parameters*: The UI object and the current game engine.
*Returns*: A scene containing the new game setup screen.

Returns a scene containing new game setup screen.

### getLoadGame
```java
public static Scene getLoadGame(UI ui)
```

*Parameters*: The UI object.
*Returns*: A scene containing the load game screen.

Returns a scene containing load game screen.

### getImportBoard
```java
public static Scene getImportBoard(UI ui)
```

*Parameters*: The UI object.
*Returns*: A scene containing the import board screen.

Returns a scene containing import board screen.

### getSettings
```java
public static Scene getSettings(UI ui)
```

*Parameters*: The UI object.
*Returns*: A scene containing the settings screen.

Returns a scene containing settings screen.

### setSize
```java
public static void setSize(Labeled node, int width, int height)
```

*Parameters*: The UI object, the determined width and the determined height.
*Returns*: Void

Returns a scene containing settings screen.
