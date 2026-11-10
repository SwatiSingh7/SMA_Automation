@fccReductionBayAmPm @regression
Feature: Verify Pre-Opening Clearance Bay Checks and Store Close Clearance Bay Checks in Fresh Code Check


  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |

  @sma
  Scenario Outline: UAT_01Verify new menu is added in list 'Fresh Code Check'
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    And I verify "<Menu>" page

    Examples:
      | Menu             |
      | Fresh Code Check |

  @sma
  Scenario Outline: UAT_02Verify Submenu list and status in 'Fresh Code Check'
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    And I verify "<Menu>" page
    Then I click on "<Menu>"
    And I verify "<Submenu1>" is displayed
    And I verify "<Submenu2>" is displayed
    And I verify "<Submenu3>" is displayed
    And I verify "<Submenu4>" is displayed
    And I verify "<Submenu5>" is displayed
    And I verify "<Submenu1>" status
    And I verify "<Submenu2>" status
    And I verify "<Submenu3>" status
    And I verify "<Submenu4>" status

    Examples:
      | Menu             | Submenu1    | Submenu2                         | Submenu3       | Submenu4                         | Submenu5                   |
      | Fresh Code Check | Code Alerts | Pre-Opening Clearance Bay Checks | Daily Schedule | Store Close Clearance Bay Checks | Manager Summary & Sign Off |


  @sma
  Scenario Outline: UAT_03Verify 	Pre-Opening Clearance Bay Checks header,label and Scren message text
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Screen message displayed

    Examples:
      | Menu             | Department_Menu                  |
      | Fresh Code Check | Pre-Opening Clearance Bay Checks |

  @sma
  Scenario Outline: UAT_04Verify  Pre-Opening Clearance Bay Checks status will get updated to 'Completed' when 'Confirm Reduction Bay Check' button clicked
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Button "<Button>"
    And I click Continue
    And I verify Reduction Bay AM status as "<Status>"
    Then I click on "<Department_Menu>"
    And I click on Button "<Button1>"
    And I click Continue


    Examples:
      | Menu             | Department_Menu                  | Button                      | Status    | Button1                     |
		     ######## |Fresh Code Check|Pre-Opening Clearance Bay Checks|CONFIRM CLEARANCE BAY CHECK	|Completed|RE-OPEN CLEARANCE BAY CHECK|
      | Fresh Code Check | Pre-Opening Clearance Bay Checks | CONFIRM CLEARANCE BAY CHECK | COMPLETED | RE-OPEN CLEARANCE BAY CHECK |


  @sma
  Scenario Outline:UAT_05 Verify Pre-Opening Clearance Bay Checks screen when user  perform 'Wastage' action and select expiry date as past date.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next <dateRange> th date
    Then I click on Done Button
    And I capture product details
    And I click Log Product
    Then Verify Select Reason Code template
	##Then Verify Select Reason Code as Waste Out of date
    And I select "<WastageReason>" and Confirm
    And I verify my product displayed in view list

    Examples:
      | Menu             | Department_Menu                  | MIN       | action  | quantity | dateRange | WastageReason       | Button                      |
      | Fresh Code Check | Pre-Opening Clearance Bay Checks | 105236511 | Wastage | 1        | -2        | Waste - Out of Date | RE-OPEN REDUCTION BAY CHECK |

#
#  @sma
#  Scenario Outline:UAT_06Verify Pre-Opening Clearance Bay Checks across FCC landing page status 'In Progress' after adding one product
#
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on "<Menu>"
#    And I verify Reduction Bay AM status as "<Status>"
#
#    Examples:
#      | Menu             | Department_Menu                  | Status      |
#      | Fresh Code Check | Pre-Opening Clearance Bay Checks | IN PROGRESS |
#
#  @sma
#  Scenario Outline: UAT_07 Verify  Pre-Opening Clearance Bay Checks screen when user  perform 'Wastage' action and select expiry date as future date.
#
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I click on spinner to select one of the action "<action>"
#    And I enter markdown "<quantity>" for the product
#    And I click on Calendar
#    Then I select next <dateRange> th date
#    Then I click on Done Button
#    And I capture product details
#    And I click Log Product
#    Then Verify Select Reason Code template
#	##Then Verify Select Reason Code as Waste Damaged Fruit & Veg Quality or Condition, Waste Out of date ,Waste Charity
#    And I select "<WastageReason>" and Confirm
#    And I verify my product displayed in view list
#
#    Examples:
#      | Menu             | Department_Menu                  | MIN       | action  | quantity | dateRange | WastageReason       |
#      | Fresh Code Check | Pre-Opening Clearance Bay Checks | 105236511 | Wastage | 1        | 1         | Waste - Out of Date |
#
#
##  @sma
##  Scenario Outline: UAT_08 Verify Pre-Opening Clearance Bay Checks screen when user  perform 'Markdown' action and select expiry date as future date.
##
##    When I enter Username and Password for SMA Collegue user
##    And I click on login button for SMA
##    Then I click on "<Menu>"
##    Then I click on "<Department_Menu>"
##    And I click on barcode entry Button
##    Then Enter "<MIN>" number
##    And I click on spinner to select one of the action "<action>"
##    And I enter markdown "<quantity>" for the product
##    And I click on Calendar
##    Then I select next <dateRange> th date
##    Then I click on Done Button
##    And I capture product details
##    And I click Log Product
##    Then I click on No Printer Available
##    Then I click on Add to Print Queuee
##    And I verify my product displayed in view list
##
###  107665601 not part of fresh product
###  105236511 product not found
##    Examples:
##      | Menu             | Department_Menu                  | MIN       | action   | quantity | dateRange |
##      | Fresh Code Check | Pre-Opening Clearance Bay Checks | 107665601 | Markdown | 1        | 1         |
#
#
#  @timeChange
#  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
#    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
#    Then I Change time
#    Then I Change date
#
#    Examples:
#      | Hours | Mins | Meridiem |
#      | 12    | 15   | pm       |
#
#
#  @sma
#  Scenario Outline:UAT_09 Verify when a user clicks on Pre-Opening Clearance Bay Checks after defined time window, then below 'prompt' will appear and click 'Cancel'
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I verify Popup message displayed
#    And I click Cancel
#
#    Examples:
#      | Menu             | Department_Menu                  |
#      | Fresh Code Check | Pre-Opening Clearance Bay Checks |
#
#
#  @sma
#  Scenario Outline:UAT_10 Verify whether status is displayed as 'Completed' on Fresh Code check submenu screen  for  Pre-Opening Clearance Bay Checks after click on Confirm Reduction bay Check Button
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I verify Popup message displayed
#    And I click Continue
#    And I verify my product displayed in view list
#    And I click on Button "<Button>"
#    And I click Continue
#    And I verify Reduction Bay AM status as "<Status>"
#
#
#    Examples:
#      | Menu             | Department_Menu                  | Button                      | Status    |
#	   ##########  |Fresh Code Check|Pre-Opening Clearance Bay Checks|CONFIRM CLEARANCE BAY CHECK|Completed|
#      | Fresh Code Check | Pre-Opening Clearance Bay Checks | CONFIRM CLEARANCE BAY CHECK | COMPLETED |
#
#  @sma
#  Scenario Outline:UAT_11 Verify when status is 'Completed', user is not allowed to scan and user to only View the submitted list and all the fields should be non editable
#
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on "<Menu>"
#    And I verify Reduction Bay AM status as "<Status>"
#    Then I click on "<Department_Menu>"
#    And I verify Popup message displayed
#    And I click Continue
#    And I verify Scanning not allowed
#    And I verify fields are not editable
#
#    Examples:
#      | Menu             | Department_Menu                  | Status    |
#	     ######## |Fresh Code Check|Pre-Opening Clearance Bay Checks|      Completed|
#      | Fresh Code Check | Pre-Opening Clearance Bay Checks | COMPLETED |
#
#
#  @sma
#  Scenario Outline:UAT_12 Verify when status is completed, User able to  'Reopen Reduction Bay Check'
#
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I verify Popup message displayed
#    And I click Continue
#    Then I reopen Reduction Bay Check
#    And I verify Reduction Bay AM status as "<Status>"
#
#    Examples:
#      | Menu             | Department_Menu                  | Status      |
#	      #######Fresh Code Check|Pre-Opening Clearance Bay Checks	|In Progress|
#      | Fresh Code Check | Pre-Opening Clearance Bay Checks | IN PROGRESS |
#
#
##  @sma
##  Scenario Outline: UAT_13 Verify after  Pre-Opening Clearance Bay Checks, user can performs delete operation on scanned items
##    When I enter Username and Password for SMA Collegue user
##    And I click on login button for SMA
##    Then I click on "<Menu>"
##    Then I click on "<Department_Menu>"
##    And I verify Popup message displayed
##    And I click Continue
##    And I verify my product displayed in view list
##    And I Delete products
##
##    Examples:
##      | Menu             | Department_Menu                  |
##      | Fresh Code Check | Pre-Opening Clearance Bay Checks |
#
#
#  @sma
#  Scenario Outline: UAT_14 verify when 'Ambient product' is scanned , prompt will appear and user remain on same department screen
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I verify Popup message displayed
#    And I click Continue
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I Confirm prompt for Ambient product
#    And I verify department screnn remain same
#
#    Examples:
#      | Menu             | Department_Menu                  | Status    | MIN       |
#      | Fresh Code Check | Pre-Opening Clearance Bay Checks | COMPLETED | 107665601 |



	  #########################################################################Reduction Bay Check- PM ###########################################################################33333333333333333
  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 02    | 00   | pm       |


  @sma
  Scenario Outline: UAT_15Verify 	Store Close Clearance Bay Checks header,label and Scren message text
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
	    #And I verify "<Department_Menu>" page
    And I verify Screen message displayed

    Examples:
      | Menu             | Department_Menu                  |
      | Fresh Code Check | Store Close Clearance Bay Checks |

  @sma
  Scenario Outline: UAT_16VerifyStore Close Clearance Bay Checks status will get updated to 'Completed' when 'Confirm Reduction Bay Check' button clicked
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Button "<Button>"
    And I click Continue
    And I verify Reduction Bay PM status as "<Status>"
    Then I click on "<Department_Menu>"
    And I click on Button "<Button1>"
    And I click Continue

    Examples:
      | Menu             | Department_Menu                  | Button                      | Status    | Button1                     |
	     #### |Fresh Code Check|Store Close Clearance Bay Checks|CONFIRM CLEARANCE BAY CHECK|Completed|RE-OPEN CLEARANCE BAY CHECK|
      | Fresh Code Check | Store Close Clearance Bay Checks | CONFIRM CLEARANCE BAY CHECK | COMPLETED | RE-OPEN CLEARANCE BAY CHECK |
#
#
  @sma
  Scenario Outline:UAT_17 Verify Store Close Clearance Bay Checks screen when user  perform 'Wastage' action and select expiry date as past date.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next <dateRange> th date
    Then I click on Done Button
    And I capture product details
    And I click Log Product
    Then Verify Select Reason Code template
	    #######Then Verify Select Reason Code as Waste Out of date
    And I select "<WastageReason>" and Confirm
    And I verify my product displayed in view list



    Examples:
      | Menu             | Department_Menu                  | MIN       | action  | quantity | dateRange | WastageReason       | Button                      |
	     ##### |Fresh Code Check|Store Close Clearance Bay Checks|110950613|		Wastage		|1|		-2|Waste Out of Date|RE-OPEN REDUCTION BAY CHECK|
      | Fresh Code Check | Store Close Clearance Bay Checks | 110950613 | Wastage | 1        | -2        | Waste - Out of Date | RE-OPEN REDUCTION BAY CHECK |


  @sma
  Scenario Outline:UAT_18 Verify Store Close Clearance Bay Checks across FCC landing page status 'In Progress' after adding one product

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify Reduction Bay PM status as "<Status>"


    Examples:
      | Menu             | Department_Menu                  | Status      |
      | Fresh Code Check | Store Close Clearance Bay Checks | IN PROGRESS |

  @sma
  Scenario Outline: UAT_19 Verify Store Close Clearance Bay Checks screen when user  perform 'Wastage' action and select expiry date as future date.

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next <dateRange> th date
    Then I click on Done Button
    And I capture product details
    And I click Log Product
    Then Verify Select Reason Code template
	####Then Verify Select Reason Code as Waste Damaged Fruit & Veg Quality or Condition, Waste Out of date ,Waste Charity
    And I select "<WastageReason>" and Confirm
    And I verify my product displayed in view list



    Examples:
      | Menu             | Department_Menu                  | MIN       | action  | quantity | dateRange | WastageReason       |
	      ####|Fresh Code Check|Store Close Clearance Bay Checks|110950613|		Wastage		|1|		1|Waste Out of Date|
      | Fresh Code Check | Store Close Clearance Bay Checks | 110950613 | Wastage | 1        | 1         | Waste - Out of Date |


#  @sma
#  Scenario Outline: UAT_20 Verify Store Close Clearance Bay Checks screen when user  perform 'Markdown' action and select expiry date as future date.
#    product not found
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I click on spinner to select one of the action "<action>"
#    And I enter markdown "<quantity>" for the product
#    And I click on Calendar
#    Then I select next <dateRange> th date
#    Then I click on Done Button
#    And I capture product details
#    And I click Log Product
#    Then I click on No Printer Available
#    Then I click on Add to Print Queuee
#    And I verify my product displayed in view list
#
#
#    Examples:
#      | Menu             | Department_Menu                  | MIN       | action   | quantity | dateRange |
#      | Fresh Code Check | Store Close Clearance Bay Checks | 111102341 | Markdown | 1        | 1         |

#
  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 11    | 05   | am       |


  @sma
  Scenario Outline:UAT_21 Verify when a user clicks on Store Close Clearance Bay Checks after defined time window, then below 'prompt' will appear and click 'Cancel'
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Popup message displayed for PM check
    And I click Cancel

    Examples:
      | Menu             | Department_Menu                  |
      | Fresh Code Check | Store Close Clearance Bay Checks |


  @sma
  Scenario Outline:UAT_22 Verify whether status is displayed as 'Completed' on Fresh Code check submenu screen  forStore Close Clearance Bay Checks after click on Confirm Reduction bay Check Button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Popup message displayed for PM check
    And I click Continue
    And I verify my product displayed in view list
    And I click on Button "<Button>"
    And I click Continue
    And I verify Reduction Bay PM status as "<Status>"


    Examples:
      | Menu             | Department_Menu                  | Button                      | Status    |
	     ###|Fresh Code Check|Store Close Clearance Bay Checks|CONFIRM CLEARANCE BAY CHECK	|Completed|
      | Fresh Code Check | Store Close Clearance Bay Checks | CONFIRM CLEARANCE BAY CHECK | COMPLETED |
#
  @sma
  Scenario Outline:UAT_23 Verify when status is 'Completed', user is not allowed to scan and user to only View the submitted list and all the fields should be non editable

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify Reduction Bay PM status as "<Status>"
    Then I click on "<Department_Menu>"
    And I verify Popup message displayed for PM check
    And I click Continue
    And I verify Scanning not allowed
    And I verify fields are not editable

    Examples:
      | Menu             | Department_Menu                  | Status    |
	     ######### |Fresh Code Check|Store Close Clearance Bay Checks|      Completed|
      | Fresh Code Check | Store Close Clearance Bay Checks | COMPLETED |


  @sma
  Scenario Outline:UAT_24 Verify when status is completed, User able to  'Reopen Reduction Bay Check'

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Popup message displayed for PM check
    And I click Continue
    Then I reopen Reduction Bay Check
    And I verify Reduction Bay PM status as "<Status>"

    Examples:
      | Menu             | Department_Menu                  | Status      |
	    ###  |Fresh Code Check|Store Close Clearance Bay Checks	|In Progress|
      | Fresh Code Check | Store Close Clearance Bay Checks | IN PROGRESS |

#  @sma
#  Scenario Outline: UAT_25 Verify after reopening Store Close Clearance Bay Checks, user can performs delete operation on scanned items
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I verify Popup message displayed for PM check
#    And I click Continue
#    And I verify my product displayed in view list
#    And I Delete products
#
#    Examples:
#      | Menu             | Department_Menu                  |
#      | Fresh Code Check | Store Close Clearance Bay Checks |


  @sma
  Scenario Outline: UAT_26 verify when 'Ambient product' is scanned , prompt will appear and user remain on same department screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Popup message displayed for PM check
    And I click Continue
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I Confirm prompt for Ambient product
    And I verify department screnn remain same

    Examples:
      | Menu             | Department_Menu                  | MIN       |
      | Fresh Code Check | Store Close Clearance Bay Checks | 107665601 |

