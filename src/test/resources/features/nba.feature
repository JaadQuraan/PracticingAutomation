Feature: NBA Website
@nba
  Scenario: User goes to NBA site and gets current date
    Given user is on NBA page
    Then user gets the current date from dropdown
@nbaNav
  Scenario: Go to NBA site and validate left navigation menu
    Given user is on NBA page
    And user validates these items
      | Games             |
      | Schedule          |
      | Watch             |
      | News              |
      | Stats             |
      | Standings         |
      | Teams             |
      | Players           |
      | NBA Play          |
      | Future Starts Now |
      | NBA Fitness       |
      | Fantasy           |
      | NBABet            |
      | League Pass       |
      | Store             |