**          ANZ Repayment Calculator Testing**

**Overview**
A very user-friendly tool that lets the user enter in their Loan Amount, Interest Rate, and amount of years they need to pay it off, then calculates the monthly repayment amount. Also gives you a slider option to increase / decrease (or manually enter in specific monthly repayment amounts), then displays the potential interest saved and the amount of time it will take to pay off accordingly.

**Tests**
The tests simply follow the user journey through the calculator, simulating amounts that a user would likely enter, and calculates. To me, this is what automation testing is all about, to simply act on behalf of the user.

The tests are written in Java, using Selenium WebDriver.

I've made sure my scripts were minimal, simple and easy to understand (modify) by putting any repetitive actions or lengthy WebDriver navigations into separate methods in an abstract class.  

I also chose to run my tests under different bandwidths to simulate how websites might perform when under load. This allowed me to identify an issue in my Interest Slider test, which would not recognize a particular element if the site is running slow. I then updated my code to be more stable and resilient to these sorts of conditions.

Within the tests, a user can simply parse in any different amount (eg loan amount, year amount) if a more specific test is required.

All tests end with assertions, and any failed assertions will be screenshotted and stored with a custom file name (that of the particular test that failed)

Reports will also be created for each test, stating whether the tests passed or failed (see below examples)

**Test 1**
Ensures the Short Term loan functionality is working correctly

**Test 2**
Ensures the Long Term loan functionality is working correctly

**Test 3**
Ensures the Loan Interest Repayment Slider functionality is working correctly

**Failed Report**
![image](https://user-images.githubusercontent.com/20526337/114341842-c2d0a300-9bae-11eb-99db-6e2daf2a6215.png)

**Screenshot of Failed Report**
![image](https://user-images.githubusercontent.com/20526337/114341916-f6133200-9bae-11eb-8388-5fc836dc0aa4.png)

**Passed Report**
![image](https://user-images.githubusercontent.com/20526337/114341979-17741e00-9baf-11eb-81f4-25caa585dbd3.png)



