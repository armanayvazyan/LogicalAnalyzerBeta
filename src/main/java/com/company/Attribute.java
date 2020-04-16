package com.company;

public class Attribute {
    String name;
    int value;
    boolean checked = true;

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
