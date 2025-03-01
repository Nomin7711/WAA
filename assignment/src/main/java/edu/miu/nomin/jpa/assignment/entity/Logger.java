package edu.miu.nomin.jpa.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Logger {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private LocalDate date;
    private LocalTime logtime;
    private String principle;
    private String operation;
    public Logger() {}
    public Logger(LocalDate date, LocalTime time, String principle, String operation) {
        this.date = date;
        this.logtime = time;
        this.principle = principle;
        this.operation = operation;
    }
    public Logger(String principle, String operation) {
        this.date = LocalDate.now();
        this.logtime = LocalTime.now();
        this.principle = principle;
        this.operation = operation;
    }
}
