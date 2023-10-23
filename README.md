# KPJ Messaging

## Requirements

- Java 17+
- Maven 3.6.0+

## Preparation

- First, you need to push the `api` module to your local Maven repository: `cd api && mvn install`
- Then, you can actually build the service: `cd chat-service && mvn clean compile && mvn spring-boot:run` (and every time you change something) – or use IDE.
- After that, your service is available on `http://localhost:8082`

## Step by step

- [ ] Enable JMS in `ChatApplication` – `@EnableJms`
- [ ] Enable Scheduling in `ChatApplication` – `@EnableScheduling`
- [ ] Implement message sending via REST API in `MessageServiceImpl#createMessage`
- [ ] Implement message receiving via JMS in `MessageServiceImpl#onMessage`
- [ ] Implement presence sending via scheduled call in `MessageServiceImpl#sendPresence` with `@Scheduled`


![Sequence](sequence.png)

## Definition of done

### Message sending

```shell
http GET localhost:8082/messages # returns all messages received during the app runtime
```

### Message receiving

```shell
http POST localhost:8082/messages name=John message=Hello # sends a message and returns its ID; the message can be received via GET /messages
```

### Presence sending

Presence update is sent every 10 seconds. It is not a part of the GET /messages response.