# Betting Application

The main goal of this task is to create a simple betting application.

The application supports the following funcionalities:

•	Betslip placement:
-	The player can bet on the outcome (*) of some of the matches shown as part of the offer
-	The offer itself is generated and filled with dummy data upon application startup
-	Both the offer and placed betslips are persisted in a database
-	The final betslip odds multiplier is calculated as a multiplication of the odds associated with the selected match outcomes

•	The player is able to browse through the list of placed betslips

•	Wallet – each betslip placement changes the wallet balance

(*) The allowed outcomes are as follows:
-	1 -> home win
-	2 -> away win
-	X -> draw

Betslips are placed by only one player.

The solution is implemented utilizing Spring Boot and Vue.js with in-memory H2 database.
