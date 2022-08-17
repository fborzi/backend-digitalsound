package com.digitalsound.paginaweb.dto;

import lombok.Getter;
import lombok.Setter;

public class Message {
    @Getter @Setter
    private String message;

    public Message(String mensaje) {
        this.message = mensaje;
    }
}
