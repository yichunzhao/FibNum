/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBinding.Model;

import DataBinding.service.ExpressionService;
import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YNZ
 */
@XmlRootElement(name = "addition")
@XmlAccessorType(XmlAccessType.FIELD)
public class Addition extends OperatorBase {

    @XmlElement(name = "item")
    private List<Item> items;

    public Addition() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public void operate() {
        setResult(new Result(id, ExpressionService.complexAddition(items)));
    }
}
