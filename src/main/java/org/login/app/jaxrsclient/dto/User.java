package org.login.app.jaxrsclient.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement
@Getter
@Setter
public class User {

    private String username;
    private String password;
    private int user_code;
    private String email;
}

