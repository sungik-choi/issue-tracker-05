package com.codesquad.issuetracker.main.domain;

public class Label {

    private Integer id;

    private String name;

    private String description;

    private String hexCode;

    public Label() {}

    private Label(Integer id, String name, String description, String hexCode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hexCode = hexCode;
    }

    public static Label create(Integer id, String name, String description, String hexCode) {
        return new Label(id, name, description, hexCode);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }
}
