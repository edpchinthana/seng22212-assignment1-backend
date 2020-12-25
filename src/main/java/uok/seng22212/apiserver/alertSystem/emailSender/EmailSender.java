package uok.seng22212.apiserver.alertSystem.emailSender;

import uok.seng22212.apiserver.models.Alert;
import uok.seng22212.apiserver.models.AlertSubscriber;

import java.util.List;

public interface EmailSender {
    void sendEmails(Alert alert, List<AlertSubscriber> alertSubscriberList);
}
