package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import java.util.ArrayList;
import java.util.List;

public class Item {

    @Getter
    @XmlAttribute(name = "id")
    private String id;

    @Getter
    @XmlMixed
    private List<String> value = new ArrayList<>();

    @Getter
    @XmlElement(name = "list")
    private List<Lists> lists = new ArrayList<>();

    @Getter
    @XmlElement(name = "xref")
    private List<Xref> xrefs = new ArrayList<>();

    @Getter
    @XmlElement(name = "para")
    private List<Para> para = new ArrayList<>();


    @Getter
    @XmlElement(name = "bold")
    private Bold bold = new Bold();

    private List<String> boldItem = new ArrayList<>();

    public List<String> getBoldItem() {
        return getItemBold(value,bold);
    }

    public List<String> getCombo() {
        return merge(value, xrefs);
    }

    public static List<String> merge(List<String> a, List<Xref> b) {

        List<String> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {

            res.add(a.get(i).replaceAll("\r\n", " ").trim());
            if (b.size() != i && b.size() != 0) {
                res.add(b.get(i).toString().replace("[", "").replace("]", "").replaceAll("\r\n", " ").trim());
            }
        }
        return res;

    }

    private List<String> getItemBold(List<String> a , Bold b){

        List<String> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if(i==0 && b.getValue()!= null) {
                res.add(b.getValue());
            }
            res.add(a.get(i).replaceAll("\r\n", " ").trim());

        }

        return res;
    }
}
