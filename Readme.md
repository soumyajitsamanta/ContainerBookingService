# About Project

This is capability to handle the booking of containers by users.
The User Story responsible for creation of the service is presented below.

# User Story
As a *customer*.

I want to be able to book *containers*.

So that I can deliver cargo to my *customers*

The aim of this story is to develop two microservice endpoints that enable a
customer to book a container. There is no need to consider
authentication or authorization mechanisms for this task.

One endpoint will establish if there are enough containers of an appropriate size
and type at a given container yard to meet the customers booking requirements.
The service acts as a proxy and will call another external service to fetch the
data.

The other endpoint will receive a booking request and store the data in a
Cassandra database table for later processing by other systems.

# Setups Before Application Running
Step 1: Run Cassandra and capture the port number.

Step 2: Put the port in the application.yml.

Step 3: Execute the service.

# Endpoints

## Create A Booking In Database
POST /api/bookings/book HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "quantity":2000,
    "destination":"destination",
    "origin":"origin",
    "containerType":"REEFER",
    "containerSize":10
}

### Sample Response

{
    "bookingRef": "957000001"
}

## Check If Kind Container Available

POST /api/bookings/check-available HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "quantity":2,
    "destination":"12345",
    "origin":"12345"  ,
    "containerType":"DRY",
    "containerSize":10
} 

### Sample Response
{
    "available": false
}
