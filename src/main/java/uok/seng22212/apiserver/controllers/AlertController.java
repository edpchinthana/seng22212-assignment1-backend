package uok.seng22212.apiserver.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uok.seng22212.apiserver.alertSystem.AlertSystem;
import uok.seng22212.apiserver.models.Alert;
import uok.seng22212.apiserver.models.AlertSubscriber;

import java.util.List;

@RestController
@RequestMapping("api/alert")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlertController {

    @Autowired
    AlertSystem alertSystem;

    private final Logger LOGGER = LoggerFactory.getLogger(AlertController.class);

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<?> getAlertHistory(){
        try{
            List<Alert> alertHistory = alertSystem.getAlertHistory();
            return ResponseEntity.status(HttpStatus.OK).body(alertHistory);
        }catch (Exception e){
            LOGGER.error("GET ALERT HISTORY  ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }
}
