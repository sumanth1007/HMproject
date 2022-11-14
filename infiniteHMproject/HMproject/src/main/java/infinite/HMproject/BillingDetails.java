package infinite.HMproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name ="hotelmanagment")
	public class BillingDetails {
	    
	    @Id
	    @Column(name="CustomerId")
	    private  String customerId;
	    
	    @Column(name="BookId")
	    private String bookId;
	    
	    @Column(name="BillingId")
	    private String billingId;
	    
	    @Column(name="NoOfDays")
	    private int noOfDays;
	    
	    @Column(name="BillingAmount")
	    private int billingAmount;
	    
	    
	    public String getCustomerId() {
	        return customerId;
	    }
	    public void setCustomerId(String customerId) {
	        this.customerId = customerId;
	    }
	    public String getBookId() {
	        return bookId;
	    }
	    public void setBookId(String bookId) {
	        this.bookId = bookId;
	    }
	    public String getBillingId() {
	        return billingId;
	    }
	    public void setBillingId(String billingId) {
	        this.billingId = billingId;
	    }
	    public int getNoOfDays() {
	        return noOfDays;
	    }
	    public void setNoOfDays(int noOfDays) {
	        this.noOfDays = noOfDays;
	    }
	    public int getBillingAmount() {
	        return billingAmount;
	    }
	    public void setBillingAmount(int billingAmount) {
	        this.billingAmount = billingAmount;
	    }
	    
	    



	}

