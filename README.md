# Spring Boot REST API CRUD Operations

## Features
- Create, Read, Update, Delete operations
- One to Many Mapping 
- RESTful API design
- Data validation
- Error handling

## Technologies Used
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- Lombok 
  
## Getting Started

### Prerequisites
- Java 11 or higher
- Maven
- IDE (Eclipse)

## Testing Tool
- Postman use 
  
The API will be available at `http://localhost:4041`.

## API Endpoints
-Category
| Method | Endpoint                | Description                                |
|--------|-------------------------|--------------------------------------------|
| GET    | /category/find/{cid}    | Get resource by ID                         |
| POST   | /category/register/{cid}| Create a new resource                      |
| PUT    | /category/modify/{cid}  | Update resource by ID                      |
| DELETE | /category/delete/{cid}  | Delete resource by ID                      |
| PAGE   | /category/ppage         | Pagination resources By Pagani and pagesize|

-Product
| Method | Endpoint                | Description                                |
|--------|-------------------------|--------------------------------------------|
| GET    | /product/find/{pid}     | Get resource by ID                         |
| POST   | /product/register/{pid} | Create a new resource                      |
| PUT    | /product/modify/{pid}   | Update resource by ID                      |
| DELETE | /product/delete/{pid}   | Delete resource by ID                      |
| PAGE   | /product/ppage          | Pagination resources By Pagani and pagesize|

#
- List any resources or contributors that helped you with the project.

Feel free to customize it based on your project specifics!
