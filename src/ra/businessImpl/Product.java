package ra.businessImpl;

import ra.business.IProduct;
import ra.config.ShopConfig;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Product implements IProduct {
    public static List<Product> productList = new ArrayList<>();
    private int productid;
    private String productName, title, descriptions;
    private float importPrice, exportPrice, interest;
    private boolean productStatus;
    public Product() {
    }

    public Product(int productid, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productid = productid;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        System.out.println("How many product you want to add");
        byte count = Byte.parseByte(ShopConfig.scanner.nextLine());

        for (byte i = 1; i <= count ; i++) {
            System.out.printf("Product number: %d \n" , i);
            Product product = new Product();
            product.inputPerProduct();
            productList.add(product);
        }
        System.out.println("Add successfully");
    }

    private void inputPerProduct(){
        System.out.println("Input productID");
        this.productid = Integer.parseInt(ShopConfig.scanner.nextLine());
        System.out.println("Input productName");
        this.productName = ShopConfig.scanner.nextLine();
        System.out.println("Input description");
        this.descriptions = ShopConfig.scanner.nextLine();

        System.out.println("Input title");
        this.title = ShopConfig.scanner.nextLine();

        System.out.println("Input import Price");
        this.importPrice = Float.parseFloat(ShopConfig.scanner.nextLine());

        System.out.println("Input export Price");
        this.exportPrice = Float.parseFloat(ShopConfig.scanner.nextLine());
        this.interest = this.exportPrice - this.importPrice;
        System.out.println("Input product Status");
        this.productStatus = Boolean.parseBoolean(ShopConfig.scanner.nextLine());
    }

    public void sortByInterest(){
        productList.stream().sorted(Comparator.comparing(Product::getInterest)).forEach(Product::displayPerProduct);
    }

    public void updateStatus(){
        System.out.println("Input productID you want to update status");
        int productID = Integer.parseInt(ShopConfig.scanner.nextLine());
        boolean isCheck = false;
        for (Product product : productList){
            if(productList.stream().anyMatch(p -> p.getProductid() == productID)){
                product.setProductStatus(!product.isProductStatus());
                isCheck = true;

                break;
            }
        }
        if(!isCheck){
            System.out.println("Product not found");
        }else{
            System.out.println("Change status successfully");
        }
    }

    public void deleteById(){
        System.out.println("Input productID you want to delete");
        int productID = Integer.parseInt(ShopConfig.scanner.nextLine());
        boolean isCheck = false;
            for (Product product: productList){
                if(productList.stream().anyMatch(p -> p.getProductid() == productID)){
                    productList.remove(product);
                    System.out.println("Delete successfully");
                    isCheck = true;
                    break;
                }
        }
            if(!isCheck){
                System.out.println("ProductID not found");
            }

    }

    public void searchByName(){
        System.out.println("Input Name you want to search");
        String productName = ShopConfig.scanner.nextLine();
        productList.stream().filter(p -> p.getProductName().contains(productName)).forEach(Product::displayPerProduct);
    }

    @Override
    public void displayData() {
       productList.forEach(Product::displayPerProduct);
    }

    private void displayPerProduct(){
        System.out.printf("| ID: %-3s " +
                        "| Name: %-10s " +
                        "| Description: %-10s " +
                        "| Title: %-8s " +
                        "| Import Price: %-4s " +
                        "| Export Price: %-4s " +
                        "| Interest: %-4s " +
                        "| Status: %-5s \n", productid,
                productName, descriptions,title, importPrice, exportPrice, interest, productStatus ? "true" : "false");

        System.out.println("----------------------------------------------------------");
    }


}
