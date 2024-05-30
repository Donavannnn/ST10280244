/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandregistration;

/**
 *
 * @author donav
 */public class Task {
    private static int taskCounter = 1;
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;
    private String taskId;

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskCounter++;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskId = createTaskId();
    }

    public boolean checkTaskDescription() {
        return this.taskDescription.length() <= 50;
    }

    public String createTaskId() {
        String firstTwoLetters = this.taskName.substring(0, 2).toUpperCase();
        String lastThreeLetters = this.developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return firstTwoLetters + ":" + this.taskNumber + ":" + lastThreeLetters;
    }

    public String printTaskDetails() {
        return "Task Status: " + this.taskStatus + "\n"
                + "Developer Details: " + this.developerDetails + "\n"
                + "Task Number: " + this.taskNumber + "\n"
                + "Task Name: " + this.taskName + "\n"
                + "Task Description: " + this.taskDescription + "\n"
                + "Task ID: " + this.taskId + "\n"
                + "Duration: " + this.taskDuration + " hours";
    }
}

