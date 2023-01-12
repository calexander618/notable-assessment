# notable-assessment
This solution is written in Java and built with Gradle. The application logic lives in [TextProcessor.java](src/main/java/org/solution/TextProcessor.java), and the unit tests live in [TextProcessorTest.java](src/test/java/org/solution/TextProcessorTest.java). When a pull request is opened, said unit tests will be executed during the Gradle build proccess by a [GitHub Action](.github/workflows/gradle.yml).

## Running the Application 
1. Install Gradle - `brew install gradle`
2. Run Application - `gradle run`
3. Run Tests - `gradle test`
