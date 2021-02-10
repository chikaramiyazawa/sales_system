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

@Table(name = "products")
@NamedQueries({
    @NamedQuery(
            name = "getAllProduct",
            query = "SELECT p FROM Product AS p ORDER BY p.id DESC"
                ),
    @NamedQuery(
            name = "getProductCount",
            query ="SELECT COUNT(p) FROM Product AS p"
            ),
    @NamedQuery(
            name = "checkRegisteredName",
            query ="SELECT COUNT(p)FROM Product AS p WHERE p.name = :name"
            ),
    @NamedQuery(
            name = "checkNameAndPrice",
            query ="SELECT p FROM Product AS p WHERE p.name = :name AND p.price = :price"
            )

})
@Entity

public class Product {
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name = "name" , nullable = false)
private String name;

@Column(name = "price" , nullable = false)
private Integer price;

@Column(name = "good" , nullable = false)
private Integer good;

@Column(name = "goodpoint" , nullable = false)
private Integer goodpoint;

@Column(name = "created_at" , nullable = false)
private Timestamp created_at;

@Column(name = "updated_at" , nullable = false)
private Timestamp updated_at;


public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Integer getPrice() {
    return price;
}

public void setPrice(Integer price) {
    this.price = price;
}

public Timestamp getCreated_at() {
    return created_at;
}

public void setCreated_at(Timestamp created_at) {
    this.created_at = created_at;
}

public Integer getGood() {
    return good;
}

public void setGood(Integer good) {
    this.good = good;
}
public Timestamp getUpdated_at() {
    return updated_at;
}

public void setUpdated_at(Timestamp update_at) {
    this.updated_at = update_at;
}
public Integer getGoodpoint() {
    return goodpoint;
}

public void setGoodpoint(Integer goodpoint) {
    this.goodpoint = goodpoint;
}
}
