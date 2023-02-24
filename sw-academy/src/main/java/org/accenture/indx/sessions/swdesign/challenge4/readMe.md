

# SW Design Workshop

## Problem Statement

The product owner would like to introduce a new feature requested by the stakeholders regarding order cancellation. As part of the order team, it is assigned to be managed within the order service.

If a client cancels any order, the refunding process must be initiated depending on the state of the process. Naturally, every order request starts with a new state, but other services in the platform update the order state as In Transit, Delivered, or Cancelled. 
When the order is canceled, the service should be intelligent enough to execute the steps as follows: </br>

* New Order -> The service must log the message: "It is a new order; no processing is done." And the cost of the order is to be refunded s 0£. </br> </br>
* In Transit -> The service must log the message: "Contacting courier service for cancellation. Contacting payment gateway for transaction rollback." The cost of the order is to be refunded: 20£. </br> </br>
* Delivered -> The service must log the message: "Contacting courier service for item pickup. Payment rollback will be initiated upon receiving the returned item." The cost of the order is to be refunded: 30£. </br> </br>

_**P.S.: An illegal State Exception must be thrown in case any one tries to cancel an already canceled order.**_