package edu.miu.nomin.jpa.assignment.service;

import edu.miu.nomin.jpa.assignment.entity.Logger;
import edu.miu.nomin.jpa.assignment.repository.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {
    private static final String FAKE_USER = "fakeUser";
    @Autowired
    private LoggerRepository loggerRepository;
    public void logOperation(String operationDescription) {
        Logger logger = new Logger(FAKE_USER, operationDescription);
        loggerRepository.save(logger);
    }
}
