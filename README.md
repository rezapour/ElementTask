# Task
## Briefing
This is a simple app that calculates the cron times.
The app starts form Main class and main method and use 4 other classes:
* CronParser: this class parse the inputs from the file
* InputValidation: this class validates the inputs from the file
* TimeValidator: this class validates the default time that we get in args
* CronCalculator: this is responsible for main logic behind cron calculations. 

There are also test class to check different scenarios and edge-cases.

## How to run the project
You can use the Ide for run the project or using the following commands:
```
./gradlew build
cat file.txt | java -jar project.jar 15:54
```


