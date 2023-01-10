Feature: Testing different request on the bestbuy application

  Scenario: Check if the store listing can be accessed by users
    When User sends a GET request to list endpoint for store
    Then User must get back a valid status code 200 for successful store create

  Scenario Outline: Create a store listing & verify if the store is added
    When I create a new store by providing the information name "<name>" type "<type>" address "<address>" address2 "<address2>" city "<city>" state "<state>" zip "<zip>" lat "<lat>" lng "<lng>" hours "<hours>"
    Then I verify that the store with "<name>" is created
    Examples:
      | name          | type     | address               | address2 | city     | state   | zip    | lat       | lng        | hours                                                              |
      | Minnetonka    | BigBox   | 13213 Ridgedale Road  | 12       | New York | DC      | 553056 | 44.969658 | -93.449539 | Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9 |
      | London Dreams | SmallBox | 123456 Leftangle Road | 14       | London   | England | 123456 | 46.969658 | -99.449539 | Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9 |
