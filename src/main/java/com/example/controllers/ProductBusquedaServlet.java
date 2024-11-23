package com.example.controllers;

import com.example.dao.ProductDAO;
import com.example.models.Product;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/busqueda")
public class ProductBusquedaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        try {


     req.setCharacterEncoding("UTF-8");
String searchTerm = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));



      String searchTermFinal = searchTerm.toLowerCase().trim();



            if (!searchTermFinal.isEmpty()) {


   ProductDAO productDAO = new ProductDAO();
                List<Product> filteredProducts = productDAO.getAllProducts().stream()
 .filter(product -> product.getName().toLowerCase().contains(searchTermFinal))

  .collect(Collectors.toList());



                String json = new Gson().toJson(filteredProducts);//para el json del response del $.ajax



                resp.setContentType("application/json");



resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);



     } else {//si input esta vacio


  resp.setStatus(HttpServletResponse.SC_NO_CONTENT);


 }


 } catch (Exception e)


 {




 resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);


  }
 }


}
