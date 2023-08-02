@search
Feature: Search product functionality

Scenario: search product with correct Product name

Given user is on any page
When user enter a product "HP" in search box
And user clicks on search button
Then product with name "HP LP3065"  should display
		
Scenario: search product with incorrect Product name

Given  user is on any page
When user enter a invalid product "Honda" in search box
And user clicks on search button
Then 	user should get proper message "There is no product that matches the search criteria." should displayed


		
		