package com.example.demo.Messages;

import com.example.demo.Entity.UserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserMessage extends BaseMessage{
    public UserMessage() {
        super(true, "user");
        this.data = data;
    }
    private Iterable<UserEntity> data;
}
