# REST Server for Flat Flats
 ###Introduction 

Project contains REST end-point implementation for Web server requests of Flat Flats application. REST Application has been created using Spring Boot implementation. Each entity contains 4 layers structure:
- Entity Class
- Repository Class
- Service Class
- Controller Class
 
On the top there is an abstract repository and service layers located under following package: 
* com/sparrowsanta/real_estate_management_rest/standardJpa

Server has been deployed on AWS Beanstalk machine connected to AWS RDS Database. Detailed functions and business logic of Flat Flats application can be found under the following link:

###End points
Application has been hosted on AWS Beanstalk. **All endpoints can be tested using Swagger implementation:**

http://realestatemanagementrest-env.eba-u4wqr2f3.eu-central-1.elasticbeanstalk.com/swagger-ui.html#/

All endpoints refer to following base url address:
http://realestatemanagementrest-env.eba-u4wqr2f3.eu-central-1.elasticbeanstalk.com/

Each entity contains standard CRUD implementation. Apart from that selective functions have been described below:
####Bills
    GET bills/billDefinitionsPerMonth/:flatId
   * Returns [months], [bills definitions], [paid bills]
   * Success Response: Code: 200
   * Requires: flatId integer
   * Content: [
                 [
                   "JUNE",
                   "JULY",
                   "AUGUST",
                   "SEPTEMBER"
                 ],
                 [
                   "730.0",
                   "730.0",
                   "980.0",
                   "880.0"
                 ],
                 [
                   "730.0",
                   "730.0",
                   "730.0"
                 ]
               ]

    GET bills/payment/all/:flatId/:paidFilter/:typeFilter/:dateFromFilter/:dateToFilter
   * Returns
   * Success Response: Code: 200
   * Content: 
   [
     {
       "id": 105,
       "rentDateFrom": "2020-09-06",
       "rentDateTo": "2020-09-09",
       "rentAmount": 100,
       "client": {
         "id": 104,
         "firstName": "Rafał",
         "lastName": "Opiał",
         "age": 24,
         "email": "aaa@aaa.com",
         "city": "Kraków",
         "street": "Racławicka 58",
         "telNumber": null
       },
       "room": {
         "id": 86,
         "description": "Pokój 2",
         "roomSquareMeters": 17,
         "expectedRentPrice": 600,
         "roomType": "ROOM",
         "picUrl": 23423423,
         "occupiable": true,
         "client": null
        }
   ]
   
####Flats
    POST flats/flatPicture/:flatId
   * Requires: flatId integer
   * Success Response: Code: 200
   * Action: Save the picture for particular flat ID
   
####Rents
    GET rents/getMostRecentRent/:roomId
   * Requires: roomId integer
   * Success Response: Code: 200
   * Action: Get most recent Rent for particular room ID
   * Content: 
      [
        {
          "id": 105,
          "rentDateFrom": "2020-09-06",
          "rentDateTo": "2020-09-09",
          "rentAmount": 100,
          "client": {
            "id": 104,
            "firstName": "Rafał",
            "lastName": "Opiał",
            "age": 24,
            "email": "aaa@aaa.com",
            "city": "Kraków",
            "street": "Racławicka 58",
            "telNumber": null
          },
          "room": {
            "id": 86,
            "description": "Pokój 2",
            "roomSquareMeters": 17,
            "expectedRentPrice": 600,
            "roomType": "ROOM",
            "picUrl": 23423423,
            "occupiable": true,
            "client": null
           }
      ]
      
####Rooms
    POST rooms/addRoomsForFlat/:flatId
   * Requires: flatId integer
   * Success Response: Code: 200
   * Action: Save Rooms for particular flat
    
 ###Technologies
 - Java 8
 - AWS Beanstalk
 - Amazon RDS
 - T-SQL
 - JPQL
 - Swagger
 
 ###How to start
Application is running under following address: 
http://realestatemanagementrest-env.eba-u4wqr2f3.eu-central-1.elasticbeanstalk.com/

 
Clone repository:
https://github.com/sparrowsanta/Real_Estate_Management_REST

Proceed with AWS Beanstalk and Amazon RDS setup as described in the following article.
https://www.baeldung.com/spring-boot-deploy-aws-beanstalk

Once application is hosted on AWS, navigate to the local repository and run:
- mvn clean package spring-boot:repackage
- eb deploy


