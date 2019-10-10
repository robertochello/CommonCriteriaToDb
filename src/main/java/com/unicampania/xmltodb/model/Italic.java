package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlValue;

public class Italic {

    @Getter
    @XmlValue
    private String text;


    @Override
    public String toString() {
        return  text.replaceAll ("\r\n", " ").trim() + " " ;
    }

}
