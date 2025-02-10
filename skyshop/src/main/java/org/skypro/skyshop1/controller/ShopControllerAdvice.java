package org.skypro.skyshop1.controller;

import org.skypro.skyshop1.exception.NoSuchProductException;
import org.skypro.skyshop1.model.error.ShopError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ShopControllerAdvice {

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> handleNoSuchProductException(NoSuchProductException ex) {
        ShopError shopError = new ShopError("404", "Извините, товар с указанным идентификатором не найден.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(shopError);
    }
}
