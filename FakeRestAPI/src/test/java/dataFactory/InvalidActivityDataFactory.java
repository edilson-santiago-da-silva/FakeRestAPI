package dataFactory;

import pojo.InvalidActivitiesPojo;

public class InvalidActivityDataFactory {
    public static InvalidActivitiesPojo cadastrarAtividadeInvalida() {
        InvalidActivitiesPojo invalidActivity = new InvalidActivitiesPojo();
        invalidActivity.setId("a");
        invalidActivity.setTitle("Activity");
        invalidActivity.setDueDate("2022-08-16T13:50:38.902Z");
        invalidActivity.setCompleted(true);
        return invalidActivity;

    }
}
