
@tag course

Feature: Course Management - Study Materials
Background: 
Given User Launches the application 
When User mouseover Study material dropdown

  Scenario: User should Access appropriate NEET content in Study Materials Dropdown
   
   
    And User selects NEET from dropdown
    Then User validates the NEET content
  
   Scenario: User should Access appropriate JEE content in Study Materials Dropdown
    
   
    And User selects JEE from dropdown
    Then User validates the JEE content  
    
    Scenario: User should Access appropriate Commerce content in Study Materials Dropdown
   
   
    And User selects commerce from dropdown
    Then User validates the commerce content  

