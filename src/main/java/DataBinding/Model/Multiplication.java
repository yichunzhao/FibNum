/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBinding.Model;

import DataBinding.service.ExpressionService;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YNZ
 */
@XmlRootElement(name = "multiplication")
@XmlAccessorType(XmlAccessType.FIELD)
public class Multiplication extends OperatorBase {

    @XmlElement(name = "factor")
    List<Factor> factors;

    public Multiplication() {
        factors = new ArrayList<>();
    }

    public List<Factor> getFactor() {
        return factors;
    }

    public void setFactor(List<Factor> factor) {
        this.factors = factor;
    }

    @Override
    public void operate() {
        setResult(new Result(id, ExpressionService.complexMultiplication(factors)));
    }
}
