package com.perfin.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Budget {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long budgetId;

    private String name;

    private double total;

    @ManyToOne
    private Period periodId;

    protected Budget() {
    }

    public Budget(String name, double total, Period periodId) {
        this.name = name;
        this.total = total;
        this.periodId = periodId;
    }

    public Long getBudgetId() {
        return budgetId;
    }

    public String getName() {
        return name;
    }

    public double getTotal() {
        return total;
    }

    public Period getPeriodId() {
        return periodId;
    }
}
