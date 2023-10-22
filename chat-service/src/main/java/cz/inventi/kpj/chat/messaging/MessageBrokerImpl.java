package cz.inventi.kpj.chat.messaging;

import cz.inventi.kpj.chat.mapper.MessageMapper;
import cz.inventi.kpj.chat.model.MessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageBrokerImpl implements MessageBroker {

    private static final String DESTINATION = "chat";
    private static final String SUBSCRIPTION_NAME = "${spring.jms.servicebus.topic-client-id}";

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private MessageMapper messageMapper;

    private final List<MessageListener> listeners = new ArrayList<>();

    @Override
    public void publish(MessageEvent messageEvent) {
        jmsTemplate.convertAndSend(DESTINATION, messageEvent);
    }

    @Override
    public void registerListener(MessageListener listener) {
        listeners.add(listener);
    }

    @JmsListener(destination = DESTINATION, containerFactory = "topicJmsListenerContainerFactory", subscription = SUBSCRIPTION_NAME)
    public void receiveMessage(MessageEvent event) {
        listeners.forEach(listener -> listener.onMessage(event));
    }
}
