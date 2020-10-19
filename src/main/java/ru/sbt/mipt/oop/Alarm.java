package ru.sbt.mipt.oop;

public class Alarm implements Actionable{
    private final String id;
    private final String password;
    public String state;

    boolean availableState;
    boolean disableState;
    boolean ringingState;

    public Alarm(String id) {
        if (id == null){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.password = null;
        this.state = AlarmStates.disableState;
    }
    public boolean activate(String password) {
        if (state == AlarmStates.availableState) {
            System.out.println("Alarm already activated");
            return false;
        }
        if (!this.password.equals(password)) {
            System.out.println("Wrong PASSWORD!");
            return false;
        }
        state = AlarmStates.availableState;
        System.out.println("Alarm is available!");
        return true;
    }

    public boolean deactivate(String password) {
        if (state == AlarmStates.disableState) {
            return false;
        }
        if (!this.password.equals(password)) {
            System.out.println("Wrong PASSWORD!");
            return false;
        }
        state = AlarmStates.disableState;
        System.out.println("Alarm deactivated");
        return true;
    }

    public String getId() {
        return id;
    }

    public void execute(Action action) {
        action.doAction(this);
    }

    public void activateRinging(){
        state = AlarmStates.ringingState;
        System.out.println("Alarm Ringing!");
    }
}
