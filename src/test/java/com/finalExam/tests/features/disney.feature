@mobileAutomation
  Feature: Disney app review
    You can check the correct view of features to Disney app

  Background:
    Given You are in the dashboard screen

    @mobileAutomation @checkMenuView @menuView @disney
      Scenario: Checking menu view
      Given You are in the menu view
      Then Items in menu view are visible correctly

      @mobileAutomation @checkingAddPlansView @addPlans @disney
        Scenario: Check add plans view
        When You can select the add plans options
        Then Check dining availability options is visible