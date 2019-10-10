package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Lists {

    @Getter
    @XmlAttribute(name = "type")
    private String type;

    @Getter
    @XmlElement(name = "item")
    private List<Item> item = new ArrayList<>();


}
