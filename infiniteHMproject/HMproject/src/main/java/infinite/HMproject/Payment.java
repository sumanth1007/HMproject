package infinite.HMproject;



	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
    import javax.persistence.Table;



	@Entity
	@Table(name ="hotelmanagment")
	public class Payment {
	    
	    
	    @Id
	    @Column(name="PaymentId")
	    private String paymentId;
	    
	    @Column(name="BillingId")
	    private String billingId;
	    
	    @Column(name="customerId")
	    private String customerid;
	    
	    @Column(name="BillingAmount")
	    private int billingAmount;
	    
	    @Column(name="Paymode")
	    private Paymode paymode;
	    
	    
	    public String getPaymentId() {
	        return paymentId;
	    }
	    public void setPaymentId(String paymentId) {
	        this.paymentId = paymentId;
	    }
	    public String getBillingId() {
	        return billingId;
	    }
	    public void setBillingId(String billingId) {
	        this.billingId = billingId;
	    }
	    public String getCustomerid() {
	        return customerid;
	    }
	    public void setCustomerid(String customerid) {
	        this.customerid = customerid;
	    }
	    public int getBillingAmount() {
	        return billingAmount;
	    }
	    public void setBillingAmount(int billingAmount) {
	        this.billingAmount = billingAmount;
	    }
	    public Paymode getPaymode() {
	        return paymode;
	    }
	    public void setPaymode(Paymode paymode) {
	        this.paymode = paymode;
	    }
	    
	    



	}

