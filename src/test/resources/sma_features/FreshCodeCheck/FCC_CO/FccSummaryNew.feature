@NewfccSummary @regression
Feature: Verify Fresh Food Manager Check Summary & Sign Off Screen (Phase2)

@sma
Scenario Outline: UAT_19Verify Current Day 'Fresh Food Manager Check' Summary & Sign Off Page 

	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I select current day date 
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Total wastage, wastage amount in pound is displayed
	And I verify Escalations and below text is displayed
	And I verify "<Link>" is displayed
	And I verify "<Link1>" is displayed
	And I verify department name,wastage qty and amount is displayed
	
	
Examples:   
 | Menu | 			Department_Menu |	SubMenu|					Location| 				Link|					Link1|
 |Fresh Code Check|Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off|Fresh code check completion|Out of Code - Daily Checks (Waste)|
 
@sma
Scenario Outline: UAT_20Verify 'Overdue' status for past date  'Fresh Food Manager Check' Summary & Sign Off Page 
 
 	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
    And I verify status as "<Status>"
 
 	
Examples:   
 | Menu | 			Department_Menu |		SubMenu|			Location| 	Status| daterange|
 |Fresh Code Check|Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off|	Overdue|3|
 
 
 @sma
 Scenario Outline: UAT_21Verify 'Awaiting Sign-Off/Inprogress' status for Current Day 'Fresh Food Manager Check' Summary & Sign Off Page 

	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	 Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
    And I select current day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
    And I verify status as "<Status>"
 
 	
Examples:   
 | Menu | 			Department_Menu |		SubMenu|			Location| 	Status|
 |Fresh Code Check|Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off|In Progress|
 
 
 @sma
 Scenario Outline: UAT_22Verify 'Total Wastage' Amount in '£' Pounds for yesterday date in 'Fresh Food Manager Check' Summary & Sign Off Page 
 	
 	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	 Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
 	And I verify Total wastage, wastage amount in pound is displayed
 	
 	
Examples:   
 | Menu | 			Department_Menu |		SubMenu|			Location| 	daterange|
 |Fresh Code Check|Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 2|
 
 
 
  @sma
 Scenario Outline: UAT_23Verify 'Escalations' raised yesterday date in 'Fresh Food Manager Check' Summary & Sign Off Page 
 	
 	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	  Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
    And I select current day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
 	And I verify Escalations and below text is displayed
	Then I click on "<VIEW>"
 	And I verify escalations listed with View/Incomplete
 			 	
 	
Examples:   
 | Menu | 			Department_Menu |		SubMenu|			Location| 	VIEW|
 |Fresh Code Check|Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| Escalations|
 

 @sma
 Scenario Outline: UAT_24Verify Manager 'Complete' escalations which as been done yesterday from Daily Checks and Afternoon Checks by completing the department with poor rotation rating   

	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	 Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
 	And I verify Escalations and below text is displayed
	Then I click on "<VIEW>"
	And I open "<Status>" status escalation
	And I verify Next steps Page Header
	And I verify Aisle Information
	And I verify Details of Problem Found
	Then I click on "<Button>"
	And I verify prompt for next step
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
 	
	Examples: 
		| Menu | 			Department_Menu |		SubMenu|			  Location| 		VIEW|	Status		|		Button|			 daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	Escalations    |	INCOMPLETE	|COMPLETE ESCALATION|	2| 
		

# ##################################################################################### Fresh Food Manager check ######################################################## 
 @sma
 Scenario Outline: UAT_27Verify Manager allowed to 'Add' new Escalations in FM check 'Fixture' location for product level
 
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	 Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date 
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on "<Aisle>"
	And I click on product level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|Aisle|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Fresh Food Manager Check| Fixture|Aisle 0|2|
		
@sma
 Scenario Outline: UAT_28Verify Manager allowed to 'Add' new Escalations in FM check 'Fixture' location for Department level
 
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on "<Aisle>"
	   And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|Aisle|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Fresh Food Manager Check| Fixture|Aisle 0|2|
			
@sma
 Scenario Outline: UAT_29Verify Manager allowed to 'Add' new Escalations in FM check 'Promotions' location for Product level
 
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Fresh Food Manager Check| Promotions|2|
	
	@sma
 Scenario Outline: UAT_30Verify Manager allowed to 'Add' new Escalations in FM check 'Promotions' location for Department level
 
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
		Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Fresh Food Manager Check| Promotions|2|
		
@sma
Scenario Outline: UAT_31Verify Manager allowed to 'Add' new Escalations in FM check 'Warehouse' location for Product level

	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Fresh Food Manager Check|Warehouse |2|
	
@sma
Scenario Outline: UAT_32Verify Manager allowed to 'Add' new Escalations in FM check 'Warehouse' location for Department level
When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Fresh Food Manager Check|Warehouse |2|
		
@sma
Scenario Outline: UAT_33Verify Manager allowed to 'Add' new Escalations in FM check ' Critical Checks ' location for Department level
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Fresh Food Manager Check|Critical Checks |2|
		
@sma
Scenario Outline: UAT_34Verify Manager allowed to 'Add' new Escalations in FM check ' Critical Checks ' location for Product level
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Fresh Food Manager Check|Critical Checks |2|
	
 #######################################################################Afternoon Checks#####################################################	
 
 @sma
 Scenario Outline: UAT_35Verify Manager allowed to 'Add' new Escalations in Afternoon Checks 'Fixture' location for product level
 
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	 Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date 
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on "<Aisle>"
	And I click on product level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|Aisle|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Afternoon Checks| Fixture|Aisle 70|2|
		
@sma
 Scenario Outline: UAT_36Verify Manager allowed to 'Add' new Escalations in Afternoon Checks 'Fixture' location for Department level
 
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on "<Aisle>"
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|Aisle|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|		Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Afternoon Checks| Fixture|Aisle 70|2|
			
@sma
 Scenario Outline: UAT_37Verify Manager allowed to 'Add' new Escalations in Afternoon Checks 'Promotions' location for Product level
 
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Afternoon Checks| Promotions|2|
	
	@sma
 Scenario Outline: UAT_38Verify Manager allowed to 'Add' new Escalations in Afternoon Checks 'Promotions' location for Department level
 
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
		Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Afternoon Checks| Promotions|2|
		
@sma
Scenario Outline: UAT_39Verify Manager allowed to 'Add' new Escalations in Afternoon Checks 'Warehouse' location for Product level

	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Afternoon Checks|Warehouse |2|
	
@sma
Scenario Outline: UAT_40Verify Manager allowed to 'Add' new Escalations in Afternoon Checks 'Warehouse' location for Department level
When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Afternoon Checks|Warehouse |2|
		
@sma
Scenario Outline: UAT_41Verify Manager allowed to 'Add' new Escalations in Afternoon Checks ' Critical Checks ' location for Department level
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Afternoon Checks|Critical Checks |2|
		
@sma
Scenario Outline: UAT_42Verify Manager allowed to 'Add' new Escalations in Afternoon Checks ' Critical Checks ' location for Product level
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Afternoon Checks|Critical Checks |2|
	
## 	################################################################################ Daliy Check ###########################################################################
 	
 	
 @sma
 Scenario Outline: UAT_43Verify Manager allowed to 'Add' new Escalations in Daily Checks 'Fixture' location for product level
 
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	 Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date 
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on "<Aisle>"
	And I click on product level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|Aisle|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Daily Checks| Fixture|Aisle 22|2|
		
@sma
 Scenario Outline: UAT_44Verify Manager allowed to 'Add' new Escalations in Daily Checks 'Fixture' location for Department level
 
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on "<Aisle>"
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|Aisle|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|		Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Daily Checks| Fixture|Aisle 22|2|
			
@sma
 Scenario Outline: UAT_45Verify Manager allowed to 'Add' new Escalations in Daily Checks 'Promotions' location for Product level
 
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Daily Checks| Promotions|2|
	
	@sma
 Scenario Outline: UAT_46Verify Manager allowed to 'Add' new Escalations in Daily Checks 'Promotions' location for Department level
 
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
		Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Daily Checks| Promotions|2|
		
@sma
Scenario Outline: UAT_47Verify Manager allowed to 'Add' new Escalations in Daily Checks 'Warehouse' location for Product level

	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Daily Checks|Warehouse |2|
	
@sma
Scenario Outline: UAT_48Verify Manager allowed to 'Add' new Escalations in Daily Checks 'Warehouse' location for Department level
When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Daily Checks|Warehouse |2|
		
@sma
Scenario Outline: UAT_49Verify Manager allowed to 'Add' new Escalations in Daily Checks ' Critical Checks ' location for Department level
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Daily Checks|Critical Checks |2|
		
@sma
Scenario Outline: UAT_50Verify Manager allowed to 'Add' new Escalations in Daily Checks ' Critical Checks ' location for Product level
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
	Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	Then I click on "<Location1>" 
	And I click on product level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  checkMenu|Location1|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|Summary & Sign Off| 	    VIEW|	VIEW|	ADD NEW ESCALATION|	Daily Checks|Critical Checks |2|
	
 	
# 	####################################################################################################################################################################
 	
 	@sma
	Scenario Outline: UAT_51Verify Manager allowed to 'Add' new Escalations in 'Pre-Opening Clearance Bay Checks' locations
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
		Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 				VIEW|	Status|		Button|			   		  				checkMenu|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	Escalations|	VIEW|	ADD NEW ESCALATION|Pre-Opening Clearance Bay Checks|	2|
		
	@sma
	Scenario Outline: UAT_52Verify Manager allowed to 'Add' new Escalations in 'Store Close Clearance Bay Checks' locations
	When I enter Username and Password for SMA Manager user 
	And I click on login button for SMA
		Then I click on the main menu "Code Checking"
	Then I click on "<Menu>" 
	Then I click on "<Department_Menu>" 
	And I click past "<daterange>" day date
	Then I click on "<SubMenu>" 
	Then I click on "<Location>" 
	And I verify Escalations and below text is displayed 
	Then I click on "<VIEW>" 
	Then I click on "<Button>" 
	Then I click on "<checkMenu>" 
	And I click on product and department level
	And I select Details of Problem Found
	And I verify and select Investigation details
 	And I verify and select Next Steps
 	And I verify redirection to escalation list
	
	Examples: 
		| Menu | 				Department_Menu |		SubMenu|			  Location| 		VIEW|	Status|		Button|			   		  				checkMenu|daterange|
		|Fresh Code Check|	Daily Schedule|	Fresh Food Manager Check|	Summary & Sign Off| 	Escalations|	VIEW|	ADD NEW ESCALATION|Store Close Clearance Bay Checks|	2|
		
		
		
#		###################################################################### ManagerSignOff #########################################################################
		
		
		@sma
		Scenario Outline: UAT_83Verify list of product for 'Daily Checks under Categories' in Manager SignOff Summary & Sign Off Screen 
			
		When I enter Username and Password for SMA Manager user 
		And I click on login button for SMA
			Then I click on the main menu "Code Checking"
		Then I click on "<Menu>" 
		Then I click on "<Department_Menu>" 
		Then I click on "<SubMenu>" 
		Then I click on "<Location1>" 
		And I verify product list is displayed 
		Then I click on "<Location2>" 
		And I verify product list is displayed 
		Then I click on "<Location3>" 
		And I verify product list is displayed 
		
		
		Examples: 
				| Menu | 				Department_Menu |		SubMenu|							Location1|	Location2|	Location3|			  
				|Fresh Code Check|	Manager Summary & Sign Off|	Out of Code - Daily Checks (Waste)|Critical Checks|Promotions|Warehouse|
		
		@sma
		Scenario Outline: UAT_84Verify list of aisles under Department details for 'Daily Checks under Categories' in Manager SignOff Summary & Sign Off Screen 
			When I enter Username and Password for SMA Manager user 
		And I click on login button for SMA
			Then I click on the main menu "Code Checking"
		Then I click on "<Menu>" 
		Then I click on "<Department_Menu>" 
		Then I click on "<SubMenu>" 
		And I select and verify aisles under Department is displayed

			Examples: 
				| Menu | 				Department_Menu |		SubMenu|								  
				|Fresh Code Check|	Manager Summary & Sign Off|	Out of Code - Daily Checks (Waste)|
		

		@sma
		Scenario Outline: UAT_85Verify list of product for 'Afternoon Checks under Categories' in Manager SignOff Summary & Sign Off Screen 
			
		When I enter Username and Password for SMA Manager user 
		And I click on login button for SMA
			Then I click on the main menu "Code Checking"
		Then I click on "<Menu>" 
		Then I click on "<Department_Menu>" 
		Then I click on "<SubMenu>" 
		And I click Afternoon Checks tab
		Then I click on "<Location1>" 
		And I verify product list is displayed 
		Then I click on "<Location2>" 
		And I verify product list is displayed 
		Then I click on "<Location3>" 
		And I verify product list is displayed 
		
		
		Examples: 
				| Menu | 				Department_Menu |		SubMenu|							Location1|	Location2|	Location3|			  
				|Fresh Code Check|	Manager Summary & Sign Off|	Out of Code - Daily Checks (Waste)|Critical Checks|Promotions|Warehouse|
		
		@sma
		Scenario Outline: UAT_86Verify list of aisles under Department details for 'Afternoon Checks under Categories' in Manager SignOff Summary & Sign Off Screen 
			When I enter Username and Password for SMA Manager user
		And I click on login button for SMA
			Then I click on the main menu "Code Checking"
		Then I click on "<Menu>" 
		Then I click on "<Department_Menu>" 
		Then I click on "<SubMenu>" 
		And I click Afternoon Checks tab
		And I select and verify aisles under Department is displayed

			Examples: 
				| Menu | 				Department_Menu |		SubMenu|									  
				|Fresh Code Check|	Manager Summary & Sign Off|	Out of Code - Daily Checks (Waste)|
		

		
		@sma
		Scenario Outline: UAT_87Verify list of product for 'FM Check under Categories' in Manager SignOff Summary & Sign Off Screen 
			
		When I enter Username and Password for SMA Manager user 
		And I click on login button for SMA
			Then I click on the main menu "Code Checking"
		Then I click on "<Menu>" 
		Then I click on "<Department_Menu>" 
		Then I click on "<SubMenu>" 
		And I click FM check tab
		Then I click on "<Location1>" 
		And I verify product list is displayed 
		Then I click on "<Location2>" 
		And I verify product list is displayed 
		Then I click on "<Location3>" 
		And I verify product list is displayed 
		
		
		Examples: 
				| Menu | 				Department_Menu |		SubMenu|							Location1|	Location2|	Location3|			  
				|Fresh Code Check| Manager Summary & Sign Off |	Out of Code - Daily Checks (Waste)|Critical Checks|Promotions|Warehouse|
		
		@sma
		Scenario Outline: UAT_88Verify list of aisles under Department details for 'FM Check under Categories' in Manager SignOff Summary & Sign Off Screen 
		When I enter Username and Password for SMA Manager user 
		And I click on login button for SMA
			Then I click on the main menu "Code Checking"
		Then I click on "<Menu>" 
		Then I click on "<Department_Menu>" 
		Then I click on "<SubMenu>" 
		And I click FM check tab
		And I select and verify aisles under Department is displayed

			Examples: 
				| Menu | 				Department_Menu |		SubMenu|									  
				|Fresh Code Check|	Manager Summary & Sign Off|	Out of Code - Daily Checks (Waste)|
		
		@sma
		Scenario Outline: UAT_95Verify 'Summary & Sign Off screen' for Store Manager 'weekly sign off' details before confirming the sign off
		
		When I enter Username and Password for SMA Manager user 
		And I click on login button for SMA
			Then I click on the main menu "Code Checking"
		Then I click on "<Menu>" 
		Then I click on "<Department_Menu>" 
		Then I click on "<Button>" 
		And I verify weekly sign off screen details and checkbox displayed
				
		Examples: 
				| Menu | 				Department_Menu |		Button|									  
				|Fresh Code Check|	Manager Summary & Sign Off|	SIGN OFF|
		

		