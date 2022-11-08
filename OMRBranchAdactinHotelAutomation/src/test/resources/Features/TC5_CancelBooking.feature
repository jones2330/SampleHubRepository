@CancelBooking
Feature: Verifying Adactin Cancel Booking
@PositiveTest
  Scenario Outline: Verifying Adactin Cancel Booking page by cancelling the current Booking
    Given User is on Adactin Login Page
    When User should perform Login "<username>","<password>"
    Then User should verify Login Successful Message "Hello Jones2330!"
    And User should Search hotel by selecting "<Location>","<Hotels>","<RoomType>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>","<AdultsperRoom>" and "<ChildrenperRoom>"
    Then User should verify page navigate from Search Hotel to "Select Hotel"
    And User should select the Hotel Name and click Continue
    Then User should verify page navigate from Select Hotel to "Book A Hotel"
    And User should Book Hotel by entering all fields "<FirstName>","<LastName>" and "<BillingAddress>"
      | CreditCardNo     | CreditCardType   | Expirymonth | ExpiryYear | CVVNum |
      | 1234567899876543 | American Express | January     |       2022 |   2330 |
      | 2134587699876453 | VISA             | October     |       2022 |   2331 |
      | 2134587699876453 | Master Card      | November    |       2022 |   2332 |
      | 2134587699876453 | Other            | December    |       2022 |   2333 |
    Then User should verify page navigate from Book A hotel to "Booking Confirmation"
    And User should Cancel Booking with current orderID
    Then User should verify Cancel Success Message "The booking has been cancelled."

    Examples: 
      | username  | password | Location | Hotels      | RoomType | NumberofRooms | CheckInDate | CheckOutDate | AdultsperRoom | ChildrenperRoom | FirstName | LastName | BillingAddress        |
      | Jones2330 | 81SECX   | Sydney   | Hotel Creek | Double   | 2 - Two       | 31/08/2022  | 01/09/2022   | 2 - Two       | 0 - None        | Jones     | Johnson  | 21/50 main road,Erode |
@PositiveTest
  Scenario Outline: Verifying Adactin Cancel Booking page by cancelling existing Booking
    Given User is on Adactin Login Page
    When User should perform Login "<username>","<password>"
    Then User should verify Login Successful Message "Hello Jones2330!"
    And User should Cancel Booking with existing orderID "<OrderID>"
    Then User should verify Cancel Success Message "The booking has been cancelled."

    Examples: 
      | username  | password | OrderID    |
      | Jones2330 | 81SECX   | UFQ49IT6J3 |
