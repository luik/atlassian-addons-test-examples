package com.milkneko.dev.confluence_4_rest_service.bean;

import java.io.Serializable;

public class RecordBean implements Serializable {
    private int id;
    private String value;
    private boolean stored;

    public RecordBean() {
    }

    public RecordBean(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isStored() {
        return stored;
    }

    public void setStored(boolean stored) {
        this.stored = stored;
    }
}
