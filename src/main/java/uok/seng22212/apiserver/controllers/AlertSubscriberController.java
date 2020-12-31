package uok.seng22212.apiserver.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uok.seng22212.apiserver.models.AlertSubscriber;
import uok.seng22212.apiserver.models.Sensor;
import uok.seng22212.apiserver.services.AlertSubscriberService;

import java.util.List;

@RestController
@RequestMapping("api/alertSubscriber")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlertSubscriberController {

    @Autowired
    AlertSubscriberService alertSubscriberService;

    private final Logger LOGGER = LoggerFactory.getLogger(AlertSubscriberController.class);

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<?> getAllSubscribers(){
        try{
            List<AlertSubscriber> alertSubscriberList = alertSubscriberService.getAllSubscribers();
            return ResponseEntity.status(HttpStatus.OK).body(alertSubscriberList);
        }catch (Exception e){
            LOGGER.error("GET ALERT SUBSCRIBERS  ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<?> addAlertSubscriber (@RequestBody AlertSubscriber alertSubscriber){
        try{
            alertSubscriberService.addSubscriber(alertSubscriber);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            LOGGER.error("ADD ALERT SUBSCRIBER ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }

    @RequestMapping(value="", method = RequestMethod.DELETE)
    public ResponseEntity<?> addAlertSubscriber (@RequestParam String subscriberId){
        try{
            alertSubscriberService.deleteSubscriebr(subscriberId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            LOGGER.error("DELETE ALERT SUBSCRIBER ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }


}
