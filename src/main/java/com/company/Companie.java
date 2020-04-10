package com.company;

import java.util.ArrayList;

public class Companie {
    private boolean checked;
    private String name;
    private int id;
    ArrayList<Attribute> attributes;

    public boolean isChecked() {
        return checked;
    }

    public int getAttribute(Attribute attribute) {
        for (Attribute attributes : attributes) {
            if (attributes.name.equals(attribute.name)) {
                return attributes.value;
            }
        }
        return 0;
    }

    public Companie(String name, int id, ArrayList<Attribute> attributes) {
        this.name = name;
        this.id = id;
        this.attributes = attributes;
    }
}

