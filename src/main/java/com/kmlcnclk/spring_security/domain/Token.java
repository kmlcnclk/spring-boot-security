package com.kmlcnclk.spring_security.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tokens")
public class Token {

    @Id
    private ObjectId id;

    private String token;

    @Builder.Default
    private TokenType tokenType = TokenType.BEARER;

    private boolean revoked;
    private boolean expired;

    @DBRef
    private User user;
}
