package com.example.controllers;

import com.example.dao.ProductDAO;
import com.example.models.Product;
import com.google.gson.Gson;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/productAPI")
public class ProductAPIServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Parámetros de DataTables
            String searchTerm = request.getParameter("search[value]");
            int draw = Integer.parseInt(request.getParameter("draw"));
            int start = Integer.parseInt(request.getParameter("start"));
            int length = Integer.parseInt(request.getParameter("length"));
//para ordenar, puedes añadir mas o usar un enum
            String sortColumn = request.getParameter("columns[" + request.getParameter("order[0][column]") + "][name]");

            String sortDirection = request.getParameter("order[0][dir]");


            ProductDAO productDAO = new ProductDAO();
            List<Product> filteredProducts = productDAO.getAllProducts();

            // Búsqueda (si hay término de búsqueda)
 if (searchTerm != null && !searchTerm.isEmpty()) {

                filteredProducts = filteredProducts.stream()

                        .filter(product -> product.getName().toLowerCase().contains(searchTerm.toLowerCase()))

                        .collect(Collectors.toList());
            }

            // Paginación (aplicada después de la búsqueda)

        //la sublista con los indices adecuados para la paginación con el filtro actual o todos si no hay


 filteredProducts= filteredProducts.subList(start, Math.min(start + length, filteredProducts.size()));


 int totalRecords = productDAO.getAllProducts().size();//todos, con la lista completa
 int recordsFiltered = filteredProducts.size();   //filtrados tras la búsqueda, a partir de la lista filtrada actual y con paginacion


//para respuesta a datatables con formato Json para serverSide, incluye start, draw y length tras cada request post al endpoint. Sort se gestiona aparte



   JSONObject jsonResponse = new JSONObject();//nuevo objeto

            jsonResponse.put("draw", draw);
        jsonResponse.put("recordsTotal", totalRecords); //añadimos info
            jsonResponse.put("recordsFiltered", recordsFiltered);//total filtrados tras nueva request
           jsonResponse.put("data", filteredProducts);    // array con datos



     response.setContentType("application/json");//tipo json



            response.setCharacterEncoding("UTF-8"); //config correcta


       response.getWriter().write(jsonResponse.toString());   //envía la respuesta






} catch (Exception e) {



     e.printStackTrace();//o response.setStatus



}



    }

}
