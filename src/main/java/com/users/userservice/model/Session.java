package com.users.userservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import java.util.Date;


@Entity
public class Session extends BaseModel {

    private String token;
    private Date expiryDate;
    private Date loginDate;

    @ManyToOne
    private User user;

   @Enumerated(EnumType.ORDINAL)
    private SessionStatus sessionStatus;
}
