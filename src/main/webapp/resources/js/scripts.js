$(document).ready(function () {
    $('#productTable').DataTable({
        "ajax": "/productos", // Ruta al servlet
        "columns": [
            {"data": "name"},
            {"data": "price"}
        ]
    });
});
