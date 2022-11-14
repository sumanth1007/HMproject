package infinite.HMproject;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HotelDAO {
	
	
	SessionFactory sFactory;
	Session session;
	
	public String HotelidGenerate() {
		sFactory=SessionHelper.getConnection();
		session=sFactory.openSession();
		Criteria cr=session.createCriteria(HotelDetails.class);
		List<HotelDetails> hotelList=cr.list();
		if(hotelList.size()==0) {
			return "H001";
		}
		int id=Integer.parseInt(hotelList.get(hotelList.size() - 1).getHotelId().substring(1));
		String hid=String.format("H%03d", ++id);
		return hid;
	}
	
	public String addhotel(HotelDetails hotel) {    
        sFactory = SessionHelper.getConnection();
        Session session = sFactory.openSession();
        String hotelId=HotelidGenerate();
        Transaction t = session.beginTransaction();
      hotel.setHotelId(hotelId);    
        session.save(hotel);
        t.commit();
        return "Hotel Added Successfully";
        }
        
	
	  public String addroom(Room room){
          sFactory = SessionHelper.getConnection();
          Session session = sFactory.openSession();
          String roomId = roomidGenerate();
          room.setRoomId(roomId);
          room.setStatus(Status.AVAILABLE);
          Criteria cr=session.createCriteria(Room.class);
          Transaction tran = session.beginTransaction();
          session.save(room);
          tran.commit();
          session.close();
          return "Room Added Successfully  ";
          
   
      }
   
	  public List<HotelDetails> showAllhotel() {
	        sFactory = SessionHelper.getConnection();
	          Session session=sFactory.openSession();
	          Criteria cr = session.createCriteria(HotelDetails.class);
	          
	          List<HotelDetails> hotellist =cr.list();
	          return hotellist;
	}
	public List<HotelDetails> showhotel() {
        sFactory = SessionHelper.getConnection();
          Session session=sFactory.openSession();
          Criteria cr = session.createCriteria(HotelDetails.class);
          Projection projection=Projections.property("hotelId");
			 cr.setProjection(projection);
          List<HotelDetails> hotellist =cr.list();
          return hotellist;
}
	public String roomidGenerate() {
		sFactory=SessionHelper.getConnection();
		session=sFactory.openSession();
		Criteria cr=session.createCriteria(Room.class);
		List<Room> roomList=cr.list();
		if(roomList.size()==0) {
			return "R001";
		}
		int id=Integer.parseInt(roomList.get(roomList.size() - 1).getRoomId().substring(1));
		String rid=String.format("R%03d",++id);
		return rid;
	}
	
	public String Addroom(Room room) {
		sFactory=SessionHelper.getConnection();
		session=sFactory.openSession();
		String roomId=roomidGenerate();
		Transaction tr=session.beginTransaction();
		room.setRoomId(roomId);
		room.setStatus(Status.AVAILABLE);
		session.save(room);
		tr.commit();
		return "Room Added...";
		
   }
	
	//search hotel
	
	public HotelDetails searchhotel(String hotelId) {
        sFactory = SessionHelper.getConnection();
        session = sFactory.openSession();
        
        Criteria cr = session.createCriteria(HotelDetails.class);
        cr.add(Restrictions.eq("hotelId", hotelId));
        List<HotelDetails> hotelList = cr.list();
        
        return hotelList.get(0);
    }
	
	
	//bookid generate
	
	public String bookIdGen() {
		sFactory=SessionHelper.getConnection();
		session=sFactory.openSession();
		Criteria cr=session.createCriteria(RoomBooking.class);
		List<RoomBooking> hotelList=cr.list();
		if(hotelList.size()==0) {
			return "B001";
		}
		
		
		int id=Integer.parseInt(hotelList.get(hotelList.size() - 1).getBookId().substring(1));
		String bid=String.format("B%03d", ++id);
		return bid;
	}
	
	
	//showroom
	
	
	 public List<Room> searchRoom(String hotelId) {
	        sFactory = SessionHelper.getConnection();
	          Session session=sFactory.openSession();
	          Criteria cr = session.createCriteria(Room.class);
	          cr.add(Restrictions.eq("hotelId", hotelId));
	          List<Room> roomlist =cr.list();
	          return roomlist;
	}
	 
	 
	 
	 public String generateBookId(){
			sFactory = SessionHelper.getConnection();
			
		Session session = sFactory.openSession();
			Criteria cr = session.createCriteria(RoomBooking.class);
			List<RoomBooking> bookList = cr.list();
			if(bookList.size()==0){
				return "B001";
			}
			int id = Integer.parseInt(bookList.get(bookList.size()-1).getBookId().substring(1));
			String bid = String.format("B%03d", ++id);
			return bid;
		}
	 //room bookinfg
	 
	 public String bookingRoom(RoomBooking booking) {
			sFactory = SessionHelper.getConnection();
			Session session = sFactory.openSession();
			Criteria cr = session.createCriteria(RoomBooking.class);
			String bookId = generateBookId();
 		booking.setBookId(bookId);
			
			java.util.Date date = new java.util.Date();
			Date bookDate = new Date(date.getTime());
			booking.setBookDate(bookDate);
			
			Transaction transaction = session.beginTransaction();
			session.save(booking);
			transaction.commit();
			session.close();
			
			Room rooms = searchroom(booking.getRoomId());
			rooms.setStatus(Status.BOOKED);
			
			session = sFactory.openSession();
			transaction = session.beginTransaction();
			session.update(rooms);
			transaction.commit();
			session.close();
		
			return "Room Booked.";
		}
	 
	 public java.util.Date conversqltDate(java.sql.Date dt) {
			java.util.Date utilDate=new Date(dt.getTime());
			return utilDate;
		}
		
		public int days(Date chkinDate,Date chkoutDate) {
			RoomBooking book =new RoomBooking();	
			java.util.Date checkInDate=conversqltDate(chkinDate);
			java.util.Date checkOutDate=conversqltDate(chkoutDate);
			int days=(int)((checkOutDate.getTime()-checkInDate.getTime())/(1000*60*60*24));
			days++;
			return days;
		}
	
	 //search room 
	 public Room searchroom(String roomId) {
			sFactory = SessionHelper.getConnection();
			Session session = sFactory.openSession();
			
			Criteria cr = session.createCriteria(Room.class);
			cr.add(Restrictions.eq("roomId", roomId));
			List<Room> roomList = cr.list();
			
			return roomList.get(0);
		}
	
    public List<Room> showroom(String rooms) {
        sFactory = SessionHelper.getConnection();
          Session session=sFactory.openSession();
          Query query = session.createQuery("from Room");
          Criteria cr = session.createCriteria(Room.class);
          
          List<Room> roomlist =query.list();
          return roomlist;
}
   // Generate Customer Id
  
    public String generateCustomerId() {
         
         sFactory = SessionHelper.getConnection();
         Session session = sFactory.openSession();
         Criteria cr = session.createCriteria(CustomerDetails.class);
         List<CustomerDetails> customerList = cr.list();
         if(customerList.size()==0){
             return "C001";
         }
         int id = Integer.parseInt(customerList.get(customerList.size()-1).getCustomerId().substring(1));
         String cid = String.format("C%03d", ++id);
         return cid;
     }
//Add Customer
     
     
     public String addCustomer(CustomerDetails customer) {    
         sFactory = SessionHelper.getConnection();
         Session session = sFactory.openSession();
         String customerId=generateCustomerId();
         Transaction t = session.beginTransaction();
        customer.setCustomerId(customerId);    
         session.save(customer);
         t.commit();
         return "Customer Added";
         }
     
   //customer show
     
    public List<CustomerDetails> CustomerShow() {
         sFactory = SessionHelper.getConnection();
         Session session = sFactory.openSession();
         Criteria cr = session.createCriteria(CustomerDetails.class);
         List<CustomerDetails> customerList = cr.list();
         return customerList;
         
     }

    //logincheck
    

    
    
    
    public int loginCheck(int userId, String pass){
        sFactory = SessionHelper.getConnection();
        Session session = sFactory.openSession();
        Criteria cr = session.createCriteria(CustomerDetails.class);
        cr.add(Restrictions.eq("userId", userId));
        cr.add(Restrictions.eq("pass", pass));
        List<CustomerDetails> customerList = cr.list();
        return customerList.size();
    }
	

}
