package com.unicampania.xmltodb.model;



import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "f-class")
public class Fclass {

        @Getter
        @XmlAttribute(name = "id")
        private String id;

        @Getter
        @XmlAttribute(name="name")
        private String name;

        @Getter
        @XmlElement(name = "fc-introduction")
        private FcIntroduction fcIntroduction = new FcIntroduction();

        @Getter
        @XmlElement(name = "fc-informative-notes")
        private FcInformativeNotes fcInformativeNotes = new FcInformativeNotes();

        @Getter
        @XmlElement(name = "f-family")
        private List<Ffamily> ffamilyList = new ArrayList<>();
}
