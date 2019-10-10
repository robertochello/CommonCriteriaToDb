package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class FcoManagement {


    @Getter
    @XmlAttribute(name = "equal")
    private String equal= "";

    @Getter
    @XmlValue
    private String value ;
}
