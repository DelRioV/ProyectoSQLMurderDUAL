package org.login.app.jaxrsclient.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

/**
 * <p>User class.</p>
 *
 * @author : Ismael Orellana Bello / Pablo Salvador Del Río Vergara
 * @version : 1.0
 * Class that keeps the user information
 */
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

