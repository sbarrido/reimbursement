package sbarrido.reimbursement.dto.model;


public class OtherExpDto extends ReimbursementDto { 
    private String vendor;
    private String receiptPath;

    public OtherExpDto() {}

    public String getVendor() {
        return this.vendor;
    }
    public String getReceiptPath() {
        return this.receiptPath;
    }

    public void setVendor(String val) {
        this.vendor = val;
    }
    public void setReceiptPath(String path) {
        this.receiptPath = path;
    }
}