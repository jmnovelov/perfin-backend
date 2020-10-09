package com.perfin.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Period {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long periodId;

    private LocalDate startAt;

    private LocalDate endAt;

    private double baseline;

    protected Period() {

    }

    public Period(LocalDate startAt, LocalDate endAt, double baseline) {
        this.startAt = startAt;
        this.endAt = endAt;
        this.baseline = baseline;
    }

    public LocalDate getEndAt() {
        return endAt;
    }
    
    public LocalDate getStartAt() {
        return startAt;
    }

    public double getBaseline() {
        return baseline;
    }

    public Long getPeriodId() {
        return periodId;
    }
}