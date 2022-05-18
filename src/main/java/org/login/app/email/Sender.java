package org.login.app.email;


import lombok.Getter;
import lombok.Setter;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.Properties;



public class Sender {

    @Setter
    @Getter
    Properties mailProp = new Properties();
    @Setter
    @Getter
    Properties credentialProp = new Properties();
    public Sender() {
        try {
            // Loads all the properties of file "mail.properties".
            System.out.println(getClass().getResource("email.config.properties/credentials.properties"));
            mailProp.load(getClass().getClassLoader().getResourceAsStream("email.config.properties/mail.properties"));
            credentialProp.load(getClass().getClassLoader().getResourceAsStream("email.config.properties/credentials.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean send(String from, String to, String subject, String content) {
        // Get the Session object.// and pass username and password
        Session session = createSession();
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject(subject);
            // Now set the actual message
            message.setContent(content,"text/html" );
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }

    }

    private Session createSession() {
        Session session = Session.getInstance(mailProp, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(credentialProp.getProperty(CredentialsConstants.USER),
                        credentialProp.getProperty(CredentialsConstants.PASSWD));
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        return session;
    }



    public static void main(String[] args) throws FileNotFoundException, IOException {
        new Sender().send("sqlmurderproyect@gmail.com","xxismaelor03xx@gmail.com", "Hola =D",
                "<b>Te mando un saludo desde java<b>");
    }

}