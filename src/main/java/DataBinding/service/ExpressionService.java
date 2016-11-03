/*
 * if simple is true, then each item contains only text .
 * if complex is true, then each item contains either text or operator. 
 * 
 */
package DataBinding.service;

import DataBinding.Model.*;
import DataBinding.Model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author YNZ
 */
public class ExpressionService {

    public static String complexAddition(List<Item> items) {
        if (items == null) {
            throw new IllegalStateException("item is null");
        }

        BigDecimal sum = new BigDecimal("0");
        for (Item item : items) {

            if (!ListSrv.isEmpty(item.getText())) {
                sum = sum.add(new BigDecimal(item.getText().get(0)));
            }

            if (!item.getOperator().isEmpty()) {
                String result = operationsDispatcher(item.getOperator().get(0));
                sum = sum.add(new BigDecimal(result));
            }
        }

        return sum.toString();
    }

    public static String complexMultiplication(List<Factor> factors) {
        if (factors == null) {
            throw new IllegalStateException("input is null");
        }

        if (factors.isEmpty()) {
            return new BigDecimal("0").toString();
        }

        BigDecimal product = new BigDecimal("1");
        for (Factor factor : factors) {
            if (!ListSrv.isEmpty(factor.getText())) {
                product = product.multiply(new BigDecimal(factor.getText().get(0)));
            }
            if (!factor.getOperator().isEmpty()) {
                String result = operationsDispatcher(factor.getOperator().get(0));
                product = product.multiply(new BigDecimal(result));
            }
        }

        return product.toString();
    }

    public static String complexDivision(String dividend, List<Divisor> divisors) {
        if (dividend == null || divisors == null) {
            throw new IllegalStateException("input is null");
        }

        BigDecimal result = new BigDecimal(dividend);
        for (Divisor divisor : divisors) {
            if (!ListSrv.isEmpty(divisor.getText())) {
                result = result.divide(new BigDecimal(divisor.getText().get(0)));
            }
            if (!divisor.getOperator().isEmpty()) {
                String tmp = operationsDispatcher(divisor.getOperator().get(0));
                result = result.divide(new BigDecimal(tmp));
            }
        }

        return result.toString();
    }

    private static String operationsDispatcher(Operator operator) {
        String result = null;
        if (operator instanceof Addition) {
            result = simpleAddition(((Addition) operator).getItems());
        }

        if (operator instanceof Subtraction) {
            result = simpleSubtraction(
                    ((Subtraction) operator).getMinuend(),
                    ((Subtraction) operator).getSubtrahend());
        }

        if (operator instanceof Multiplication) {
            result = simpleMultiplication(
                    ((Multiplication) operator).getFactor());
        }

        if (operator instanceof Division) {
            result = simpleDivision(
                    ((Division) operator).getDividend(),
                    ((Division) operator).getDivisor());
        }

        return result;

    }

    public static String simpleAddition(List<Item> items) {
        if (items == null) {
            throw new IllegalStateException("item is null");
        }

        BigDecimal sum = new BigDecimal("0");

        for (Item item : items) {
            sum = sum.add(new BigDecimal(item.getText().get(0)));
        }

        return sum.toString();
    }

    public static String simpleSubtraction(String minuend, String subtrahend) {
        if (minuend == null || subtrahend == null) {
            throw new IllegalStateException("input is null");
        }

        BigDecimal result = new BigDecimal(minuend);
        result = result.subtract(new BigDecimal(subtrahend));

        return result.toString();
    }

    public static String simpleMultiplication(List<Factor> factors) {
        if (factors == null) {
            throw new IllegalStateException("input is null");
        }

        if (factors.isEmpty()) {
            return new BigDecimal("0").toString();
        }

        BigDecimal result = new BigDecimal("1");
        for (Factor factor : factors) {
            result = result.multiply(new BigDecimal(factor.getText().get(0)));
        }

        return result.toString();
    }

    public static String simpleDivision(String dividend, List<Divisor> divisor) {
        if (dividend == null || divisor == null) {
            throw new IllegalStateException("input is null");
        }

        BigDecimal result = new BigDecimal(dividend);
        result = result.divide(new BigDecimal(divisor.get(0).getText().get(0)));

        return result.toString();
    }

}
