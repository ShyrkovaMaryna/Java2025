package homeWork5;

public class CalcCostDelivery extends CalcCostBase{
    private final static double DELIVERY_PRICE = 7.0; // Фіксована вартість доставки

    @Override
    public double calcCost(Product product) {
        return super.calcCost(product) + DELIVERY_PRICE;
    }
}
