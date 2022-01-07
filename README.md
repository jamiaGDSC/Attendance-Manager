# Android-Study-Jams

Attendance tracker app

<b> Problem Statement: </b>

There has been a new rule in many collages in india i.e, for the students to maintain 75% mandatory attendance to be able to sit for exams. Most students couldn't keep the track of their attendance, just by taking notes or writing down the dates.

<b> Proposed Solution : </b>
This project proposes a Attendance tracker app (a.k.a Bunk Manager) to keep track of their attendance, Ability to check what classes they can bunk and how many classes do they need to attend to get back to 75% of attendance. This also gives a total summary of No. of classes can be bunked in all classes included and similar for the the must attend clases to get back at 75%.ile device and mapping it to the database. Google API’s are used for accuracy in finding the location of the busses. Currently the app works for GNITS institute only. The project's scope is to extend it for other institutions to transport services in future in collaboration.

<img width="200" alt="sampleimages" src="https://user-images.githubusercontent.com/54740946/148618556-e44ec3da-05de-4a7f-9264-24c7e1384560.png">    <img width="200" alt="sampleimages" src="https://user-images.githubusercontent.com/54740946/148618638-6288b08b-cce8-4ad8-9b04-aa26655d22d5.png">      <img width="200" alt="sampleimages" src="https://user-images.githubusercontent.com/54740946/148618662-c23c753c-aeca-4a35-9fba-a9bb19c76284.png">      <img width="200" alt="sampleimages" src="https://user-images.githubusercontent.com/54740946/148618700-2a7e0894-494e-42d5-b783-c954bdc889fb.png">



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

You can try out the app [here](https://github.com/jamiaGDSC/Attendance-Manager/blob/dev/app-debug.apk), if you find any crash/bugs do file a issue [here](https://github.com/jamiaGDSC/Attendance-Manager/issues).
