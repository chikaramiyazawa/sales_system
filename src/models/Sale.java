package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "sales")
@NamedQueries({
    @NamedQuery(
            name = "getAllSale",
            query = "SELECT s FROM Sale AS s ORDER BY s.id DESC"
                ),
    @NamedQuery(
            name = "getSaleCount",
            query ="SELECT COUNT(s) FROM Sale AS s"
            ),
    @NamedQuery(
            name = "getBuySale",
            query= "SELECT s FROM Sale AS s WHERE s.pay = 0 ORDER BY s.id DESC"
            ),
    @NamedQuery(
            name = "getTotalPrice",
            query = "SELECT SUM(s.sum) FROM Sale s WHERE s.pay = 0"
            )


})
@Entity
public class Sale {

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name = "s_product")
private String s_product;

@Column(name = "s_price")
private Integer s_price;

@Column(name = "count")
private Integer count;

@Column(name = "pay")
private Integer pay;

@Column(name = "sum")
private Integer sum;

@Column(name =  "recode")
private Timestamp recode;


public Integer getCount() {
    return count;
}


public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}


public String getS_product() {
    return s_product;
}

public void setS_product(String s_product) {
    this.s_product = s_product;
}

public Integer getS_price() {
    return s_price;
}

public void setS_price(Integer s_price) {
    this.s_price = s_price;
}


public Integer getSum() {
    return sum;
}

public void setSum(Integer sum) {
    this.sum = sum;
}

public void setCount(Integer count) {
    this.count = count;
}

public Timestamp getRecode() {
    return recode;
}

public void setRecode(Timestamp recode) {
    this.recode = recode;
}
public Integer getPay() {
    return pay;
}


public void setPay(Integer pay) {
    this.pay = pay;
}

}

