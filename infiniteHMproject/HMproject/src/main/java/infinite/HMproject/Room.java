package infinite.HMproject;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.EnumType;
	import javax.persistence.Enumerated;
	import javax.persistence.Id;
	import javax.persistence.Table;

	
	
	
	
	

	@Entity
	@Table(name="RoomDetails")
	public class Room {
		
		
		 @Id
		 @Column(name="RoomID")
	    private String roomId;
		 
		@Column(name="Type")
	     private String  Type;
			
		 @Enumerated(EnumType.STRING)
	    @Column(name="Status")
	      private  Status status;
			 
		 @Column(name="CostPerDay")
	      private  int costperday;
			    
		 @Column(name ="HotelID")
		  private String hotelId;
			    
			    
			public String getRoomId() {
				return roomId;
			}
			public void setRoomId(String roomId) {
				this.roomId = roomId;
			}
			public String getType() {
				return Type;
			}
			public void setType(String type) {
				Type = type;
			}
			public Status getStatus() {
				return status;
			}
			public void setStatus(Status status) {
				this.status = status;
			}
			public int getCostperday() {
				return costperday;
			}
			public void setCostperday(int costperday) {
				this.costperday = costperday;
			}
			public String getHotelId() {
				return hotelId;
			}
			public void setHotelId(String hotelId) {
				this.hotelId = hotelId;
			}
	}
	
	

