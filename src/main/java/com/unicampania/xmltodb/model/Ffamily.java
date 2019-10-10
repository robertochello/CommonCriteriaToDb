package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Ffamily {

    @Getter
    @XmlAttribute(name = "name")
    private String name;

    @Getter
    @XmlAttribute(name = "id")
    private String id;

    @Getter
    @XmlElement(name = "ff-behaviour")
    private FfBehaviour ffBehaviour = new FfBehaviour();

    @Getter
    @XmlElement(name = "ff-user-notes")
    private FfUserNotes ffUserNotes = new FfUserNotes();

    @Getter
    @XmlElement(name = "ff-evaluator-notes")
    private FfEvaluatorNotes ffEvaluatorNotes = new FfEvaluatorNotes();

    @Getter
    @XmlElement(name = "f-component")
    private List<FComponent> fComponentList = new ArrayList<>();



}
