package com.example.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class MessageListenerTest {

    @SpyBean
    private MessageListener messageListener;

    @Test
    public void testListen() {
        // Arrange
        String testMessage = "Test message";
        Message message = new Message(testMessage.getBytes(), new MessageProperties());

        // Act
        doNothing().when(messageListener).listen(testMessage);
        messageListener.listen(testMessage);

        // Assert
        verify(messageListener).listen(testMessage);
    }
}
