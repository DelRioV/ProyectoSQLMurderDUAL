package org.login.app.email;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.Getter;
import lombok.Setter;


import java.io.*;
import java.util.Properties;

/**
 * <p>Sender class.</p>
 *
 * @author : Ismael Orellano Bello / Pablo Salvador Del Rio Vergara
 * @version : 1.0
 * Class that sends out the email
 */
public class Sender {

    @Setter
    @Getter
    private Properties mailProp = new Properties();
    @Setter
    @Getter
    private Properties credentialProp = new Properties();

    /**
     * Constructor that loads the credential within CredentialsConstants.java
     */
    public Sender() {
        try {
            // Loads all the properties of file "mail.properties".
            mailProp.load(getClass().getClassLoader().getResourceAsStream("mail.properties"));
            credentialProp.load(getClass().getClassLoader().getResourceAsStream("credentials.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that create the email and send it
     *
     * @param from    - String (Emisor)
     * @param to      - String (Remitent)
     * @param subject - String (the subject of the email)
     * @param content - String (the text inside it)
     * @return <ol>
     * <li>boolean true - when is correctly send </li>
     * <li>boolean false - when can´t be send due to an error</li>
     * </ol>
     */
    public boolean send(String from, String to, String subject, String content) {
        // Get the Session object.// and pass username and password
        Session session = createSession();
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(content, "text/html");
            Transport.send(message);
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }

    }

    /**
     * Method that creates the session for send the email
     *
     * @return session - Session
     */
    private Session createSession() {
        Session session = Session.getInstance(mailProp, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(credentialProp.getProperty(CredentialsConstants.USER),
                        credentialProp.getProperty(CredentialsConstants.PASSWD));
            }
        });
        session.setDebug(true);
        return session;
    }


}
