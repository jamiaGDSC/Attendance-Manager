# Android-Study-Jams

Attendance tracker app

<b> Problem Statement: </b>

There has been a new rule in many collages in india i.e, for the students to maintain 75% mandatory attendance to be able to sit for exams. Most students couldn't keep the track of their attendance, just by taking notes or writing down the dates.

<b> Proposed Solution : </b>
This project proposes a Attendance tracker app (a.k.a Bunk Manager) to keep track of their attendance, Ability to check what classes they can bunk and how many classes do they need to attend to get back to 75% of attendance. This also gives a total summary of No. of classes can be bunked in all classes included and similar for the the must attend clases to get back at 75%.ile device and mapping it to the database. Google API’s are used for accuracy in finding the location of the busses. Currently the app works for GNITS institute only. The project's scope is to extend it for other institutions to transport services in future in collaboration.

## // todo add ss
<img width="559" alt="sampleimages" src="https://user-images.githubusercontent.com/18289261/142846646-a6858641-ad88-43aa-b8bb-b690fd7126f1.png">
    	  	
<b> Functionality & Concepts used : </b>
- Databindng: All the activities and Fragments are built on Databinding including the RecyclerView Adapters.
- Coroutines and LiveData: Roomdatabase functions, live updates in the app are managed using Coroutines and LiveData for a better user experience.
- RecyclerView: Add a list of subject into a recyclerview, with all the required info on how many classes to attend, how many you can bunk.
- RoomDatabase: Add or remove subjects, attendance progress and all other details are stored in the room database. 
- User can edit the Interface for the app, add/remove subjects, have a track of total no. of classes he need to attend and total no. of classes he can bunk.
- Toggle Dark mode/light mode.

<b> Application Link & Future Scope : </b>
The app is currently in Alpha testing phase with JMI. 
Edge cases to be tested:
- Having a large number of subjects.
- Adding and removing subjects from the time table.
- How the dark mode is handled.

You can try out the app here, if you find any crash/bugs do file a issue here.
