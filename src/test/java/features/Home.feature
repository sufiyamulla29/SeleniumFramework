@parallelExe
Feature: to automate the internet herokuapp

Scenario: to verify links present on homepage
Given "chrome" browser is selected
Then launch url "https://the-internet.herokuapp.com/"
And verify page by url "https://the-internet.herokuapp.com/"
Then click on "A/B Testing"
And verify page by url "https://the-internet.herokuapp.com/abtest"
Then navigate back to home page
And verify page by url "https://the-internet.herokuapp.com/"


Scenario: to verify links present on homepage
Given "chrome" browser is selected
Then launch url "https://the-internet.herokuapp.com/"
And verify page by url "https://the-internet.herokuapp.com/"
Then click on "A/B Testing"
And verify page by url "https://the-internet.herokuapp.com/abtest"
Then navigate back to home page
And verify page by url "https://the-internet.herokuapp.com/"


