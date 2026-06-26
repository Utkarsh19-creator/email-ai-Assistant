package com.example.Fake;

import lombok.Data;

@Data
public class EmailRequest {
    private String sender;
    private String subject;
    private String body;

}
