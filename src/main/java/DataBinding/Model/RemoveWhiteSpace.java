/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBinding.Model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author YNZ
 */
public class RemoveWhiteSpace extends XmlAdapter<String, String>{

    @Override
    public String unmarshal(String v) throws Exception {
        return v.trim().isEmpty()?null:v.trim();
    }

    @Override
    public String marshal(String v) throws Exception {
       return v.trim().isEmpty()?null:v.trim();
    }
    
}
