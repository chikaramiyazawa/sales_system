package controllers.product_buy;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Sale;
import utils.DBUtil;

/**
 * Servlet implementation class ProductBuyCancelServlet
 */
@WebServlet("/products/buy/cancel")
public class ProductBuyCancelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductBuyCancelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getAttribute("sale_id")));
            EntityManager em = DBUtil.createEntityManager();

            Sale s = em.find(Sale.class, (Integer)(request.getSession().getAttribute("sale_id")));

            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
            request.getSession().setAttribute("flush","購入をキャンセルしました。");
            em.close();

            request.getSession().removeAttribute("id");
            response.sendRedirect(request.getContextPath() + "/products/sale/index");
    }

}
