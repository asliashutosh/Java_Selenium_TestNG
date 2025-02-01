# Selenium Automation Framework

This is a Selenium-based automation framework designed for testing web applications. It follows the **Page Object Model (POM)** design pattern and uses **TestNG** for test execution and reporting. The framework also integrates **ExtentReports** for detailed HTML reporting and captures screenshots on test failures.

## 🚀 Features
- **Page Object Model (POM):** Separates test logic from page-specific logic for better maintainability.
- **ExtentReports:** Generates detailed HTML reports with screenshots for failed tests.
- **Configuration Management:** Uses a `config.properties` file to manage test data (e.g., URLs, credentials).
- **Screenshots on Failure:** Automatically captures and embeds screenshots in the report for failed tests.
- **WebDriverManager:** Automatically manages browser drivers (e.g., ChromeDriver).

## 📌 Prerequisites
Before running the tests, ensure you have the following installed:
- **Java Development Kit (JDK):** Version 8 or higher.
- **Maven:** For dependency management and build automation.
- **IDE:** IntelliJ IDEA, Eclipse, or any other Java IDE.
- **Browser:** Chrome (or any other browser supported by Selenium).

## 📁 Project Structure
```
src
├── main
│   ├── java
│   │   ├── pageObjects
│   │   │   └── homePage.java
│   │   ├── testBase
│   │   │   └── basePage.java
│   │   ├── utils
│   │       └── ExtentReportManager.java
│   │       └── ConfigReader.java
│   └── resources
│       └── config.properties
└── test
    └── java
        └── TestLogin.java
```

## 🔧 Setup Instructions
### 1️⃣ Clone the Repository
Clone this repository to your local machine:
```bash
git clone https://github.com/asliashutosh/Java_Selenium_TestNG.git
cd your-repo-name
```

### 2️⃣ Configure `config.properties`
Update the `src/main/resources/config.properties` file with your test data:
```properties
# Browser configuration
browser=chrome

# URL configuration
url=https://parabank.parasoft.com/parabank/index.htm

# Login credentials
username=testuser
password=password123

# Timeout configuration
timeout=10
```

### 3️⃣ Install Dependencies
Run the following Maven command to install all dependencies:
```bash
mvn clean install
```

### 4️⃣ Run the Tests
Execute the tests using the following Maven command:
```bash
mvn test
```

## 📊 Test Execution
- The tests will run in the browser specified in the `config.properties` file.
- Test results will be logged in the console.
- A detailed HTML report will be generated in the `test-output` folder.

## 📑 Reports
### **ExtentReports**
After test execution, an **HTML report** will be generated in the `test-output` folder. Open the report in a browser to view detailed test results, including:
- **Test status** (Pass/Fail/Skip).
- **Screenshots** for failed tests.
- **Logs and timestamps**.

### 📷 Screenshots
Screenshots are automatically captured for failed tests and embedded in the **ExtentReports HTML report**. No manual intervention is required.

## 📦 Dependencies
The project uses the following dependencies:
- **Selenium:** For browser automation.
- **TestNG:** For test execution and reporting.
- **ExtentReports:** For generating HTML reports.
- **WebDriverManager:** For managing browser drivers.
- **Apache Commons IO:** For handling file operations (e.g., screenshots).

## 🤝 Contributing
Contributions are welcome! If you find any issues or have suggestions for improvement, please **open an issue** or **submit a pull request**.


## 📩 Contact
For any questions or feedback, please contact:
- **Your Name:** [ashutoshsingh042@gmail.com](mailto:your.email@example.com)
- **GitHub:** [asliashutosh](https://github.com/your-username)

## 🎖️ Acknowledgments
- **[Selenium](https://www.selenium.dev/)** for browser automation.
- **[TestNG](https://testng.org/)** for test execution.
- **[ExtentReports](https://www.extentreports.com/)** for reporting.
- **[WebDriverManager](https://github.com/bonigarcia/webdrivermanager)** for managing browser drivers.

---

✨ **Happy Testing!** 🚀

