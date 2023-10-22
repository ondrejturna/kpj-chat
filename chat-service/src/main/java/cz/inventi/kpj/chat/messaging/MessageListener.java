package cz.inventi.kpj.chat.messaging;

import cz.inventi.kpj.chat.model.MessageEvent;

/** MessageListener is a component that is notified when a new message arrives. */
public interface MessageListener {

    /**
     * Called when a new message arrives.
     * @param messageEvent Message that was received.
     */
    void onMessage(MessageEvent messageEvent);
}
