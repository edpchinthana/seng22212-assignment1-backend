package uok.seng22212.apiserver.alertSystem.emailSender;

import uok.seng22212.apiserver.models.Alert;

public interface EmailFormatter {
    String getEmailBody(Alert alert);
}
