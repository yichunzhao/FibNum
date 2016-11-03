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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YNZ
 */
@XmlRootElement(name = "expressions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Expressions {
    
    @XmlAnyElement(lax = true)
    List<Operator> operators;

    @XmlElement
    List<Result> result;

    public Expressions() {
        operators = new ArrayList<>();
        result = new ArrayList<>();
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public List<Result> getResult() {
        return result;
    }

    private void setResult(Result result) {
        this.result.add(result);
    }
    
    public void operateAll(){
        for(Operator operator:operators){
            operator.operate();
            setResult(operator.getResult());
        }
    }
}
