Feature: BestBuy application
  As a user I want to test BestBuy Application

  Scenario Outline: CRUD Test
    When I create a new product by providing the information name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacturer "<manufacturer>" model "<model>" url "<url>" image "<image>"
    Then I verify that the product with "<name>" is created
    And I update the product with information name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacturer "<manufacturer>" model "<model>" url "<url>" image "<image>"
    And I delete the product that created with name "<name>"
    Then The product deleted successfully from the list

    Examples:
      | name                              | type     | price | shipping | upc          | description | manufacturer | model     | url                                                                                                      | image                                                                 |
      | Duracell - AAA Batteries (4-Pack) | HardGood | 5.49  | 0        | 041333424019 | 4-pack      | Duracell     | MN2400B4Z | http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC | http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg |
      | Duracell - AA Batteries (8-Pack)  | HardGood | 8.49  | 0        | 041216555435 | 8-pack      | Duracell     | TN8400B8Z | http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC | http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg |

