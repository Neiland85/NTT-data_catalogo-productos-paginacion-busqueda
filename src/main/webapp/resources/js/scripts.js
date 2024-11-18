$(document).ready(function () {



 $.ajax({
    url: '/productos', // Ruta al servlet
    // el parametro dataSrc: lo dejamos vacio dado que esperamos que nos devuelva
        // la información dentro del cuerpo del response (no dentro de otro nodo)
        dataSrc: ''
    }).then(function(data) {

         $('#productTable').DataTable( {
                data: data,  //aqui cargamos data de forma dinámica (viene del backend)
        columns: [

            { data: 'name' },

            { data: 'price' }


        ]


    } );

     //mostramos un mensaje por consola una vez cargada la data

    console.log("Datos recibidos y cargados:",data);

    }

    //para tratar posible error

    , function(error) {


    //error: objeto que guarda info detallada del error

     console.error("Error al obtener datos:", error);

    });





});
