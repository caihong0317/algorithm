package com.caihong.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class Structure {
    private List<Element> elements = new ArrayList<>(10);

    public void addElement(Element element) {
        elements.add(element);
    }

    public void removeElement(Element element) {
        elements.remove(element);
    }

    public void accept(Visitor visitor){
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
