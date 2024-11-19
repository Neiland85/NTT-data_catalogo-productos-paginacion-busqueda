
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Catálogo de Productos</title>

 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">

</head>
<body>



<h1>Catálogo de Productos</h1>

 <input type="text" id="searchInput" placeholder="Buscar productos...">

<table id="productTable" class="display">



    <thead>


    <tr>

        <th>Nombre</th>
        <th>Precio</th>


    </tr>


    </thead>
    <tbody>

    </tbody>
</table>


<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
 <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
 <script src="<c:url value="/resources/js/scripts.js"/>"></script>

</body>
</html>
