package controllers.product_buy;

import java.io.IOException;
import java.sql.Timestamp;

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
 * Servlet implementation class ProductBuyUpdate
 */
@WebServlet("/product/buy/update")
public class ProductBuyUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductBuyUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){
            EntityManager em = DBUtil.createEntityManager();

            Sale s = em.find(Sale.class, (Integer)(request.getSession().getAttribute("sale_id")));

           int count;

            try {
                count = Integer.parseInt(request.getParameter("count"));
                s.setCount(count);
            } catch (NumberFormatException e) {
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("products", s);
                request.getSession().setAttribute("errors", "数字で入力してください");
                em.close();

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/products/sale.jsp");
                rd.forward(request,response);

            }

           s.setPay(0);

           s.setS_product(request.getParameter("s_product"));

           s.setS_price(Integer.parseInt(request.getParameter("s_price")));

           int price = Integer.parseInt(request.getParameter("s_price"));

           int counter = Integer.parseInt(request.getParameter("count"));

           price = price * counter ;

            s.setSum(price);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            s.setRecode(currentTime);




                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("sales", s);
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                response.sendRedirect(request.getContextPath() + "/products/buy");
        }
    }
}


