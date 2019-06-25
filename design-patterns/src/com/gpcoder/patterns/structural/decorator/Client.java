package com.gpcoder.patterns.structural.decorator;

public class Client {

    public static void main(String[] args) {
        System.out.println("Normal employee");
        EmployeeComponent employee = new EmployeeConcreteComponent("manhnd");
        employee.showBasicInformation();
        employee.doTask();

        System.out.println("\nTeam leader");
        EmployeeComponent teamLeader = new TeamLeader(employee);
        teamLeader.showBasicInformation();
        teamLeader.doTask();

        System.out.println("\nManager");
        EmployeeComponent manager = new Manager(employee);
        manager.showBasicInformation();
        manager.doTask();

        System.out.println("\nTeam Member");
        EmployeeComponent member = new TeamMember(employee);
        member.showBasicInformation();
        member.doTask();

        System.out.println("\nLeader and manager");
        EmployeeComponent leaderAndManager = new Manager(teamLeader);
        leaderAndManager.showBasicInformation();
        leaderAndManager.doTask();

    }

}
