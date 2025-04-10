package com.vijay.testing.model;

public class CartRow {
    private String imageSrc;
    private String productName;
    private String model;
    private String quantity;
    private String unitPrice;
    private String total;

    public CartRow(String imageSrc, String productName, String model, String quantity, String unitPrice, String total) {
        this.imageSrc = imageSrc;
        this.productName = productName;
        this.model = model;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getProductName() {
        return productName;
    }

    public String getModel() {
        return model;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public String getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartRow{");
        sb.append("imageSrc='").append(imageSrc).append('\'');
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", quantity='").append(quantity).append('\'');
        sb.append(", unitPrice='").append(unitPrice).append('\'');
        sb.append(", total='").append(total).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

