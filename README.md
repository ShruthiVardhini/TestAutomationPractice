This repository is a practice project for writing and executing Selenium Java test automation scripts. The goal is to build expertise in test automation using Selenium while testing free public websites.

🚀 Purpose
To enhance proficiency in Selenium WebDriver with Java.
To practice automating functional tests for websites.
To explore testing frameworks like Cucumber.
To experiment with automation practices such as Page Object Model (POM).
~~~~~~~~
🔧 Features
Test cases for interacting with free public testing websites, such as:
[Automation Practice](http://automationpractice.com/)
[QA Practice](https://qa-practice.netlify.app/)
[LUMA](https://magento.softwaretestingboard.com/)
Scripts organized by test suites (e.g., Login Tests, Form Submission Tests, Navigation Tests).
Use of Selenium WebDriver for browser automation.
Examples of best automation practices (e.g., reusable methods, assertions).

🛠️ Technology Stack
Language: Java
Automation Framework: Selenium WebDriver
Build Tool: Maven
Testing Framework: Cucumber
Browser Support: Chrome, Firefox (Others optional)
IDE: IntelliJ IDEA

📁 Project Structure

selenium-java-practice
├── src
│   ├── main
│   │   └── java
│   ├── test
│   │   └── StepDefinitions
│        ├── Features                 # Page Object Model classes
│        ├── RunnerFile             # Test case classes
│        ├── utils                        # Helper utilities
├── pom.xml                          # Maven dependencies
└── README.md


📝 Getting Started
1. Clone the repository:
   In bash:
- git clone https://github.com/your-username/selenium-java-practice.git
- cd selenium-java-practice

2. Set up dependencies:
   Ensure Java is installed (java -version).
   Instal latest version of Intellij with Maven.

3. Run the tests:
   Execute test scripts using the IDE's Test Runner or Maven:
   In bash:
   mvn test

4. Configure browsers:

Install appropriate WebDriver executables (e.g., chromedriver).	