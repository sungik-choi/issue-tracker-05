package com.codesquad.issuetracker.hamill.domain;

import java.time.LocalDateTime;

public class Label {

    private Integer id;

    private String name;

    private String description;

    private String hexCode;

    private Label(Integer id, String name, String description, String hexCode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hexCode = hexCode;
    }

    public static Label of(Integer id, String name, String description, String hexCode) {
        return new Builder()
                .id(id)
                .name(name)
                .description(description)
                .hexCode(hexCode)
                .build();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getHexCode() {
        return hexCode;
    }

    private static class Builder {
        private Integer id;
        private String name;
        private String description;
        private String hexCode;

        private Builder() {}

        private Builder id(Integer id) {
            this.id = id;
            return this;
        }

        private Builder name(String name) {
            this.name = name;
            return this;
        }

        private Builder description(String description) {
            this.description = description;
            return this;
        }

        private Builder hexCode(String hexCode) {
            this.hexCode = hexCode;
            return this;
        }

        private Label build() {
            return new Label(id, name, description, hexCode);
        }
    }

}
