package com.smarsh.spring_demo_11.model;

import lombok.Data;

@Data
public class Notification {
    private String recipient;
    private String message;
    private String subject;
}
