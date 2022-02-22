package com.ServeByteService.data.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

public enum City {
  ABUJA ,LAGOS, IBADAN, UYO, PORTHARCOURT,
    ENUGU,
    ASABA,
    KANO,
    UMUAHIA,
    ONITSHA,
    ABA,
    OWERRI;
}





/*
*
*  private ValidationResult passwordValidator(String pass1, ValueContext ctx) {
       /*
        * Just a simple length check. A real version should check for password
        * complexity as well!
//        */
//
//       if (pass1 == null || pass1.length() < 8) {
//        return ValidationResult.error("Password should be at least 8 characters long");
//        }
//
//        if (!enablePasswordValidation) {
//        // user hasn't visited the field yet, so don't validate just yet, but next time.
//        enablePasswordValidation = true;
//        return ValidationResult.ok();
//        }
//
//        String pass2 = registrationForm.getPasswordConfirmField().getValue();
//
//        if (pass1 != null && pass1.equals(pass2)) {
//        return ValidationResult.ok();
//        }
//
//        return ValidationResult.error("Passwords do not match");
//        }
//
///**
// * We call this method when form submission has succeeded
// */
//private void showSuccess(UserDetails userBean) {
//        Notification notification =
//        Notification.show("Data saved, welcome " + userBean.getFirstName());
//        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
//
//        // Here you'd typically redirect the user to another view
//        }
//
//        }
