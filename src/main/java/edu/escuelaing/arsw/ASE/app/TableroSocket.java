package edu.escuelaing.arsw.ASE.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class TableroSocket extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * Registra un endpoint para el websocket
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry endpoint) {
        endpoint.addEndpoint("/stompEndpoint").withSockJS();
    }

    /**
     * Configura el broker de mensajes
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
    }
}
