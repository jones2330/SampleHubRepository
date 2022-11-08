@SelectHotel
Feature: Verifying Adactin Search Hotel Information Details
@PositiveTest
  Scenario Outline: Verifying Navigation Of Adactin Select hotel Page by selecting Hotel
    Given User is on Adactin Login Page
    When User should perform Login "<username>","<password>"
    Then User should verify Login Successful Message "Hello Jones2330!"
    And User should Search hotel by selecting "<Location>","<Hotels>","<RoomType>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>","<AdultsperRoom>" and "<ChildrenperRoom>"
    Then User should verify page navigate from Search Hotel to "Select Hotel"
    And User should select the Hotel Name and click Continue
    Then User should verify page navigate from Select Hotel to "Book A Hotel"

    Examples: 
      | username  | password | Location | Hotels      | RoomType | NumberofRooms | CheckInDate | CheckOutDate | AdultsperRoom | ChildrenperRoom |
      | Jones2330 | 81SECX   | Sydney   | Hotel Creek | Double   | 2 - Two       | 31/08/2022  | 01/09/2022   | 2 - Two       | 0 - None        |
@NegativeTest
  Scenario Outline: Verifying Navigation Of Adactin Select hotel page without selecting Hotel
    Given User is on Adactin Login Page
    When User should perform Login "<username>","<password>"
    Then User should verify Login Successful Message "Hello Jones2330!"
    And User should Search hotel by selecting "<Location>","<Hotels>","<RoomType>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>","<AdultsperRoom>" and "<ChildrenperRoom>"
    Then User should verify page navigate from Search Hotel to "Select Hotel"
    And User should click Continue without Selecting Hotel
    Then User should verify the Error Message in Search Hotel page "Please Select a Hotel"

    Examples: 
      | username  | password | Location | Hotels      | RoomType | NumberofRooms | CheckInDate | CheckOutDate | AdultsperRoom | ChildrenperRoom |
      | Jones2330 | 81SECX   | Sydney   | Hotel Creek | Double   | 2 - Two       | 31/08/2022  | 01/09/2022   | 2 - Two       | 0 - None        |
