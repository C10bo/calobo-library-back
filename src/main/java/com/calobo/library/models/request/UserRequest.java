package com.calobo.library.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    
    private String name;
    private String lastName;
    private String email;
    private String birthDate;

}
