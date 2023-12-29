The application allow users to view a list of available products, add new products, and update existing ones. 
Each product has a name, description, price, and quantity.
Used Hibernate to persist the product information in a MySQL database.

To run the application, you should get its files from Github to your IDE,
run the application in IDE, and then use any service for sending requests to endpoint (I use Postman)

To see the list of products, send get request to endpoint /products.

To add new product, send post request to endpoint /product with JSON, for example:
{"id":5,"name":"product 5","price":350,"quantity":20,"description":"this is product 5"}


To update existing product, send put request to endpoint /product with JSON, for example:
{"id":2,"name":"product updated","price":2,"quantity":999,"description":"this product was updated"}


Feedback:
It was not easy to complete the task using AI. It took around 16 hours.
AI gave me a lot of complete code for my application and setting up database, but it's very awful in writing unit tests.
Almost half of time I spent to make tests work, and still succeeded in 1 out of 2.