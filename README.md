#Vending Machine

The application is a command line java application.

For creating jar file please use maven.
The maven command for creating a runnable jar file is:

`mvn package`

Jar file is going to be created under target directory.

For running the application the command is

`java -jar target/vending-machine.jar`

The application needs coin-inventory.properties file, and it must be under the same directory with jar.

When the app starts Application Menu is going to appear on screen. The user should select a valid option from the menu.

###Application Menu
***********************************************************************************************

Please enter a valid option
1. getOptimalChange
2. getChange
3. Exit

Please select a valid option (e.g 1,2). If option 1 or 2 is selected then user is asked to enter cents value.

For example if the user selects option 2 and enters cents as 566,
the computed output will be:
[ONE_EURO, ONE_EURO, ONE_EURO, ONE_EURO, ONE_EURO, FIFTY_CENT, TEN_CENT, FIVE_CENT, ONE_CENT]


In option 2 selection, if the inventory is not sufficient, the app will throw NotSufficientCoinageException exception.
And also the option 2 updates coin inventory properties file.
