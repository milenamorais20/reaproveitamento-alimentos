package sistema.reaproveitamento.alimentos.project.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mail {
    private final JavaMailSender javaMailSender;

    public Mail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarEmail(String remetente, String destinatario, String assunto, String corpo){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(remetente);
            message.setTo(destinatario);
            message.setSubject(assunto);
            message.setText(corpo);
            javaMailSender.send(message);
        }catch (Exception e){
            System.out.println("Causa: " + e.getCause());
        }

    }
}
