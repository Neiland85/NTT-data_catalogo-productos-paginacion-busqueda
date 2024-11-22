# Product Catalog with Pagination and Search

This project demonstrates skills in Java 8, JSP/JSTL, HTML5/CSS3, JavaScript/jQuery, SQL Developer, and Maven. It implements a simple product catalog with pagination and search using DataTables.

## Project Structure

catalogo-productos/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── example/
│ │ │ ├── controllers/
│ │ │ │ ├── ProductServlet.java
│ │ │ │ └── ProductBusquedaServlet.java
│ │ │ ├── models/
│ │ │ │ └── Product.java
│ │ │ └── dao/
│ │ │ └── ProductDAO.java
│ │ └── webapp/
│ │ ├── WEB-INF/
│ │ │ └── web.xml
│ │ ├── index.jsp
│ │ └── resources/
│ │ └── js/
│ │ └── scripts.js
│ └── test/
│ └── java/
│ └── com/
│ └── example/
│ └── dao/
│ └── ProductDAOTest.java
├── pom.xml
└── .gitignore

## How to Use

1. Clone the repository: `git clone https://github.com/Neiland85/NTT-data_catalogo-productos-paginacion-busqueda.git`
2. Import the project into your IDE as a Maven project.
3. Configure the application server (Tomcat, WildFly, etc.).
4. Deploy the application to the server.
5. Access the application in your browser: `http://localhost:8080/catalogo-productos/` (Adjust the port and application context if necessary).

The main page will display a product table with pagination and a search field. You can search for products by name.

## Technologies Used

* Java 8
* JSP/JSTL
* HTML5/CSS3
* JavaScript/jQuery
* DataTables
* Maven
* SQL Developer (for database connection - currently using mock data)
* JUnit 5

## Next Steps

* Implement the connection with a real database.
* Add more features to the catalog (sort by price, product details, etc.).
* Implement server-side pagination to optimize performance with large amounts of data.
* Extend search functionality to include more filter criteria, or a more comprehensive option implementing it with pagination using `DataTables serverSide` from the server.
