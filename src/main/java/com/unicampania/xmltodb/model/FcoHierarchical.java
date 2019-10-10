package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

public class FcoHierarchical {

    @Getter
    @XmlAttribute(name = "fcomponent")
    private String fcomponent;
}
