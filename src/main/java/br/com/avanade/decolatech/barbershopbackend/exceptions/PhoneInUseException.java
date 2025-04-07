package br.com.avanade.decolatech.barbershopbackend.exceptions;

public class PhoneInUseException extends RuntimeException {

    public PhoneInUseException(String message) {
        super(message);
    }

}
