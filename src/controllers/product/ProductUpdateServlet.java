package controllers.product;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.validators.ProductUpdateValidator;
import models.Product;
import utils.DBUtil;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/products/update")
public class ProductUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateServlet() {
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

            Product p = em.find(Product.class, (Integer)(request.getSession().getAttribute("product_id")));

          int num;

            try {
                num = Integer.parseInt(request.getParameter("price"));
                p.setPrice(num);
            } catch (NumberFormatException e) {
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("product", p);
                request.getSession().setAttribute("errors", "数字で入力してください");
                em.close();

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/products/edit.jsp");
                rd.forward(request,response);

            }

            p.setName(request.getParameter("name"));

            int goodpoint = Integer.parseInt(request.getParameter("goodpoint"));
            int good = Integer.parseInt(request.getParameter("good"));

            good = goodpoint + good;

            p.setGoodpoint(goodpoint);

            p.setGood(good);

             Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            p.setCreated_at(currentTime);
            p.setUpdated_at(currentTime);
            List<String> errors = ProductUpdateValidator.validate(p);
            if(errors.size() >0){
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("products", p);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/products/edit.jsp");
                rd.forward(request,response);

            }else{
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");
                response.sendRedirect(request.getContextPath() + "/products/index");
            }
        }
    }
    }
