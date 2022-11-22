package com.example.demo.chat;

import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ChatModule {

    private static final Logger log = LoggerFactory.getLogger(ChatModule.class);

    private final SocketIONamespace namespace;

    @Autowired
    public ChatModule(SocketIOServer server) {
        this.namespace = server.addNamespace("");
        this.namespace.addConnectListener(onConnected());
        this.namespace.addDisconnectListener(onDisconnected());
        this.namespace.addEventListener("client-send-message", ChatMessage.class, onChatReceived());
    }

    private DataListener<ChatMessage> onChatReceived() {
        return (client, data, ackSender) -> {
            System.out.println("Nhan duoc r ne");
            ChatMessage chatMessage = (ChatMessage) data;
            log.debug("Client[{}] - Received chat message '{}'", client.getSessionId().toString(), chatMessage);
            namespace.getBroadcastOperations().sendEvent("server-send-message", chatMessage);
            System.out.println("Gui di ne");
        };
    }

    private ConnectListener onConnected() {
        return client -> {
            HandshakeData handshakeData = client.getHandshakeData();
            log.debug("Client[{}] - Connected to chat module through '{}'", client.getSessionId().toString(), handshakeData.getUrl());
        };
    }

    private DisconnectListener onDisconnected() {
        return client -> {
            log.debug("Client[{}] - Disconnected from chat module.", client.getSessionId().toString());
        };
    }


}
