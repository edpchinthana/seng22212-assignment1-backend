package uok.seng22212.apiserver.repositories;

import uok.seng22212.apiserver.models.AlertSubscriber;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface AlertSubscriberRepository {

    void addSubscriber(AlertSubscriber alertSubscriber);
    List<AlertSubscriber> getAllSubscribers() throws ExecutionException, InterruptedException;
    void deleteSubscriber(String subscriberId);
}
