package com.alkemy.icons.icons.service.implementacion;

import com.alkemy.icons.icons.service.EmailService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.io.IOException;

public class EmailServiceImpl implements EmailService {

    @Autowired
    Environment env;

    @Value("${alkemy.icons.email.sender}")
    private String emailSender;
    @Value("${alkemy.icons.email.enabled}")
    private boolean enabled;


    @Override
    public void sendWelcomeEmail(String to) {
        if (!enabled){
            return;
        }
        
        String apiKey = env.getProperty("EMAIL_API_KEY");

        Email fromEmail = new Email(emailSender);
        Email toEmail = new Email(to);

        Content content = new Content(
                "text/plain",
                "Bienvenido a Alkemy icons"
        );

        String subject = "Alkemy icons";

        Mail mail = new Mail(fromEmail, subject,toEmail,content);
        SendGrid sg = new SendGrid(apiKey);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
        }catch (IOException e){
            System.out.println("Error trying to send email");
        }

    }
}
