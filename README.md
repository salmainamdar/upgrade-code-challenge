### Notes
I have written these test cases/suites using [Carina](http://zebrunner.github.io/carina) test framework. This framework lays down the necessary structure required to build scalable API, Web, Native Devices, etc. testing.
This is a non-proprietary framework and is free to use.
I have extensively used this framework at my previous company where it was integrated with eTAF framework for both API and UI testing.

### Pre-requisites
1) Import the project in eclipse (Maven Project)
2) Java 11 (minimum version required)
3) TestNG Plugin in Eclipse
4) Selenium Stand alone required.

### Steps;
```
mvn clean install
```

### To Run suites or tests
1) API Test (/api/brfunnelorch/v2/resume/byLeadSecret)
Suite level: code-challenge\src\test\resources\testng_suites\api.xml --> Run As TestNG
OR
code-challenge\src\test\java\com\upgrade\challenge\BRFunnelOrchAPITest.java --> Run As TestNG

2) Web Tests (Personal Loans flow at https://www.credify.tech/phone/nonDMFunnel)
code-challenge\src\test\resources\testng_suites\web.xml --> Run As TestNG
OR
code-challenge\src\test\java\com\upgrade\challenge\NonDMFunnelTest.java
