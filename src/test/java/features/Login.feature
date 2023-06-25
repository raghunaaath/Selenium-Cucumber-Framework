Feature: Login of Orange_HRM_Demo
  
  Scenario: Sucessfull Login with Correct userName and password
    Given I navigate to URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I enter userName "Admin",password "admin123" & Click on Login Button
    Then Login successful for OrangeHRM
    
    
  Scenario: Sucessfull Login with Incorrect userName and password
    Given I navigate to URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I enter userName "Adminn",password "admin1233" & Click on Login Button
    Then Login should be unsuccessful for OrangeHRM
