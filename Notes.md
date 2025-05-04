# Swager-ui path
http://localhost:8080/swagger-ui/index.html

# H2 db path
http://localhost:8080/h2-console
un,pass : sa

# Powershell curl testi
##
Get-Command curl
komutunu calistir, sonra;
##
Tam POST URL: http://localhost:80/ecommerce-api/v1/login
##
Detaylı HTTP örnek request:

curl.exe -X POST http://localhost:8080/api/v1/products `
-H "Content-Type: application/json" `
-d '{
"name": "Gaming Laptop",
"description": "High-end gaming laptop with RTX graphics",
"basePrice": 2499.99,
"categoryIds": [],
"stockQuantity": 10,
"weight": 2.5,
"height": 2.0,
"width": 35.0,
"depth": 25.0
}'

curl.exe -X PUT http://localhost:8080/api/v1/products/{id} `
-H "Content-Type: application/json" `
-d '{
"id": "{id}",
"name": "Updated Laptop",
"description": "Updated desc",
"basePrice": 2199.99,
"currentPrice": 1999.99,
"categoryIds": [],
"stockQuantity": 15,
"status": "ACTIVE",
"weight": 2.4,
"height": 2.0,
"width": 36.0,
"depth": 26.0,
"createdAt": "2024-12-01T10:00:00",
"updatedAt": "2025-05-04T18:00:00"
}'

curl.exe -X POST http://localhost:8080/api/v1/categories `
-H "Content-Type: application/json" `
-d '{
"id": null,
"name": "Laptops",
"description": "All kinds of laptops",
"parentCategoryId": null
}'

curl.exe -X GET http://localhost:8080/api/v1/categories

curl.exe -X PUT http://localhost:8080/api/v1/categories/{id} `
-H "Content-Type: application/json" `
-d '{
"name": "Updated Category Name",
"description": "Updated description",
"parentCategoryId": null
}'

curl.exe -X POST http://localhost:8080/api/v1/categories/products `
-H "Content-Type: application/json" `
-d '{
"categoryId": "d3b07384d113edec49eaa6238ad5ff00",
"productId": "d3b07384d113edec49eaa6238ad5ff00"
}'


##
