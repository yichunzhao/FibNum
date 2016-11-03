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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YNZ
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "expressions")
public class ExpressionOutput {

    @XmlElement(name = "result")
    List<Result> results;

    public ExpressionOutput() {
        results = new ArrayList<>();
    }

    public ExpressionOutput(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
