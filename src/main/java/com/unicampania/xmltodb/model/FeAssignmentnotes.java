package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

public class FeAssignmentnotes {

    @Getter
    @XmlElement(name = "para")
    private Para p = new Para();
}
