package com.pluralsight.fileManager;

import com.pluralsight.main.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptManager {
    public static void saveReceipt(Order order){
        File folder = new File("Receipts");
        if (!folder.exists()){
            folder.mkdir();
        }
        String receiptName = "receipts/" + order.getReceiptFileName();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(receiptName))) {
            writer.write(order.getOrderSummary());
            System.out.println("Receipt Saved: " + receiptName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " +e.getMessage());
        }
    }
}
