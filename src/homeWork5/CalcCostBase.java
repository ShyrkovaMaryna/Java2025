package homeWork5;

public class CalcCostBase {
    public double calcCost(Product product) {
        return product.getQuota() * product.getPrice();
    }
}
