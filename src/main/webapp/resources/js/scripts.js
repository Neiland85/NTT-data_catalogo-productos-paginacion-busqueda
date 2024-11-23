$(document).ready(function () {

    var table = $('#productTable').DataTable( {
        "serverSide": true,
        ajax: {
            url: '/productAPI',
            type: 'POST'
        },
        columns: [
           { data: "name" },
           { data: "price" }
         ]
    } );


    $('#searchInput').on('keyup', function () {
        var searchTerm = $(this).val();
        $.ajax({
            url: '/busqueda',
            type: 'POST',
            data:JSON.stringify(searchTerm),
            contentType:"application/json; charset=utf-8",
            dataType: 'json',
            success: function (response) {
                table.clear().draw();
                if(response){
                    table.rows.add(response).draw();
                }
            },
            error: function (xhr, ajaxOptions, thrownError) {
                table.clear().draw();
                alert(xhr.status+"\n\n"+thrownError +"\n\n"+ "Producto no encontrado");
               console.error("error petición $.ajax POST /busqueda");
           }
        });
    }); 

});
