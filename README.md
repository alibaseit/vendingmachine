Vending Machine

The application is a command line java application.

For creating jar file please use maven.
The maven command for creating a runnable jar file is:

mvn clean package

Jar file is going to be created under target directory.

For running the application the command is

java -jar target/vending-machine.jar

The application needs coin-inventory.properties file, and it must be under the current directory.

When the app starts a menu is going to appear on screen. The user should select a valid option from menu.

Application Menu
***********************************************************************************************

Please enter a valid option
Enter option:
1. getOptimalChange
2. getChange
3. Exit

if user enters options 1 or 2, user is going to be asked to enter cents.

For example if the user selects option 2 and enters cents as 566 the output will be like this:
[ONE_EURO, ONE_EURO, ONE_EURO, ONE_EURO, ONE_EURO, FIFTY_CENT, TEN_CENT, FIVE_CENT, ONE_CENT]

When user select option 2,  if there is no sufficient coinage the app will throw NotSufficientCoinageException.
