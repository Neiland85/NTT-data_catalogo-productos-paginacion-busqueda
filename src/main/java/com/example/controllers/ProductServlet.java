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


@WebServlet("/productos") //  Esta es la ruta del servlet
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       //para controlar en un log  si llega o no llega el mensaje al ProductServelt
    System.out.println("ProductServlet's doGet() called");


        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProducts();

        Gson gson = new Gson();
        String json = gson.toJson(products);



        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);



        //para controlar que devuelve a traves de la consola web

        System.out.println(json);



    }


}
