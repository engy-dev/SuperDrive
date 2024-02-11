# Super*Duper*Drive Cloud Storage
You have been hired by Super*Duper*Drive, which is a brand new company aiming to make a dent in the Cloud Storage market and is already facing stiff competition from rivals like Google Drive and Dropbox. That hasn't dampened their spirits at all, however. They want to include personal information management features in their application to differentiate them from the competition, and the minimum viable product includes three user-facing features:

1. **Simple File Storage:** Upload/download/remove files
2. **Note Management:** Add/update/remove text notes
3. **Password Management:** Save, edit, and delete website credentials.  

Super*Duper*Drive wants you to focus on building the web application with the skills you acquired in this course. That means you are responsible for developing the server, website, and tests, but other tasks like deployment belong to other teams at the company. 


I started with this starter code: https://github.com/udacity/nd035-c1-spring-boot-basics-project-starter/tree/master/starter/cloudstorage

I didnt design the database but I coded the java that interacts with it, then I configured the static pages with Thymeleaf in order toadd functionality and real data from the server. I also implemented these aspects:

### The Back-End
The back-end is all about security and connecting the front-end to database data and actions. 

1. Managing user access with Spring Security
 - Restricted unauthorized users from accessing pages other than the login and signup pages. 
 - Used the security configuration to override the default login page with one of my own, discussed further in the front-end section.
 - Implemented a custom `AuthenticationProvider` which authorizes user logins by matching their credentials against those stored in the database.  


2. Handling front-end calls with controllers
 - Wrote controllers for the application that bind application data and functionality to the front-end, which includes using Spring MVC's application model to identify the templates served for different requests and populating the view model with data needed by the template. 
 - The controllers are responsible for determining what, if any, error messages the application displays to the user. When a controller processes front-end requests, it delegates the individual steps and logic of those requests to other services in the application, and it interprets the results to ensure a smooth user experience.


3. Making calls to the database with MyBatis mappers
 - Since I was provided with a database schema to work with, I designed Java classes to match the data in the database. 
 - To connect these model classes with database data, I implemented MyBatis mapper interfaces for each of the model types. These mappers have methods that represent specific SQL queries and statements required by the functionality of the application. They also support the basic CRUD (Create, Read, Update, Delete) operations for their respective models.


### The Front-End

1. Login page
 - Users can use this page to login to the application. 
 - Shows login errors, like invalid username/password, on this page. 


2. Sign Up page
 - Potential users can use this page to sign up for a new account. 
 - Validates that the username supplied does not already exist in the application, and show such signup errors on the page when they arise.
 - The user's password is stored securely.


3. Home page
The home page is the center of the application and hosts the three required pieces of functionality. The existing template presents them as three tabs that can be clicked through by the user:


 i. Files
  - The user is able to upload files and see any files they previously uploaded. 
  - The user is be able to view/download or delete previously-uploaded files.
  - Any errors related to file actions are displayed.


 ii. Notes
  - The user is able to create notes and see a list of the notes they have previously created.
  - The user is able to edit or delete previously-created notes.

 iii. Credentials
 - The user is able to store credentials for specific websites and see a list of the credentials they've previously stored. Passwords are encrypted.
 - The user is able to view/edit or delete individual credentials. When the user views the credential, they can see the unencrypted password.

The home page has a logout button that allows the user to logout of the application and keep their data private.

### Testing

1. Wrote tests for user signup, login, and unauthorized access restrictions.
 - Wrote a test that verifies that an unauthorized user can only access the login and signup pages.
 - Wrote a test that signs up a new user, logs in, verifies that the home page is accessible, logs out, and verifies that the home page is no longer accessible. 


2. Wrote tests for note creation, viewing, editing, and deletion.
 - Wrote a test that creates a note, and verifies it is displayed.
 - Wrote a test that edits an existing note and verifies that the changes are displayed.
 - Wrote a test that deletes a note and verifies that the note is no longer displayed.


3. Wrote tests for credential creation, viewing, editing, and deletion.
 - Wrote a test that creates a set of credentials, verifies that they are displayed, and verifies that the displayed password is encrypted.
 - Wrote a test that views an existing set of credentials, verifies that the viewable password is unencrypted, edits the credentials, and verifies that the changes are displayed.
 - Wrote a test that deletes an existing set of credentials and verifies that the credentials are no longer displayed.
