package se.base;

import javax.print.attribute.IntegerSyntax;

/**
 * @author zhangyaowen
 */
public class BaseClass<T> implements BaseI, InterBase<T>{

    public Integer price;

    String desc;

    protected Double sale;

    private Double purchasePrice;

    private Integer size;

    public BaseClass(int size) {
        this.size = size;
    }

    protected BaseClass() {}

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    String getDesc() {
        return desc;
    }

    protected Double getSale() {
        return sale;
    }

    strictfp private Double changeSale(Double sale)
    {
        return Double.max(sale, this.sale);
    }

    @Override
    public int changeSale() {
        return 0;
    }

    public void testException() {
        try {
            int noParse = Integer.parseInt("se");
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            throw e;
        }
    }
    private class PriInner {

    }

    protected class ProInner {

    }

    public class PubInner {

    }

    private static class StaPriInner {

    }

    protected static class StaProInner {

    }

    public static class StaPubInner {

    }
}
