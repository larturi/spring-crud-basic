package com.larturi.ar.model.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder
public class ClientDto implements Serializable {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String createdAt;
}
