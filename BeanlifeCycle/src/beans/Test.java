package beans;
// implementing bean life cycle by programmatic approach...............
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Test implements InitializingBean,DisposableBean {

	private String Driver,url, user,password;
	private Connection con; 
	public void setDriver(String driver) {
		Driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	 Class.forName(Driver);
		con=DriverManager.getConnection(url, user, password);
		System.out.println("Conetioin opende"+con);
	}
	public void save(int id, String name, String email, String address) throws Exception {
		PreparedStatement ps= con.prepareStatement("insert into  employee values(?,?,?,?)");
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setString(3,email);
		ps.setString(4,address);
		ps.executeUpdate();
		System.out.println("Inserted Successfully");
		
	}
	
	
	@Override
	public void destroy() throws Exception {
		con.close();
		System.out.println("Conetioin Closed");
		}

	 
	
}
