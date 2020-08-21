Feature: Search of various product categories should be possible along with product search

It is good to provide an option to our end users where they can search for the products
based on their category, rather than only searching a product.This will increase our 
business and make end users happy. 

Background: Visiting the website as a guest user
Given I visit the website as a guest user

Scenario: User should be able to search for the products under books categary
When I select the books option from the Search dropdown
And I click on search icon option
Then I should see the page having heading as Amazon Best Reads is getting displayed
But I should not see the other category products


Scenario: User should be able to search for the products under baby category
When I select the baby option from the Search dropdown
And I click on search icon option
Then I should see the page having heading as Offers on Baby products is getting displayed
But I should not see the other category products

