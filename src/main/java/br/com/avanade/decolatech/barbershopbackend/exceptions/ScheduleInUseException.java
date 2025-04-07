package br.com.avanade.decolatech.barbershopbackend.exceptions;

public class ScheduleInUseException extends RuntimeException {

    public ScheduleInUseException(String message) {
        super(message);
    }

}
