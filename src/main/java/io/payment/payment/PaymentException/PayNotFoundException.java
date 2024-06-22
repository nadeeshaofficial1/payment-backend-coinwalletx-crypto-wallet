package io.payment.payment.PaymentException;

import java.util.UUID;

public class PayNotFoundException extends RuntimeException {
    public PayNotFoundException(UUID id) {
        super("Could not the found payment with id"+id);

    }
}
