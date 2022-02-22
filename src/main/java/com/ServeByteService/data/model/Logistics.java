package com.ServeByteService.data.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Logistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logisticName;
    private String logisticEmail;
    private String logisticPhone;
    private Double logisticPrice;
    private String logisticLogo;
    private City cityName;
}
