package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

public class FcoRationale {

    @Getter
    @XmlElement(name = "para")
    private Para p = new Para();
}
