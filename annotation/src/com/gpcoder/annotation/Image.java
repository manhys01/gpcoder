package com.gpcoder.annotation;

@XmlRootElement("image")
public class Image {

    @XmlAttribute
    private Long id;

    @XmlElement
    private String name;

    @XmlElement
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
