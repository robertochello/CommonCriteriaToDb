package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class FeList {

    @Getter
    @XmlElement(name = "fe-item")
    private List<FeItem> feItemList = new ArrayList<>();
 }
