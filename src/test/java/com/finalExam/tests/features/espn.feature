@webAutomation

  Feature: ESPN performance test
    You can log in to the ESPN page and navigate successfully

  Background:
    Given You are in the ESPN home page

    @webAutomation @logIn @checkItems @espn
      Scenario: Check the log in items
      Given You are in the log in modal
      Then the log in items are visible in the modal

      @webAutomation @signUp @checkItems @espn
        Scenario: Check sign up items
        Given You are in the log in modal
        When You can see and click on the sign up button
        Then each element for the sign up process should be visible

        @webAutomation @signUpProcess @espn
          Scenario: Create an account
          Given You are in the log in modal
          When You can click on the sign up button
          And You can type your personal information to sign up
          Then you should be logged in correctly

          @webAutomation @watchPage @LogInProcess @checkItems @espn
            Scenario: Navigate to espn watch page
            Given You are logged
            When You can go to the espn watch page
            Then The page items should be correctly visible
            And You should to come back to espn home page

            @webAutomation @welcomeText @LogInProcess @checkItems @espn
              Scenario: Check Welcome text when you are logged
              Given You can logged
              When You can log out
              Then The welcome text is visible with the user name