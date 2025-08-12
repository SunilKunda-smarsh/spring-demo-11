package com.smarsh.spring_demo_11.support;

import com.smarsh.spring_demo_11.model.Notification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class NotificationClient {
    private RestClient restClient;

    public NotificationClient(@Value("${notification.service.base.url}") String baseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public void sendNotification(Notification notification) {
        restClient.post()
                .uri("/v1/notifications")
                .body(notification)
                .retrieve()
                .body(String.class);
    }



}
