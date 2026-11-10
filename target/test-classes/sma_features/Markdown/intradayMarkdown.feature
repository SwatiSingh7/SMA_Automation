@markdown
Feature: Intraday Markdown Scenarios

  #
  @sma
  Scenario Outline: SMA_IntradayMarkdownScenario1 To verify that if the store is not configured in the configuration service it should be access through BY V2 API
  and optimised price value should match in Markdown Get API.

    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>" before scanning a products
    And Get Operation perform on Markdown service request
    Then Get markdown details service response before scanning the product
    Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Blueyonder service request
    Then Get Blueyonder Details service response
    And verify that Blueyonder price value matches with optimised price value in Markdown Get API for not configured stores

    Examples:
      | storeId | Department    | category      | productId |
      | 3       | Market Street | Market Street | 108384771 |


  @sma
  Scenario Outline: SMA_IntradayMarkdownScenario4 To verify optimised price value under unprinted list array in Markdown Get API is matching with BY V2 API response when a colleague user has performed Markdown from UI for non configured store.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>" before scanning a products
    And Get Operation perform on Markdown service request
    Then Get markdown details service response before scanning the product
    Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Blueyonder service request
    Then Get Blueyonder Details service response
    And verify that Blueyonder price value matches with optimised price value in Markdown Get API for not configured stores

    Examples:
      | storeId | Department    | category      | productId |
      | 3       | Market Street | Market Street | 108384771 |

  @sma
  Scenario Outline: SMA_IntradayMarkdownScenario5 To verify optimised price value under unprinted list array in Markdown Get API is matching with BY V2 API response when a Manager User has performed Markdown from UI without overriding BY optimised price.
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>" before scanning a products
    And Get Operation perform on Markdown service request
    Then Get markdown details service response before scanning the product
    Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Blueyonder service request
    Then Get Blueyonder Details service response
    And verify that Blueyonder price value matches with optimised price value in Markdown Get API for not configured stores

    Examples:
      | storeId | Department    | category      | productId |
      | 3       | Market Street | Market Street | 108384771 |

  @sma
  Scenario Outline: SMA_IntradayMarkdownScenario6 To verify optimised price value is matching from BY V2 API response when user is performing markdown before first markdown window.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>" before scanning a products
    And Get Operation perform on Markdown service request
    Then Get markdown details service response before scanning the product
    Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Blueyonder service request
    Then Get Blueyonder Details service response
    And verify that Blueyonder price value matches with optimised price value in Markdown Get API for not configured stores

    Examples:
      | storeId | Department    | category      | productId |
      | 3       | Market Street | Market Street | 108384771 |

  @sma
  Scenario Outline: SMA_IntradayMarkdownScenario7 To verify optimised price value is matching from BY V2 API response when user is performing markdown after first markdown window.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>" before scanning a products
    And Get Operation perform on Markdown service request
    Then Get markdown details service response before scanning the product
    Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Blueyonder service request
    Then Get Blueyonder Details service response
    And verify that Blueyonder price value matches with optimised price value in Markdown Get API for not configured stores

    Examples:
      | storeId | Department    | category      | productId |
      | 3       | Market Street | Market Street | 108384771 |


  @sma
  Scenario Outline: SMA_IntradayMarkdownScenario8 To verify Optimised price value in Markdown Get API is shown 404 Not found when BY V2 API response is 404.

    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>" before scanning a products
    And Get Operation perform on Markdown service request
    Then Get markdown details service response before scanning the product
    Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Blueyonder service request
    Then Get Blueyonder Details service response for item that do not have price
    And verify Optimised price value in Markdown Get API is shown Price Not found when BY V2 API response is price not found

    Examples:
      | storeId | Department | category   | productId |
      | 3       | Fresh Food | Fresh Food | 104896219 |

  @sma
  Scenario Outline: SMA_IntradayMarkdownScenario9 To verify Markdown price is shown between the default markdown percentage when BY V2 API response is 404 Not Found.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>" before scanning a products
    And Get Operation perform on Markdown service request
    Then Get markdown details service response before scanning the product
    Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Blueyonder service request
    Then Get Blueyonder Details service response for item that do not have price
    And verify Optimised price value in Markdown Get API is shown Price Not found when BY V2 API response is price not found

    Examples:
      | storeId | Department | category   | productId |
      | 3       | Fresh Food | Fresh Food | 104896219 |


  @sma
  Scenario Outline: SMA_IntradayMarkdownScenario12 To verify optimised price value is matching from BY V2 API response when user is performing markdown for a product which will get expire on day after tomorrow as tomorrow store is closed.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response before scanning the product
    Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Blueyonder service request
    Then Get Blueyonder Details service response
    And verify that Blueyonder price value matches with optimised price value in Markdown Get API for not configured stores

    Examples:
      | storeId | Department    | category      | productId |
      | 3       | Market Street | Market Street | 108384771 |
