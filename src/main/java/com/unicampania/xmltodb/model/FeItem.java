package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlValue;

public class FeItem {

    @Getter
    @XmlMixed
    private String text;

    @Getter
    @XmlElement(name = "fe-assignment")
    private FeAssignment feAssignment = new FeAssignment();

}
