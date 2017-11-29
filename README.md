# PLATFORMER AI: TURING TEST

## PROGRAMMING ASSIGNMENT 3 ~ CS/IMGD 4100 ~ 2017 B TERM

**Deadline** : **December 3, 11:59pm**

### DESCRIPTION

For this assignment, you will be creating an AI controller for Mario, such that Mario will be able to traverse arbitrary levels. The focus of the assignment is on decision-making and movement within a continuous 2D environment. The Mario AI Competition was been held at the IEEE Computational Intelligence in Games conference for several years; you will be using the framework from the 2009 version of this competition.

You will be turning in:

1. Full source code.
2. An assignment writeup, in PDF format.
3. A short video of your Turing Test controller, posted on YouTube or Vimeo.
4. A readme text file containing: your name(s), the names of any people who helped you with the assignment, references to any external sources you used, a list of all the files you created for this assignment and their location, complete instructions necessary for getting your code to work, and how many late days (if any) you wish to apply to the assignment. **And don’t forget to include the link****to your video!**

### PASSING THE TURING TEST?

Your goal with this assignment is to create an agent that could pass a Turing Test when compared with non-expert (but still relatively competent) human players.

You are being provided with an existing A\* agent, created by Robin Baumgarten. This agent won the gameplay competition in 2009. The existing agent has a goal to reach the end of the level. You may use this code as part of your agent if you wish, though the majority of what you turn in should be yours (it is acceptable to modify the A\* agent to use some different goal and/or heuristic as part of your assignment). Make sure to clearly note where you are re-using someone else’s code. You will also see a very simple “jumping” agent, for your reference, as well as several other sample agents of varying levels of complexity.

You can implement any of the decision-making techniques we’ve discussed in class (e.g. decision trees, behavior trees, finite state machines), or you may choose to use some other AI technique that you have learned about elsewhere.

These are some things you might want to consider when creating an agent that acts like a human:

- Humans typically make mistakes.
- Human players have different preferences and play styles. Some like to try to collect everything, some
    like to kill all the enemies, some like to run. But very rarely does a human player act as a complete
    caricature of these styles; most will balance several goals simultaneously.
- Humans exhibit emotions. These can be pretty hard to identify in a platformer player, but consider
    elements such as surprise at enemies appearing or freezing if overwhelmed by several challenges at
    once.
- You may want to ask friends to play Mario while you watch and take note of any behavior they exhibit.
- Your agent needs to be able to perform on a variety of different levels; be careful not to overfit your
    agent to a single example level.

**There is no single correct answer to this assignment.** Be creative, but be careful to take small steps towards your goal. If you are too ambitious at first you can easily get lost. **You are encouraged to share your high level strategies with the rest of the class, but do not share code.**

Please do not modify the framework itself. Your agent code should be placed in its own directory and given its own name, following the structure of the two provided agents. Your agent should be written in Java.

### GETTING STARTED

- Sample agents are in the competition.cig package.
- MainRun.java in the ch.idsia.scenarios package will run all bots that are added to the agent pool in the
    method public static void createAgentsPool(), and will run them in order across 10 different generated
    levels
- Play.java in the ch.idsia.scenarios package will run the bot specified on the first line of the main
    method
- ch.idsia.mario.engine.GlobalOptions.java has a static variable, _Overlay_, which controls whether the
    text overlay on the game screen renders. You should turn this overlay off before making your video,
    otherwise we will see the name of your agent.

### ASSIGNMENT WRITEUP

Your writeup does not need to be very long –a page or two is sufficient. Argue for what your goal was with the
agent, why your goal is reasonable, and how well you feel you achieved it. State which technique(s) you used and why, and what the pros and cons were of your chosen technique. Describe the strengths and weaknesses of your agent. This writeup should also document any steps in your process that you wish to highlight.

### RESOURCES

1. A copy of the Mario AI framework, including Robin Baumgarten’s A* framework and Sergey Karakovskiy’s Jumping Agent is included with this assignment.

2. Robin Baumgarten did an interview with AI Game Dev that you may find helpful in understanding his design decisions: [http://aigamedev.com/open/interviews/mario-ai/]
(http://aigamedev.com/open/interviews/mario-ai/)

3. This paper describes the Mario AI benchmark: [http://julian.togelius.com/Togelius2009Super.pdf](http://julian.togelius.com/Togelius2009Super.pdf)

4. The Mario AI competition has resulted in several academic papers. Here is a link that points to several of them; however, there are more out there if you are interested in finding them. Most have been published at IEEE CIG in the last three years: 
[http://www.marioai.org/RelatedPapers](http://www.marioai.org/RelatedPapers)

### SUBMISSION INSTRUCTIONS

Turn in a .zip file on InstructAssist containing:

- All of your source code, including the original framework code.
- Your readme file, including a link to your video.
- Your project writeup.

Assignments must be turned in via InstructAssist. **Emailed assignments will not be accepted.**

