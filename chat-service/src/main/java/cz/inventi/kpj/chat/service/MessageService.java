package cz.inventi.kpj.chat.service;

import cz.inventi.kpj.openapi.model.Message;
import cz.inventi.kpj.openapi.model.MessageRequest;

import java.util.List;
import java.util.UUID;

/**
 * MessageService is a component that is responsible for creating and listing messages.
 */
public interface MessageService {

    /**
     * Creates a new message.
     * @param messageRequest Message to be created.
     * @return ID of the created message.
     */
    UUID createMessage(MessageRequest messageRequest);

    /**
     * Lists all messages that were received since the application was started.
     * @return List of all messages.
     */
    List<Message> listMessages();
}
