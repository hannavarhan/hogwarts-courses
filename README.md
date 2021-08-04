# final-epam-project

#Hogwarts Online

Guest can register to the system and then look through different courses created by professors of Hogwarts School of Witchcraft and Wizardry.
Pupils can also enroll in these courses and study them. After studying, pupils can leave feedback and rate course. Professors (registered by admin) can create and delete courses.

###Actors

Actor | Description | 
--- | --- |
Guest | Unregistered user. Can look throw the list of available courses.
Pupil | Registered user. Can search for required course, enroll in a course and study it. User can also estimate studied course and leave a comment.
Professor | Registered by admin user. Can create new courses.
Admin | Can register new professors.

# Use cases

###1. Login

Goal | Login
--- | --- |
Actor | Guest | 
Trigger event | The guest presses the button "Login”.
Pre-condition | -
Post-condition | If the use case is successful, the user logs in. Otherwise, the state of the system will not change.
####Basic path:
1. The system asks for a login and password.
2. Guest enters login and password.
3. The system checks the login and password, then gives access to the system.
Admin | Can register new professors. 
   
####Wrong Input Data Path:

If login and/or password are incorrect the system displays an error message.


###2. Login

Goal | Registration
--- | --- |
Actor | Guest | 
Trigger event | The guest presses the button "Register”.
Pre-condition | -
Post-condition | If the use case is successful, the user is registered and logs in. Otherwise, the state of the system will not change.
####Basic path:
1. The system asks for an information in registration form.
2. Guest fills necessary fields and confirms form.
3. The system validate filled information, displays a message about an email sent and input form for token and sends an email with a token for confirmation to the user's mail.
4. User inputs token.
   
####Wrong Input Data Path:
   
If the information in registration form is incorrect, the system displays an error message.
   
####Connection Problems Path:

If the system failed to send the mail or add user to database, it displays an appropriate message about the error and offers to try later.

###3. Enroll in a course

Goal | Enroll in a course.
--- | --- |
Actor | Pupil | 
Trigger event | The pupil presses the button "Enroll”.
Pre-condition | The pupil is logged in, selects course.
Post-condition | If the use case is successful, the pupil enrolls in a course. Otherwise, the state of the system will not change.
####Basic path:
1. The system asks for an information in registration form.
3. Guest fills necessary fields and confirms form.
4. The system validate filled information, displays a message about an email sent and input form for token and sends an email with a token for confirmation to the user's mail.
5. User inputs token.

####Wrong Input Data Path:
If the information in registration form is incorrect, the system displays an error message.

####Connection Problems Path:
If the system failed to send the mail or add user to database, it displays an appropriate message about the error and offers to try later.
