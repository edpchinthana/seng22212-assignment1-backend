package uok.seng22212.apiserver.alertSystem.emailSender;

import uok.seng22212.apiserver.models.Alert;

public interface EmailFormatter {
    String getEmailSubject();
    String getEmailBody(Alert alert);
}
