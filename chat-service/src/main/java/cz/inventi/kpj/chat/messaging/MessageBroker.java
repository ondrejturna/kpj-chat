package cz.inventi.kpj.chat.messaging;

import cz.inventi.kpj.chat.model.MessageEvent;
import cz.inventi.kpj.openapi.model.MessageRequest;

/**
 * MessageBroker is a component that is responsible for publishing messages to the topic and
 * registering listeners that will be notified when a new message arrives.
 */
public interface MessageBroker {
    /**
     * Publishes a message to the topic.
     * @param messageEvent Message to be published.
     */
    void publish(MessageEvent messageEvent);

    /**
     * Registers a listener that will be notified when a new message arrives.
     * @param listener Listener to be registered.
     */
    void registerListener(MessageListener listener);
}
