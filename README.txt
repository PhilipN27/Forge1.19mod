What is this?
-------------------------------------------
This github houses my 1.19 Minecraft Mod. Since I was a kid I've always wanted to add my own ideas into minecraft. Minecraft is my favorite game of all time, and being able to add my own changes has been a lot of fun. 

What does it add?
-------------------------------------------
This mod adds a wide variety of things ranging from game features to ore generation.

Here is a list of the added mods:
====================================
-Strawberries/strawberry crop
-New light block
-New jump block(ignitium block)
-New raw material called Ignitium which includes: raw ignitium, ignitium ingot, ignitium ore(deepslate,endstone, netherrack)
-2 new paintings
-New Creative tab(page 2)

COMING SOON:
==============
-New weapon
-Easier mode switching
-Different HUD

Source installation information for modders
-------------------------------------------
This code follows the Minecraft Forge installation methodology. It will apply
some small patches to the vanilla MCP source code, giving you and it access 
to some of the data and functions you need to build a successful mod.

Note also that the patches are built against "un-renamed" MCP source code (aka
SRG Names) - this means that you will not be able to read them directly against
normal code.

Setup Process:
==============================
BEFORE STARTING!!! GO TO THE BOTTOM OF THIS READ ME AND USE THE 'SETUP' LINK ATTACHED
FOLLOW THESE STEPS FROM THE VIDEO IN ORDER:
'DOWNLOADING AND INSTALLING THE JDK'
'DOWNLOADING AND INSTALLING INTELLIJ IDEA'
'DOWNLOADING THE FORGE MDK'
'OPENING INTELLIJ FOR THE FIRST TIME'
'CHANGES IN THE BUILD.GRADLE FILE'
AFTER DOING THESE YOU SHOULD BE GOOD BUT I HIGHLY RECOMMEND FOLLOWING THE VIDEO CLOSELY THROUGHOUT.

I HIGHLY RECOMMEND USING INTELLIJ IDEA OVER OTHER OPTIONS SUCH AS VSCODE OR ECLIPSE.

Step 1: Open your command-line and browse to the folder where you extracted the zip file.

Step 2: You're left with a choice.
If you prefer to use Eclipse:
1. Run the following command: `gradlew genEclipseRuns` (`./gradlew genEclipseRuns` if you are on Mac/Linux)
2. Open Eclipse, Import > Existing Gradle Project > Select Folder 
   or run `gradlew eclipse` to generate the project.

If you prefer to use IntelliJ:
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Run the following command: `gradlew genIntellijRuns` (`./gradlew genIntellijRuns` if you are on Mac/Linux)
4. Refresh the Gradle Project in IDEA if required.

If at any point you are missing libraries in your IDE, or you've run into problems you can 
run `gradlew --refresh-dependencies` to refresh the local cache. `gradlew clean` to reset everything 
{this does not affect your code} and then start the process again.

Mapping Names:
=============================
By default, the MDK is configured to use the official mapping names from Mojang for methods and fields 
in the Minecraft codebase. These names are covered by a specific license. All modders should be aware of this
license, if you do not agree with it you can change your mapping names to other crowdsourced names in your 
build.gradle. For the latest license text, refer to the mapping file itself, or the reference copy here:
https://github.com/MinecraftForge/MCPConfig/blob/master/Mojang.md

Additional Resources: 
=========================
Community Documentation: https://mcforge.readthedocs.io/en/latest/gettingstarted/  
LexManos' Install Video: https://www.youtube.com/watch?v=8VEdtQLuLO0  
Forge Forum: https://forums.minecraftforge.net/  
Forge Discord: https://discord.gg/UvedJ9m  
Setup Tutorial:https://www.youtube.com/watch?v=LpoSy091wYI
