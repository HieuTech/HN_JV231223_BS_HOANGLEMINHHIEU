package ra.run;

import ra.business.IProduct;
import ra.businessImpl.Product;
import ra.config.ShopConfig;


public class ProductManagement {
    public static Product product = new Product();

    public static void main(String[] args) {
       while (true){
           System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
           System.out.println("1. Nhập số sản phẩm và nhập thông tin sản phẩm");
           System.out.println("2. Hiển thị thông tin các sản phẩm");
           System.out.println("3. Sắp xếp sản phẩm theo lợi nhuận tăng dần");
           System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
           System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
           System.out.println("6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm");
           System.out.println("7. Thoát");
           byte choice = Byte.parseByte(ShopConfig.scanner.nextLine());
           switch (choice) {
               case 1:
                   product.inputData();
                   break;
               case 2:
                   product.displayData();
                   break;
               case 3:
                   product.sortByInterest();
                   break;
               case 4:
                   product.deleteById();
                   break;
               case 5:
                   product.searchByName();
                   break;
               case 6:
                   product.updateStatus();
                   break;
               case 7:
                   System.exit(1);
                   break;
               default:
                   System.out.println("Your choice out of range");
                   break;
           }
       }

    }
}
