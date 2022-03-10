package com.ethanedmond.spring.stubs;

import com.ethanedmond.spring.model.Tag;

public class TagStub {
    private String name;

    public TagStub() {}

    public TagStub(Tag tag) {
        this.name = tag.getName();
    }

    public TagStub(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
