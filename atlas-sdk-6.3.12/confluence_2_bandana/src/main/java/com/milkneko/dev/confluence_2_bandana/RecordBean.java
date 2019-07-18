package com.milkneko.dev.confluence_2_bandana;

import java.io.Serializable;

public class RecordBean implements Serializable {
    private int attribute1;
    private String attribute2;

    public RecordBean() {
    }

    public RecordBean(int attribute1, String attribute2) {
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
    }

    public int getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(int attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }
}
