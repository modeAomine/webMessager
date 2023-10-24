package com.example.demo.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BaseMessage {
    protected boolean success;
    protected String message;
}
