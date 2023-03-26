public class Products {
    private String name;
    private String model;
    private String manufacturer;
    private Double price;
    private Double rating;

    public Products(String name, String model, String manufacturer, Double price, Double rating) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "name = " + name +
                ", model = " + model +
                ", manufacturer = " + manufacturer +
                ", price = " + price +
                ", rating = " + rating + ".\n";
    }
}
