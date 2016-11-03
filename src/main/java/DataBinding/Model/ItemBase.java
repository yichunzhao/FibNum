/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBinding.Model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author YNZ
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ItemBase {

    @XmlAnyElement(lax = true)
    protected List<Operator> operator;

    @XmlMixed
    @XmlJavaTypeAdapter(RemoveWhiteSpace.class)
    protected List<String> text;

    public ItemBase() {
        operator = new ArrayList<>();
        text = new ArrayList<>();
    }

    public List<Operator> getOperator() {
        return operator;
    }

    public void setOperator(List<Operator> operator) {
        this.operator = operator;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

}
