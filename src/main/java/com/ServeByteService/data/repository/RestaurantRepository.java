package com.ServeByteService.data.repository;

import com.ServeByteService.data.model.City;
import com.ServeByteService.data.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCityName(City city);
    Optional<Restaurant> findByRestaurantEmail(String email);
}



/**
 *
 * The @JsonCreator annotation is sufficient only to interpret JSON data into enumerations
 *
 *an enum value arrives through the path or through a request param?
 *
 * AttributeConvertEnItemTypeype, String>. Implements the following methods :
 * <ul>
 * <li>convertToDatabaseColumn : (given an Enum returns a String)
 * <li>convertToEntityAttribute : (given a String returns an Enum)
 *
 *
*/


 /*
@Component
@Converter(autoApply = true)
public class EnItemTypeConverter implements AttributeConverter<EnItemType, String> {

    @Override
    public String convertToDatabaseColumn(final EnItemType attribute) {
        return Optional.ofNullable(attribute).map(EnItemType::getCode).orElse(null);
    }

    @Override
    public EnItemType convertToEntityAttribute(final String dbData) {
        return EnItemType.decode(dbData);
    }
}*/


//User==>SearchByCity==> Resturant(Are they in the same city)===>Meal(quantity * price)===>Make an Order==>
//PaymentService=====>send Mail(text/email)
