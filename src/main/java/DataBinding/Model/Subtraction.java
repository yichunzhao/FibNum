/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBinding.Model;

import DataBinding.service.ExpressionService;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author YNZ
 */
@XmlType(propOrder = {"minuend", "subtrahend"})
@XmlRootElement(name = "subtraction")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subtraction extends OperatorBase {

    @XmlElement
    private String minuend;
    @XmlElement
    private String subtrahend;

    public Subtraction() {
    }

    public String getMinuend() {
        return minuend;
    }

    public void setMinuend(String minuend) {
        this.minuend = minuend;
    }

    public String getSubtrahend() {
        return subtrahend;
    }

    public void setSubtrahend(String subtrahend) {
        this.subtrahend = subtrahend;
    }

    @Override
    public void operate() {
        if (complex == null) {
            setResult(new Result(id, ExpressionService.simpleSubtraction(minuend, subtrahend)));
        }
    }

}
