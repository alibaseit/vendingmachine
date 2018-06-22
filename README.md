Vending Machine

The application is a command line java application.

It is a maven application.
For creating jar file please use maven. The maven command for creating a runnable jar file is:
mvn clean package

Maven is creates jar file under target directory.

For running the application the command is
java -jar target/vending-machine.jar

The application needs coin-inventory.properties file, and it must be under the current directory.

When the app starts to user should select an option from menu that is displayed on screen.

Application Menu
***********************************************************************************************

Please enter a valid option
Enter option:
1. getOptimalChange
2. getChange
3. Exit

if user enters options 1 or 2, user is going to be asked to enter cents.

For example if user selects option 2 and
enters cents as 566 the output will be
[ONE_EURO, ONE_EURO, ONE_EURO, ONE_EURO, ONE_EURO, FIFTY_CENT, TEN_CENT, FIVE_CENT, ONE_CENT]

if there is insufficient coinage the app throws NotSufficientCoinageException.



