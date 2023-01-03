public class orderObject {
    //orderNum, total, shipCost, soldPrice, shipPaid, tax, profitC)
    private String place, orderNum, total, shipCost, soldPrice, shipPaid, tax, profit;

    //consturctor for object text
    public orderObject(String place, String orderNum, String total, String shipCost, String soldPrice, String shipPaid, String tax, String profit){
        this.place = place;
        this.orderNum = orderNum;
        this.total = total;
        this.shipCost = shipCost;
        this.soldPrice = soldPrice;
        this.shipPaid = shipPaid;
        this.tax = tax;
        this.profit = profit;
    }

    //setter and getter methods
    public void setPlace(String place){
        this.place = place;
    }

    public String getPlace(){
        return place;
    }

    public void setOrderNum(String orderNum){
        this.orderNum = orderNum;
    }

    public String getOrderNum(){
        return orderNum;
    }

    public void setTotal(String total){
        this.total = total;
    }

    public String getTotal(){
        return total;
    }

    public void setShipCost(String shipCost){
        this.shipCost = shipCost;
    }

    public String getShipCost(){
        return shipCost;
    }

    public void setSoldPrice(String soldPrice){
        this.soldPrice = soldPrice;
    }

    public String getSoldPrice(){
        return soldPrice;
    }

    public void setShipPaid(String shipPaid){
        this.shipPaid = shipPaid;
    }

    public String getShipPaid(){
        return shipPaid;
    }

    public void setTax(String tax){
        this.tax = tax;
    }

    public String getTax(){
        return tax;
    }

    public void setProfit(String profit){
        this.profit = profit;
    }

    public String getProfit(){
        return profit;
    }

}
