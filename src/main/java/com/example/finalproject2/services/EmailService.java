package com.example.finalproject2.services;



import com.example.finalproject2.models.Booking;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;



@Service
public class EmailService {

    private final TemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;

    public EmailService(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
    }

    public String sendMail(Booking booking) throws MessagingException{
        Context context = new Context();
        context.setVariable("booking", booking);

        String process = templateEngine.process("confirmation", context);
        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom("spotforwellness2021@gmail.com");
        helper.setSubject("Booking Confirmation");
        helper.setText(process, true);
        helper.setTo(booking.getEmail());
        javaMailSender.send(mimeMessage);
        return "Sent";
    }


}