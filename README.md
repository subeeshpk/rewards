# Rewards Program API

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction.
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three month period, calculate the reward points earned for each customer

# Build & deploy the project
    1. Clone the prohect using git clone 
       https://github.com/subeeshpk/rewards.git
    2. mvn clean install
    3. mvn spring-boot:run
# API to post the transactions
    POST: http://localhost:8080/api/transactions
# API to get the reward details
    GET: http://localhost:8080/api/transactions/rewards

* Version 1.0.0 
  * Initial version of Rewards Program API
