package com.unicampania.xmltodb.model;

import lombok.Getter;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class SubClause {

    @Getter
    @XmlAttribute(name = "id")
    private String id;

    @Getter
    @XmlAttribute(name = "title")
    private String title;

    @Getter
    @XmlElement(name = "para")
    private List<Para> p = new ArrayList<>();


}
