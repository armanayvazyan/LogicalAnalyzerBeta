package com.company;

import java.util.ArrayList;

class Company {
    private boolean checked = true;
    private String name;
    private int id;
    ArrayList<Attribute> attributes;

    boolean isChecked() {
        return checked;
    }

    int getAttribute(Attribute attribute) {
        for (Attribute attributes : attributes) {
            if (attributes.name.equals(attribute.name)) {
                return attributes.value;
            }
        }
        return 0;
    }

    Company(String name, int id, ArrayList<Attribute> attributes) {
        this.name = name;
        this.id = id;
        this.attributes = attributes;
    }
}

