package com.ethanedmond.spring.stubs;

import com.ethanedmond.spring.model.ReferenceImage;

public class ReferenceStub {
    private String imageLink;

    public ReferenceStub(ReferenceImage referenceImage) {
        this.imageLink = referenceImage.getImageLink();
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
