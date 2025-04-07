package br.com.avanade.decolatech.barbershopbackend.exceptions;

public class EmailInUseException extends RuntimeException {

    public EmailInUseException(String message) {
        super(message);
    }

}
