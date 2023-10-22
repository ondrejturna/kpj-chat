package cz.inventi.kpj.chat.web.rest;

import cz.inventi.kpj.chat.service.MessageService;
import cz.inventi.kpj.openapi.api.MessagesApi;
import cz.inventi.kpj.openapi.model.Message;
import cz.inventi.kpj.openapi.model.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
public class MessageRestController implements MessagesApi {

    @Autowired
    private MessageService messageService;

    @Override
    public ResponseEntity<Void> createMessage(MessageRequest messageRequest) {
        UUID messageId = messageService.createMessage(messageRequest);

        return ResponseEntity.created(UriComponentsBuilder.fromPath("/message/" + messageId.toString()).build().toUri()).build();
    }

    @Override
    public ResponseEntity<List<Message>> listMessages() {
        return ResponseEntity.ok(messageService.listMessages());
    }
}
