Feature: Login automation test cases
Scenario Outline: Login with valid credentials
Given Consider user is in login page
When User enter "<username>" and "<password>"
And Click on login button
Then User is navigate to home page
And Close browser

Examples:
| username | password |
| standard_user | secret_sauce |

