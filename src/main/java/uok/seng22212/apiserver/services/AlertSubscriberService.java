package uok.seng22212.apiserver.services;

import uok.seng22212.apiserver.models.AlertSubscriber;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface AlertSubscriberService {
    void addSubscriber(AlertSubscriber alertSubscriber);
    List<AlertSubscriber> getAllSubscribers() throws ExecutionException, InterruptedException;
    void deleteSubscriebr(String subscriberId);
}
