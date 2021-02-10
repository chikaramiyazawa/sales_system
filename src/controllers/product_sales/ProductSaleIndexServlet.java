package controllers.product_sales;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import utils.DBUtil;

/**
 * Servlet implementation class ProductSaleIndexServlet
 */
@WebServlet("/products/sale/index")
public class ProductSaleIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSaleIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        int page = 1;

        try{
            page =Integer.parseInt(request.getParameter("page"));
        } catch(NumberFormatException e) { }

        List<Product> products = em.createNamedQuery("getAllProduct", Product.class)
                .setFirstResult(15 * (page - 1))
                .setMaxResults(15)
                .getResultList();

        long products_count = (long)em.createNamedQuery("getProductCount", Long.class)
                .getSingleResult();
                em.close();

                request.setAttribute("products", products);
                request.setAttribute("products_count", products_count);
                request.setAttribute("page", page);
                if(request.getSession().getAttribute("flush") != null) {
                    request.setAttribute("flush", request.getSession().getAttribute("flush"));
                    request.getSession().removeAttribute("flush");
                }
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/products/sale_index.jsp");
                rd.forward(request, response);

    }

}
