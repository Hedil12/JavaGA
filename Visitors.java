/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: 22013393
 * Student ID: Hedil Rahamad
 * Class: E65F
 * Date/Time created: Monday 30-01-2023 16:53
 */

/**
 * @author 22013393
 *
 */
public class Visitors{
	private String nric4;
	private String name;
	private String P_name;
	private String contact;
	private String DoV;
	
	
	public Visitors(String nric4, String name, String P_name, String contact, String DoV) {
		this.nric4=nric4;
		this.name=name;
		this.P_name=P_name;
		this.contact=contact;
		this.DoV=DoV;
	}
	
	public Visitors(String nric4,String name,String P_name) {
		this.nric4=nric4;
		this.name=name;
		this.P_name=P_name;
		this.contact="";
		this.DoV="";
	}
	
	public String getNric4() {
		return nric4;
	}

	public void setNric4(String nric4) {
		this.nric4=nric4;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setP_name(String P_name) {
		this.P_name=P_name;
	}
	
	public String getP_name() {
		return P_name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		if(checkContact(contact)==true) {
			this.contact=contact;
		}else {
			System.out.println("\n***Invalid contact number***");
		}
	}
	
	private boolean checkContact(String contact) {
		boolean isTrue=false;
		if(contact.length()==8 && contact.matches("[0-9]+")) {
			isTrue=true;
		}
		
		return isTrue;
	}

	public String getDoV() {
		return DoV;
	}

	public void setDoV(String DoV) {
		this.DoV = DoV;
	}
	
	public void VisitDisplay() {
		System.out.println("Visitor NRIC4        : "+nric4);
		System.out.println("Visitor Name         : "+name);
		System.out.println("Visiting Patient name: "+P_name);
		System.out.println("Visitor Contacnt No. : "+contact);
		System.out.println("Date of Visit        : "+DoV+"\n");
	}


}
