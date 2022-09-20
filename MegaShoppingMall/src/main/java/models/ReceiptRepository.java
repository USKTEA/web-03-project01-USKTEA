package models;

import java.io.IOException;
import java.util.List;

public class ReceiptRepository {
    private FileManager fileManager;

    ReceiptRepository() throws IOException {
        fileManager = new FileManager("receipts.csv");
    }

    public void saveReceipt(Receipt receipt) throws IOException {
        fileManager.storeReceipt(receipt);
    }

    public List<Receipt> getReceipts() {
        return fileManager.getReceipts();
    }
}
