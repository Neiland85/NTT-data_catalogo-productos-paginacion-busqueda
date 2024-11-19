


$(document).ready(function () {


    var table = $('#productTable').DataTable({  //guarda datatables dentro de var table para uso posterior (ajax)

        "ajax": {

            url: "/productos", // Ruta inicial para cargar todos los productos al inicio

            dataSrc: ''
        },

        "columns": [

            {data: 'name'},
            {data: 'price'}

        ]

    });

//para cada evento del input
    $('#searchInput').on('keyup', function () {//esto activará $.ajax con cada tecla

//este parametro contendrá lo que escriba el usuario
//por cada tecla que escriba

        var searchTerm = $(this).val();



 $.ajax({



     url: '/busqueda', //ruta al nuevo servlet para hacer post con el valor de searchTerm y filtar productos
     type: 'POST',


 data:JSON.stringify(searchTerm),
     contentType:"application/json; charset=utf-8", //IMPORTANTE especificar esto si el endpoint es POST y va con JSON
//en tu backend hay codigo resp.setCharacterEncoding("UTF-8") en este caso


     dataType: 'json',
             success: function (response) {



//limpia toda la información que tenga y la pinta de nuevo


                 table.clear().draw();//limpia tabla antes de renderizar de nuevo





                 //si no encuentra producto para esa busqueda table se quedará vacio

 if (response)



{ //si la respuesta tiene información


                 table.rows.add(response).draw();//pinta los que cumplan los criterios



            }




            },
             error: function (xhr, ajaxOptions, thrownError) {//si algo falla



table.clear().draw();
            //error que salta al escribir en input

//xhr.status tendra el estado del error como 400 ,500 etc

//thrownError contiene texto con información del error mas especifica si la hay

                alert(xhr.status+"\n\n"+thrownError +"\n\n"+ "Producto no encontrado.");
               console.error("error petición $.ajax");



            }

 });




    });

});
