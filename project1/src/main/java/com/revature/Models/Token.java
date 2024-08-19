package com.revature.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer token_id;

    @Column(unique=true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;
    @Column
    public boolean revoked;
    @Column
    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    public User user;

}