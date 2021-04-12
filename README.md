**          ANZ Repayment Calculator Testing**

**Overview**
A very user friendly tool that lets the user enter in their Loan Amount, Interest Rate, and amount of years they need to pay it off, then calculates the monthly repayment amount. Also gives you a slider option to increase / decrease (or manually enter in specific monthly repayment amounts), then displays the potential interest saved and the amount of time it will take to pay off accordingly.

**Tests**
The tests simply follow the user journey through the calculator, simulating amounts that a user would likely enter, and calculates. To me, this is what automation testing is all about, to simply act on behalf of the user.

The tests are written in Java, using Selenium Webdriver.

I've made sure my scripts were mininimal, simple and easy to understand (modify) by putting any repetitive actions or lengthy webdriver navigations into seperate methods in an abstact class.  

Within the tests, a user can simply parse in any different amount (eg loan ammount, year ammount) if a more specific test is required, and each test is ended with an assertion.
