package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

public class Xref {


    @Getter
    @XmlAttribute(name = "show")
    private String show;

    @Getter
    @XmlAttribute(name = "id")
    private String id;

    @Override
    public String toString() {
        return  id.toUpperCase().replaceAll ("\r\n", " ").trim() + " " ;
    }

}
