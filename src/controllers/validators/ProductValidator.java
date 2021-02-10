package controllers.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Product;
import utils.DBUtil;

public class ProductValidator {
    public static List<String> validate(Product p ,Boolean name_duplicate_check_flag){
        List<String>errors = new ArrayList<String>();

        String name_error = _validateName(p.getName(), name_duplicate_check_flag);
        if(!name_error.equals("")){
            errors.add(name_error);
        }
        return errors;
    }

    private static String _validateName(String name , Boolean name_duplicate_check_flag){
        if(name == null || name.equals("")){
            return "商品名が入力してください。";
        }
        if(name_duplicate_check_flag){
            EntityManager em = DBUtil.createEntityManager();
            long name_count = (long)em.createNamedQuery("checkRegisteredName" , Long.class)
                                        .setParameter("name", name)
                                        .getSingleResult();
            em.close();
            if(name_count > 0){
                return "入力された商品名はすでに存在しています";
            }
        }
        return "";
     }

}

