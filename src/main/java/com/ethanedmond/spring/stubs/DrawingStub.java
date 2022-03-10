package com.ethanedmond.spring.stubs;

import com.ethanedmond.spring.model.Drawing;

public class DrawingStub {
    private String imageLink;

    public DrawingStub (Drawing drawing) {
        this.imageLink = drawing.getImageLink();
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
