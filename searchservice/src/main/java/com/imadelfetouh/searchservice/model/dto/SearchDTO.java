package com.imadelfetouh.searchservice.model.dto;

import java.io.Serializable;

public class SearchDTO implements Serializable {

    private String itemId;
    private String type;
    private String photo;
    private String description;

    public SearchDTO(String itemId, String type, String photo, String description) {
        this.itemId = itemId;
        this.type = type;
        this.photo = photo;
        this.description = description;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
