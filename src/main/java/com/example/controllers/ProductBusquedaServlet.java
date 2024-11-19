
package com.example.controllers;

//imports

@WebServlet("/busqueda")
public class ProductBusquedaServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("UTF-8");


            String searchTerm = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

            searchTerm = searchTerm.trim();


            if (!searchTerm.isEmpty()) {
                ProductDAO productDAO = new ProductDAO();

//se implementa toda la logica aquí para un ejemplo simple y completo de buscar con este endpoint, si usas el método que gestiona
//paginacion + filtros + busqueda de forma simultanea puedes poner toda esta lógica en ese metodo en lugar de en el nuevo
                List<Product> filteredProducts = productDAO.getAllProducts().stream()
                        .filter(product -> product.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                        .collect(Collectors.toList());



                String json = new Gson().toJson(filteredProducts);

               System.out.println("Respuesta JSON: " + json);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");

                resp.getWriter().write(json);


            } else {


                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);



            }





        } catch (Exception e) {




            System.err.println("Error en ProductBusquedaServlet: " + e.getMessage());
             resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);


        }

    }

}
