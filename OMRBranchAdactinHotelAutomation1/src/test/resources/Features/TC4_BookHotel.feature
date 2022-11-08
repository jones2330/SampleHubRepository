@BookConfirm
Feature: Verifying Adactin Booking Confirmation Details
@PositiveTest
  Scenario Outline: Verifying Adactin Booking Confirmation Page by selecting all fields
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
      | 2134587699876453 | Master Card      | January     |       2022 |   2332 |
      | 2134587699876453 | Other            | December    |       2022 |   2333 |
    Then User should verify page navigate from Book A hotel to "Booking Confirmation"

    Examples: 
      | username  | password | Location | Hotels      | RoomType | NumberofRooms | CheckInDate | CheckOutDate | AdultsperRoom | ChildrenperRoom | FirstName | LastName | BillingAddress        |
      | Jones2330 | 81SECX   | Sydney   | Hotel Creek | Double   | 2 - Two       | 31/08/2022  | 01/09/2022   | 2 - Two       | 0 - None        | Jones     | Johnson  | 21/50 main road,Erode |
@NegativeTest
  Scenario Outline: Verifying Adactin Booking Confirmation Page without Entering any details
    Given User is on Adactin Login Page
    When User should perform Login "<username>","<password>"
    Then User should verify Login Successful Message "Hello Jones2330!"
    And User should Search hotel by selecting "<Location>","<Hotels>","<RoomType>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>","<AdultsperRoom>" and "<ChildrenperRoom>"
    Then User should verify page navigate from Search Hotel to "Select Hotel"
    And User should select the Hotel Name and click Continue
    Then User should verify page navigate from Select Hotel to "Book A Hotel"
    And User should click Book Now without Entering any details
    Then User should verify all Error Messages "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | username  | password | Location | Hotels      | RoomType | NumberofRooms | CheckInDate | CheckOutDate | AdultsperRoom | ChildrenperRoom |
      | Jones2330 | 81SECX   | Sydney   | Hotel Creek | Double   | 2 - Two       | 31/08/2022  | 01/09/2022   | 2 - Two       | 0 - None        |
