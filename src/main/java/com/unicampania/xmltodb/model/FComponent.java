package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class FComponent {

    @Getter
    @XmlAttribute(name = "id")
    private String id;

    @Getter
    @XmlAttribute(name = "name")
    private String name;

    @Getter
    @XmlElement(name = "fco-hierarchical")
    private FcoHierarchical fcoHierarchical = new FcoHierarchical();

    @Getter
    @XmlElement(name = "fco-dependencies")
    private FcoDependencies fcoDependencies = new FcoDependencies();

    @Getter
    @XmlElement(name = "fco-user-notes")
    private FcoUserNotes fcoUserNotes = new FcoUserNotes();

    @Getter
    @XmlElement(name = "fco-evaluator-notes")
    private FcoEvaluatorNotes fcoEvaluatorNotes = new FcoEvaluatorNotes();

    @Getter
    @XmlElement(name = "fco-levelling")
    private FcoLevelling fcoLevelling = new FcoLevelling();

    @Getter
    @XmlElement(name = "fco-management")
    private List<FcoManagement> fcoManagementList = new ArrayList<>();

    @Getter
    @XmlElement(name = "fco-audit")
    private List<FcoAudit> fcoAuditList = new ArrayList<>();

    @Getter
    @XmlElement(name = "fco-rationale")
    private FcoRationale fcoRationale = new FcoRationale();


    @Getter
    @XmlElement(name = "f-element")
    private List<FElement> fElements = new ArrayList<>();
}
