Feature: Login
  Scenario:Register user
    Given user launched application
    When user verify Home Page
    When user navigate to register page
    When user Register in application


  Scenario:Login and logout user
    Given user launched application
    When user verify Home Page
    When user navigate to login page
    When user login in application
    When user navigate to mac
    When user add MAC to cart
    Then verify success message
    When user got to cart
    Then verify item name in cart

#  Scenario:Add Checkout MAC
#    Given user launched application
#    When user verify Home Page
#    When user navigate to register page
#    When user Register in application
#    When user navigate to mac
#    When user add MAC to cart
#    Then verify success message