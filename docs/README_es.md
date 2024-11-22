# Catálogo de Productos con Paginación y Búsqueda

Este proyecto demuestra habilidades en Java 8, JSP/JSTL, HTML5/CSS3, JavaScript/jQuery, SQL Developer y Maven. Implementa un catálogo de productos simple con paginación y búsqueda utilizando DataTables.

## Estructura del Proyecto

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

## Modo de Utilización

1. Clona el repositorio: `git clone https://github.com/Neiland85/NTT-data_catalogo-productos-paginacion-busqueda.git`
2. Importa el proyecto en tu IDE como un proyecto Maven.
3. Configura el servidor de aplicaciones (Tomcat,  WildFly,  etc.).
4. Despliega la aplicación en el servidor.
5. Accede a la aplicación en tu navegador:  `http://localhost:8080/catalogo-productos/` (Ajusta el puerto y el contexto de la aplicación si es necesario).

La página principal mostrará una tabla de productos con paginación y un campo de búsqueda. Puedes buscar productos por nombre.

## Tecnologías Utilizadas

* Java 8
* JSP/JSTL
* HTML5/CSS3
* JavaScript/jQuery
* DataTables
* Maven
* SQL Developer (para la conexión con la base de datos; actualmente, se usan datos mock).
* JUnit 5

## Próximos pasos

* Implementar la conexión con una base de datos real.
* Añadir más funcionalidades al catálogo (ordenación por precio, detalles del producto, etc.).
* Implementar la paginación en el servidor para optimizar el rendimiento con grandes cantidades de datos.
* Ampliar la funcionalidad de la búsqueda, incluyendo más criterios de filtrado, o una opción más completa que la implemente con paginación con `DataTables serverSide` desde el servidor.
