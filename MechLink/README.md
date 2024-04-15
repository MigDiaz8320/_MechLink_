# MechLink
##  MechLink Project Structure:

### The project is organized as follows:

*Navigate to the src directory, then proceed to main and further into the java folder.

* Inside the java folder, you will find a structure adhering to the Model-View-Controller (MVC) pattern.
* All four classes are in the Model folder
* Specifically, the User class is an abstract class that can be located within the Model folder.

* Additionally, the Authenticate interface is placed in the Controll folder.

Functional Requirements and How to Test
* User Creation: On the login page, click the "Sign Up" button on the login page and fill out the form
* User Login: On the login page, click the "Login" button and enter username and password.
* Job Posting: On the client page, click "Post Job", fill the form
* Job Accepting: On the mechanic page, click "Accept" on a job
* Job Completion Confirmation: On the client page, click "Completed" on a job

Non-Functional Requirements
* Usability: Usability is ensured by having clearly labelled buttons and displaying the most important
  information (Jobs) front and center for users
* Data Retention: Data Retention is ensured by using a SQLite database to store user data
* Security: Security is ensured by storing user data in a database with minimal outside access
* Privacy: Privacy is ensured by only displaying relevant client data to prospective mechanics,
  The clients Username, Car, Zipcode. Username for real life identification, Car so that the mechanic knows what
  kind of parts and/or tools they might need and zipcode so they have a rough estimate of how far they'll need to travel
  for the job. 