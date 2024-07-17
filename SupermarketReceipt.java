import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;

public class SupermarketReceipt {

    // 预定义的商品数据库
    private static Map<String, Item> itemDatabase = new HashMap<>();

    static {
        // 示例数据
        itemDatabase.put("123456", new Item("苹果", 1.0, 0));
        itemDatabase.put("234567", new Item("香蕉", 0.5, 0));
        itemDatabase.put("345678", new Item("橙子", 1.2, 0));
        // 可以添加更多商品
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Item> items = new ArrayList<>();

        System.out.println("请扫描商品条码（结束的时候请输入‘完成’）");
        System.out.println(); // 添加一个空行

        while (true) {
            System.out.print("扫描商品条码: ");
            String barcode = sc.nextLine();

            if (barcode.equalsIgnoreCase("完成")) {
                break;
            }

            // 查找条码对应的商品
            Item item = itemDatabase.get(barcode);
            if (item == null) {
                System.out.println("未找到该条码对应的商品，请重新扫描。");
                System.out.println(); // 添加一个空行
                continue;
            }

            System.out.printf("商品名称: %s, 单价: %.2f\n", item.getName(), item.getPrice());
            System.out.print("请输入商品数量: ");
            String quantityInput = sc.nextLine();

            try {
                int quantity = Integer.parseInt(quantityInput);
                items.add(new Item(item.getName(), item.getPrice(), quantity));
            } catch (NumberFormatException e) {
                System.out.println("输入格式错误，请重新输入数量。");
                System.out.println(); // 添加一个空行
            }
        }

        System.out.println(); // 添加一个空行
        System.out.print("请输入折扣百分比 (例如，10 表示10%): ");
        double discount = sc.nextDouble();
        System.out.print("请输入税率百分比 (例如，5 表示5%): ");
        double taxRate = sc.nextDouble();
        System.out.println(); // 添加一个空行
        printReceipt(items, discount, taxRate);
        sc.close();
    }

    public static void printReceipt(List<Item> items, double discount, double taxRate) {
        double subtotal = 0;
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("           中华超市");
        System.out.println();
      
        System.out.println("---- Supermarket Receipt ----");
        System.out.println();
        System.out.println("时间: " + dateTime);
        System.out.println("商品名称        数量   单价    小计");

        for (Item item : items) {
            System.out.printf("%-10s %5d  %5.2f %6.2f\n",
                    item.getName(),
                    item.getQuantity(),
                    item.getPrice(),
                    item.getTotalPrice());
            subtotal += item.getTotalPrice();
        }

        double discountAmount = subtotal * (discount / 100);
        double discountedTotal = subtotal - discountAmount;
        double tax = discountedTotal * (taxRate / 100);
        double total = discountedTotal + tax;

        System.out.println("-----------------------------");
        System.out.printf("合计: %7.2f\n", subtotal);
        System.out.printf("折扣: -%6.2f\n", discountAmount);
        System.out.printf("税率: +%6.2f\n", tax);
        System.out.printf("总计: %7.2f\n", total);
        System.out.println();
        System.out.print("\n");
        System.out.println("           谢谢光临！");
        System.out.println("          欢迎下次光临");
        
    }
}


