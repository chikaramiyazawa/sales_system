package controllers.validators;

import java.util.ArrayList;
import java.util.List;

import models.Product;


public class ProductUpdateValidator {
    public static List<String> validate(Product p ){
        List<String>errors = new ArrayList<String>();

        String name_error = _validateName(p.getName());
        if(!name_error.equals("")){
            errors.add(name_error);
        }
        return errors;
    }

    private static String _validateName(String name ){
        if(name == null || name.equals("")){
            return "商品名が入力してください。";
        }

        return "";
     }

}

