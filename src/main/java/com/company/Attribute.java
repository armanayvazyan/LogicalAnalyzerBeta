package com.company;

public class Attribute {
    String name;
    int value;
    boolean checked = true;

    public int getValue() {
        return value;
    }

    boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attribute(String name) {
        this.name = name;
    }

    Attribute(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
