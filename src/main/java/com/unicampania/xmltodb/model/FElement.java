package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;

import java.util.ArrayList;
import java.util.List;

public class FElement {

    @Getter
    @XmlAttribute(name = "id")
    private String id;

    @Getter
    @XmlMixed
    private List<String> value = new ArrayList<>();

    @Getter
    @XmlElement(name = "fe-assignment")
    private List<FeAssignment>  feAssignmentList= new ArrayList();

    @Getter
    @XmlElement(name = "fe-list")
    private List<FeList> feLists = new ArrayList<>();

    private List<String> idf = new ArrayList<>();

    public List<String> getIdf() {
        return setIdf(value,id);
    }

    public List<String> setIdf(List<String> a, String b){

        List<String> idflist = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            idflist.add(b.concat(String.valueOf(i)));
        }

        return idflist;
    }

}