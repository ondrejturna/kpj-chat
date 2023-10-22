package cz.inventi.kpj.chat.model;

import lombok.Getter;

/**
 * MessageType represents a type of message.
 */
@Getter
public enum MessageType {
    MESSAGE("message"),
    PRESENCE("presence");

    private final String type;

    MessageType(String type) {
        this.type = type;
    }
}
