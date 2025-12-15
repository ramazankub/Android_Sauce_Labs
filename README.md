# Android Mobile Automation Tests (Appium)

This project contains automated UI tests for an Android application using **Appium**, **Java 21**, **JUnit 5**, and **Selenide Appium**.

The project demonstrates a clean and scalable mobile test automation framework with proper separation of concerns and the Page Object pattern.

---

## Tech Stack

- Java **21**
- Gradle
- Appium **2.x**
- UIAutomator2
- Android SDK
- JUnit 5
- Selenide Appium
- Allure Reports

---

## Project Structure

```
src/test/java
├── drivers        # Driver factory and capabilities setup
├── pages          # Page Objects
├── tests          # Test classes and BaseTest
├── utils          # UI and gesture helpers
├── testData       # Test data and constants

src/test/resources
├── app             # Android APK
├── capabilities    # Appium capabilities configuration
```

---

## Application Under Test

Tests are executed against an Android demo application.

The APK is included in the project for simplicity and is installed automatically by Appium before test execution.

---

## Prerequisites

Before running the tests, make sure the following tools are installed.

### 1. Install Java 21

Download and install **Java 21 (LTS)** from the official site:

https://adoptium.net/

Verify installation:

```bash
java -version
```

---

### 2. Install Node.js (18+)

Download and install **Node.js LTS** from:

https://nodejs.org/

Verify installation:

```bash
node -v
npm -v
```

---

### 3. Install Appium 2.x

Install Appium globally via npm:

```bash
npm install -g appium
```

Verify installation:

```bash
appium -v
```

Install required Appium driver:

```bash
appium driver install uiautomator2
```

---

### 4. Install Android SDK

Install **Android Studio** (includes Android SDK):

https://developer.android.com/studio

After installation:
- Open Android Studio
- Install Android SDK and Platform Tools
- Create and start an Android Emulator  
  **or** connect a real Android device with USB debugging enabled

Verify ADB connection:

```bash
adb devices
```

---

## How to Run Tests

1. Start Android Emulator or connect a real Android device

2. Start Appium server:

```bash
appium
```

3. Run tests using Gradle:

```bash
./gradlew test
```

4. (Optional) Generate Allure report:

```bash
./gradlew allureReport
```

5. (Optional) Open Allure report in browser:

```bash
./gradlew allureServe
```

---

## Test Coverage

- Login (positive and negative scenarios)
- Validation error messages
- Parameterized tests for invalid credentials
- Basic UI navigation checks
- Gesture-based interactions (scroll / swipe)

---

## Key Design Decisions

- Page Object pattern is used to separate test logic from UI implementation
- Test data is centralized and separated from test logic
- No static state is used in Page Objects or test classes
- Tests are isolated and independent
- Parameterized tests are applied for negative scenarios
- Capabilities are configured via properties files
- No hardcoded waits (`Thread.sleep`) are used
- Explicit waits are handled via Selenide conditions
- Modern Appium W3C Actions API is used for gestures

---

## Test Execution Flow

1. Driver is created via `AndroidDriverFactory`
2. Capabilities are loaded from `src/test/resources/capabilities`
3. Application is installed automatically by Appium
4. Tests are executed using JUnit 5
5. Driver is terminated after each test
6. Allure results are generated after execution

---

## Environment

- Java 21
- Appium 2.x
- UIAutomator2
- Android Emulator or real Android device
- Gradle build system
