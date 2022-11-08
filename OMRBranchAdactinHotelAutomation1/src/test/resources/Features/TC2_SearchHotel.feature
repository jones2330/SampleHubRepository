@SearchHotel
Feature: Verifying Adactin Search Hotel Information Details
@PositiveTest
  Scenario Outline: Verifying Navigation Of Adactin Search hotel Page by selecting all fields
    Given User is on Adactin Login Page
    When User should perform Login "<username>","<password>"
    Then User should verify Login Successful Message "Hello Jones2330!"
    And User should Search hotel by selecting "<Location>","<Hotels>","<RoomType>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>","<AdultsperRoom>" and "<ChildrenperRoom>"
    Then User should verify page navigate from Search Hotel to "Select Hotel"

    Examples: 
      | username  | password | Location | Hotels      | RoomType | NumberofRooms | CheckInDate | CheckOutDate | AdultsperRoom | ChildrenperRoom |
      | Jones2330 | 81SECX   | Sydney   | Hotel Creek | Double   | 2 - Two       | 31/08/2022  | 01/09/2022   | 2 - Two       | 0 - None        |
@PositiveTest
  Scenario Outline: Verifying Navigation Of Adactin Search hotel Page by selecting only Mandatory fields
    Given User is on Adactin Login Page
    When User should perform Login "<username>","<password>"
    Then User should verify Login Successful Message "Hello Jones2330!"
    And User should Search hotel by selecting only Mandatory fields "<Location>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>" and "<AdultsperRoom>"
    Then User should verify page navigate from Search Hotel to "Select Hotel"

    Examples: 
      | username  | password | Location | NumberofRooms | CheckInDate | CheckOutDate | AdultsperRoom |
      | Jones2330 | 81SECX   | Sydney   | 2 - Two       | 31/08/2022  | 01/09/2022   | 2 - Two       |
@NegativeTest
  Scenario Outline: Verifying Adactin Search hotel Page by Entering Invalid Date information
    Given User is on Adactin Login Page
    When User should perform Login "<username>","<password>"
    Then User should verify Login Successful Message "Hello Jones2330!"
    And User should Search hotel by selecting "<Location>","<Hotels>","<RoomType>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>","<AdultsperRoom>" and "<ChildrenperRoom>"
    Then User should verify the Error Message "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | username  | password | Location | Hotels      | RoomType | NumberofRooms | CheckInDate | CheckOutDate | AdultsperRoom | ChildrenperRoom |
      | Jones2330 | 81SECX   | Sydney   | Hotel Creek | Double   | 2 - Two       | 31/08/2023  | 01/09/2022   | 2 - Two       | 0 - None        |
@NegativeTest
  Scenario Outline: Verifying Navigation of Adactin Search hotel Page without selecting Hotel information
    Given User is on Adactin Login Page
    When User should perform Login "<username>","<password>"
    Then User should verify Login Successful Message "Hello Jones2330!"
    And User should Search hotel without selecting hotel information
    Then User should verify the Error Message "Please Select a Location"

    Examples: 
      | username  | password |
      | Jones2330 | 81SECX   |
