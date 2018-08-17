package servlet;

import domain.Product;
import form.ProductForm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/product_input", "/product_save"})

public class ControllerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        /*
        uri is in this form:
         */
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        if(action.equals("product_input.action")){
            //no action class , there  is nothing to be done
        } else if(action.equals("product_save.action")){
            ProductForm productForm = new ProductForm();
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription((productForm.getDescription()));
            product.setPrice(Float.parseFloat(productForm.getPrice()));

            request.setAttribute("product", product);
            String dispatchUri = null;
            if(action.equals("product_input.action")){
                dispatchUri = "/WEB-INF/jsp/ProductForm.jsp";
            } else if(action.equals("product_save.action"))
            {
                dispatchUri = "/WEB-INF/jsp/ProductDetailes.jsp";
            }
            if(dispatchUri != null){
                RequestDispatcher rd = request.getRequestDispatcher(dispatchUri);
                rd.forward(request, response);
            }
        }
    }
}
