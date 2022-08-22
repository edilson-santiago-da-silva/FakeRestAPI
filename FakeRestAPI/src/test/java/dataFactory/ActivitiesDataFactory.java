package dataFactory;

import pojo.ActivitiesPojo;

public class ActivitiesDataFactory {
    public static ActivitiesPojo cadastrarAtividadeValida() {
        ActivitiesPojo activities = new ActivitiesPojo();
        activities.setId(31);
        activities.setTitle("atividade 31");
        activities.setDueDate("2022-08-16T13:50:38.902Z");
        activities.setCompleted(true);
        return activities;
    }
}
