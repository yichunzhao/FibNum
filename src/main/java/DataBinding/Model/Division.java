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
@XmlRootElement(name = "division")
@XmlAccessorType(XmlAccessType.FIELD)
public class Division extends OperatorBase {

    @XmlElement
    private String dividend;
    @XmlElement
    private List<Divisor> divisor;

    public Division() {
        divisor = new ArrayList<>();
    }

    public String getDividend() {
        return dividend;
    }

    public void setDividend(String dividend) {
        this.dividend = dividend;
    }

    public List<Divisor> getDivisor() {
        return divisor;
    }

    public void setDivisor(List<Divisor> divisor) {
        this.divisor = divisor;
    }

    @Override
    public void operate() {
        setResult(new Result(id, ExpressionService.complexDivision(dividend, divisor)));
    }
}
