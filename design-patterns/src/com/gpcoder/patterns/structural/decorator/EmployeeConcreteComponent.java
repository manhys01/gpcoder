package com.gpcoder.patterns.structural.decorator;

import java.util.Date;

public class EmployeeConcreteComponent implements EmployeeComponent {

    private final String name;

    public EmployeeConcreteComponent(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void doTask() {
        System.out.println("Do task");
    }

    @Override
    public void join(Date joinDate) {
        System.out.println("This " + name + " joined on " + formatDate(joinDate));
    }

    @Override
    public void terminate(Date terminateDate) {
        System.out.println("This " + name + " terminated on " + formatDate(terminateDate));
    }

}
