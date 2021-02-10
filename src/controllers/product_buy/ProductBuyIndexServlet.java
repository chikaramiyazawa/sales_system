package controllers.product_buy;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Sale;
import utils.DBUtil;

/**
 * Servlet implementation class ProductConfirmServlet
 */
@WebServlet("/products/buy/index")
public class ProductBuyIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductBuyIndexServlet() {
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


        List<Sale> sales = em.createNamedQuery("getBuySale", Sale.class)
                .setFirstResult(15 * (page - 1))
                .setMaxResults(15)
                .getResultList();

        try {
            long getTotal = (long)em.createNamedQuery("getTotalPrice", Long.class)
                    .getSingleResult();
                    em.close();
                    request.setAttribute("getTotal", getTotal);

        } catch(NullPointerException e) {




            response.sendRedirect(request.getContextPath() + "/products/sale/index");



        }




                request.setAttribute("sales", sales);

                if(request.getSession().getAttribute("flush") != null) {
                    request.setAttribute("flush", request.getSession().getAttribute("flush"));
                    request.getSession().removeAttribute("flush");
                }
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/products/buy.jsp");
                rd.forward(request, response);

    }

}
