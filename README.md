<h1>Feeling Moody</h1>

Feeling Moody is an application that keeps track of your 
daily mood. It is design to help users track and manage 
their anxiety. Keeping tabs on your emotions can help you 
identify your go-to thought patterns and major anxiety triggers.
With this information, you'll be able to dig deeper into why 
those triggers resonate so strongly with you and the app will
provide suggestions for how to deal with them more effectively.

<h3>User Stories</h3>

- As a user, I want to enter my mood in the AM.
- As a user, I want to enter my mood in the PM.
- As a user, I want to get my daily average.  
- As a user, I want to see my current mood ratings.


<h3>User Stories part 2:</h3>

- As a user, I want to be able to save my current mood to file.
- As a user, I want to load my mood log from file when the program starts.
- As a user, when I quit the application menu, I want the option to save my current mood to my log.


<h3> Instructions For the Grader:</h3>

- In the AM Mood tab, you can generate the first required event by selecting a mood rating on the slider. Once you 
picked a rating, press the Set button to set the mood. 
- You can generate the second required event by using the combobox below and selecting the day you want to set this 
mood rating to (selected day and rating will be printed below in the text panel). Press Save! button to save mood entry.  
- Entering and setting PM mood is the same as AM mood but is done in the PM Mood tab.
- You can generate the average mood for the day by using the combobox provided in the Daily Average tab. Select the day
and the average will be printed out.
- You can load your current mood ratings in the Week Log tab. Select the day using the combobox and the mood log will be
printed.
- You can trigger my audio component by using the Set and Save Mood! buttons in the AM Mood and PM Mood tab.
- You can save the state of my application by clicking the Save Mood! buttons in the AM Mood and PM Mood tab.
- You can reload the state of my application by closing the application and reopening it up with the last saved ratings 
loaded (automatically reloads when you start up the application).


<h3> Phase 4: Task 2</h3>

- Option choosen: Make appropriate use of the Map interface somewhere in your code. 
- The map was used in the class MoodLogs in the model package.
- The key type is a String and the values type is an ArrayList of Mood Logs.
- I also added methods in the GUI class (addMoodLogToMap() and addSaveMoodLogToMap()), where the last saved Mood Log 
(when app was closed) and the new Mood logs added (when application is currently open), is added to the map. Mood logs 
are printed in the console.

 
<h3> Phase 4: Task 3</h3>

<h4>Problems identified:<h4>
 
 1) Low cohesion in the GUI class, it had multiple clusters of methods and it has too many responsibilities such as: 
 making panels/adding components to the panels, having several inner classes for action listeners/change listeners and 
 several other methods responsible for creating functionality for the GUI.
 2) Bad/High coupling in the GUI class and it did not having a single point of control.

 
<h4>Changes to improve the design of my code:<h4>

1) Using the Single Responsibility Principle to increase cohesion, I separated my GUI class into multiple classes. 
Each panel class is responsible for making a panel and the TabBar class is used to create a tabbed panel with all the
panels needed for the GUI.
2) To reduce coupling, I separated my GUI class into multiple classes, each class creating a panel for the GUI, located 
in the ui package. Additionally to have a single point of control, i passed in a GUI to each panel class. Thus all the information is 
passed back to the GUI and it decides what is done with the information.

 
 
 

