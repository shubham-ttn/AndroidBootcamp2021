# Session : Navigation Component

### Exercise

* Create an application with these screens:

1. Splash (Shall open everytime, check if "name" is already stored in SharedPref then move user to Home, else move to Login).
2. Login (Shall open after Splash: Enter & store "name" in SharedPref)(If "name" is not present, ask user to provide one, and move to Home screen)
3. Home (Title(EditText) and Description(Textview), to add Description(Textview) click on it to open Dialog(with Title passed to it)(Create a button on Home to open Account screen)
4. Dialog (Description(EditText) value shall be returned to Home and set to the Description:Textview on back button click)
5. Account (Shall check for "name" SharedPref value, if exists, show it in a textview, else Show a toast, that user is not found)(Create an implicit deeplink to navigate to the Acccount screen.)

 
_Note: Use implicit deeplinks for deeplinking. Use SafeArgs to pass data to the dialog. Use NavBackStackEntry to get data back from the Dialog. Use PopUpto and PopUpto inclusive to make sure that Spash shall not open on back button pressed from Home or Login._

<img src="naviagation_demo.gif" width="300" height="600"/>
