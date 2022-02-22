package com.ServeByteService.data.model;


import lombok.Data;

import javax.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private City cityName;
}
