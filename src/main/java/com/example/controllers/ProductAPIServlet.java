package com.example.controllers;

import com.example.dao.ProductDAO;
import com.example.models.Product;
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
public class ProductAPIServlet extends HttpServlet


{

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

{

try{

String searchTerm = request.getParameter("search[value]");

int draw = Integer.parseInt(request.getParameter("draw"));
int start = Integer.parseInt(request.getParameter("start"));

int length = Integer.parseInt(request.getParameter("length"));


ProductDAO productDAO = new ProductDAO();


List<Product> filteredProducts = productDAO.getAllProducts();

if (searchTerm != null && !searchTerm.isEmpty())
{


filteredProducts = filteredProducts.stream().filter(product -> product.getName().toLowerCase().contains(searchTerm.toLowerCase())).collect(Collectors.toList());

}

filteredProducts = filteredProducts.subList(start, Math.min(start + length, filteredProducts.size()));

int totalRecords = productDAO.getAllProducts().size();

int recordsFiltered = filteredProducts.size();

JSONObject jsonResponse = new JSONObject();


jsonResponse.put("draw", draw);

jsonResponse.put("recordsTotal", totalRecords);

jsonResponse.put("recordsFiltered", recordsFiltered);

jsonResponse.put("data", filteredProducts);



response.setContentType("application/json");


response.setCharacterEncoding("UTF-8");
response.getWriter().write(jsonResponse.toString());

} catch (Exception e)


 {e.printStackTrace(); //logs error o response.setStatus,etc

}


}




}