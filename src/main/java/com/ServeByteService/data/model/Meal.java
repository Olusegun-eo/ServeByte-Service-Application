package com.ServeByteService.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mealId;
    private String mealName;
    private Double mealPrice;
    private int quantity;
    private String logoUrl;
    private String description;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<MealItem> mealItems;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private  Restaurant restaurant;

    @CreationTimestamp
    private LocalDateTime mealPrepTime;
}


/**

    @OneToMany
    private List<Product> product;
    @OneToMany(cascade = CascadeType.PERSIST, fetch= FetchType.EAGER)
    private List<Item> itemList;
    //    @Transient //It means Dont create This attribute shud not be created on the Database
//    We later remove thr @Transient to make the column persistent
//    We also create a column "tottal_price" in our database
//    The intitialize the total_price to 0.0
    private Double totalPrice;

    public void addItem(Item item){
        if(itemList == null){
            itemList = new ArrayList<>(); //The itemList is initialize/instance for one item
        }
        itemList.add(item);
    }

 */