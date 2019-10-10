package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;

public class FeAssignment {


    @Getter
    @XmlElement(name = "fe-assignmentitem")
    private FeAssignmentitem feAssignmentitem = new FeAssignmentitem();

    @Getter
    @XmlElement(name = "fe-assignmentnotes")
    private FeAssignmentnotes feAssignmentnotes = new FeAssignmentnotes();
}

