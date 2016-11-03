/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBinding;

import DataBinding.Model.Addition;
import DataBinding.Model.Division;
import DataBinding.Model.ExpressionOutput;
import DataBinding.Model.Expressions;
import DataBinding.Model.Multiplication;
import DataBinding.Model.OperatorBase;
import DataBinding.Model.Subtraction;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author YNZ
 */
public class XmlToJavaObject {

    public static void parse(String inputFileName) throws JAXBException {
        String outputFileName = null;
        String postFix = "_result";
        StringBuilder sb = new StringBuilder();
        String[] strs = inputFileName.split("\\.");
        outputFileName = sb.append(strs[0]).append(postFix).append(".xml").toString();

        File file = new File(inputFileName);
        JAXBContext jAXBContext = JAXBContext.newInstance(
                Expressions.class,
                Addition.class,
                Division.class,
                Multiplication.class,
                Subtraction.class,
                OperatorBase.class
        );

        Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
        Expressions expressions = (Expressions) unmarshaller.unmarshal(file);
        expressions.operateAll();
        ExpressionOutput expressionOutput = new ExpressionOutput(expressions.getResult());

        // Creating a Marshaller
        File output = new File(outputFileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(ExpressionOutput.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(expressionOutput, output);

    }

    public static void main(String[] args) {
        try {
            parse("data002.xml");
            parse("data001.xml");
        } catch (JAXBException ex) {
            System.out.println("" + ex.getMessage());
        }

    }

}
