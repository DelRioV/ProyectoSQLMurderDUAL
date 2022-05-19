package org.login.app.jaxrsclient.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {

    private String username;
    private String password;
    private int user_code;
    private String email;
}

