import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Hedil Rahamad
 * Student ID: 22013393
 * Class: E65F
 * Date/Time Last modified:
 */


public class WardManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Visitors> Records = new ArrayList<Visitors>();
		//jane tan's visitors
		Records.add(new Visitors("899Z","Cherly Tan","Jane Tan","","16/12/2022"));
		Records.add(new Visitors("897W","Wayne Goh","Jane Tan","84455845","16/12/2022"));
		Records.add(new Visitors("890A","Steven Hon","Jane Tan","86284486","16/12/2022"));
		//paul tan's visitors
		Records.add(new Visitors("454B","Mary Wong","Paul Tan","","08/11/2022"));
		Records.add(new Visitors("864C","Tiffany Hon","Paul Tan","91156154","08/11/2022"));
		Records.add(new Visitors("798D","Gary Gan","Paul Tan","94454456","08/11/2022"));
		Records.add(new Visitors("764K","Rose Quack","Paul Tan","","08/11/2022"));
		
		
		//initialise Ward array with ward objects 
		Ward[] wardArr = new Ward[4];
		
		wardArr[0] = new Ward("A","1 Bed, attached bath/toilet",10,535.00);
		wardArr[1] = new Ward("B1","4 Bed, attached bath/toilet",20,266.43);
		wardArr[2] = new Ward("B2","6 Bed, common bath/toilet",20,83.00);
		wardArr[3] = new Ward("C","8 Bed, common bath/toilet",50,37.00);
		//-------------------
		// Complete code here
		//-------------------


		
		//initialise Patient arraylist with patient objects	
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		
		Patient JL = new Patient("111A","John Lee","A",2,"01/12/2022");
		Patient MJ = new Patient("222B","Mary Jane","B1",11,"02/12/2022");
		Patient AM = new Patient("333C","Abdul Musri","B1",12,"03/12/2022");
		Patient JT = new Patient("444D","Jane Tan","B2",2,"12/12/2022","",3);
		Patient PT = new Patient("555E","Paul Tan","C",2,"02/11/2022","",4);
		Patient PN = new Patient("666F","Paul Ng","C",3,"03/11/2022","09/11/2022",0);
		Patient WK = new Patient("777G","Wong Kuan","C",4,"02/12/2022");
		
		patientList.add(JL);
		patientList.add(MJ);
		patientList.add(AM);
		patientList.add(JT);
		patientList.add(PT);
		patientList.add(PN);
		patientList.add(WK);
		
		//-------------------
		// Complete code here
		//-------------------



		//display standard menu and ask for option
		int option = -99;
		publicMenu();

		
		//indefinite while loop
		while(option != 10) {
			boolean patientfound = true;
			option = Helper.readInt("\nEnter option or 0 for main menu > ");

			//check for  options
			if(option == 0) {
				//display main menu
				publicMenu();
			} else if (option == 1) {
				//list ward info
				displayWardInfo(wardArr);		
			} else if (option == 2) {
				//display patient in ward
				displayPatientList(patientList);
			} else if (option == 3) {
				//admit patient
				admitPatient(patientList);
			} else if (option == 4) {
				//discharged patient
				patientfound = dischargePatient(patientList);
			} else if (option == 5) {
				//Remove patient visit
				patientfound = removePatient(patientList);
			} else if (option == 6) {
				//register visit
				patientfound = registerVisit(patientList,Records);
			} else if (option == 7) {
				//End visit
				patientfound = endVisit(patientList,Records);

			} else if (option == 8) {
				//End visit
				displayWardOverview(patientList, wardArr);
				
			} else if (option == 9) {
				//Display Visitors
				displayVisitor(patientList,Records);
				
			} else if (option == 10) {
				//log out
				System.out.println("\nGood bye!");
			} else {
				//invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}
			
			//if patient does not exist based on return boolean
			if (!patientfound) {
				System.out.println("\n*** No such patient in ward ***\n");
			}

		}

	} // end of main



	

	//-------------------------------------------------------------------------------------------------------
	//static method to print the standard menu 
	//-------------------------------------------------------------------------------------------------------
	public static void publicMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     PATIENT  MANAGEMENT  MENU     *****");
		Helper.line(45, "*");
		System.out.println("1. View all Ward info");
		System.out.println("2. Display Patient List");
		System.out.println("3. Admit Patient");
		System.out.println("4. Discharge Patient");
		System.out.println("5. Remove Patient");
		System.out.println("6. Register Visit");
		System.out.println("7. End Visit");
		System.out.println("8. Display Ward Overview");
		System.out.println("9. Display Visitor List");
		System.out.println("10. Logout");
		//-------------------
		// Complete code here
		//-------------------

	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a ward array and list out ward details in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayWardInfo(Ward[] wardArr) {
		//ward,description,bed count, bed charge
		System.out.printf("%-8s %-30s %-12s %-12s\n",
				"Ward","Description","Bed Count","Bed Charge");
		for(int i=0; i<wardArr.length; i++) {
			System.out.printf("%-8s %-30s %-12s %-12.2f\n",
					wardArr[i].getWard(),wardArr[i].getDescription(),
					wardArr[i].getBedCount(),wardArr[i].getBedCharge());
		}
		//-------------------
		// Complete code here
		//-------------------

	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and display all the patient information in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayPatientList(ArrayList<Patient> patientList) {
		//nric4,name,ward,bed,date warded, date discharge, visitor count
		System.out.printf("%-8s %-15s %-8s %-8s %-15s %-17s %-15s\n"
		,"NRIC4","Name","Ward","Bed","Date Warded","Date Discharged","Visitor Count");
		for(int i=0; i<patientList.size();i++) {
			System.out.printf("%-8s %-15s %-8s %-8s %-16s %-17s %-15s\n",
			patientList.get(i).getNric4(), patientList.get(i).getName(), patientList.get(i).getWard(),
			patientList.get(i).getBed(), patientList.get(i).getDateWarded(),
			patientList.get(i).getDateDischarged(), patientList.get(i).getVisitorCount());
		}
		
		//-------------------
		// Complete code here
		//-------------------

	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the admit patient functionality
	//-------------------------------------------------------------------------------------------------------
	public static void admitPatient(ArrayList<Patient> patientList) {
			String P_nric = Helper.readString("Enter patient 4 digit NRIC > ");
			String P_name = Helper.readString("Enter patient name > ");
			String P_ward = Helper.readString("Enter ward > ");
			int P_bed = Helper.readInt("Enter bed > ");
			String P_datewarded = Helper.readString("Enter date warded > ");
			
			Patient p_new = new Patient(P_nric,P_name,P_ward,P_bed,P_datewarded);
			patientList.add(p_new);
			
			System.out.println("");
			p_new.display();
			
			System.out.println("\n*** Patient has been added ***");
			
		//-------------------
		// Complete code here
		//-------------------

	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the discharge patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean dischargePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;
		String Discharge_name = Helper.readString("Enter patient name > ");
		
		int i=0;
		while (i<patientList.size()){
			if(patientList.get(i).getName().equalsIgnoreCase(Discharge_name) 
					&& patientList.get(i).getDateDischarged().isEmpty()) {
				patientList.get(i).display();
				String Discharged = Helper.readString("\nEnter date discharged > ");
				System.out.println("\n*** Patient is discharged ***");
				patientList.get(i).setDateDischarged(Discharged);
				patientList.get(i).setVisitorCount(0);
				patientfound = true;
			}
			else if(patientList.get(i).getName().equalsIgnoreCase(Discharge_name) 
					&& !patientList.get(i).getDateDischarged().isEmpty()) {
				
				System.out.println("\n*** Patient has already been discharged ***");
				patientfound =  true;
			}
			i++;
		}
		//-------------------
		// Complete code here
		//-------------------

		return patientfound;
	}





	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the remove patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean removePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;
		String Remove_name = Helper.readString("Enter patient name > ");
		for (int i=0;i<patientList.size();i++) {
			
			if(patientList.get(i).getName().equalsIgnoreCase(Remove_name)){
				
				patientfound=true;
				System.out.println("");
				patientList.get(i).display();
				char confirmation = Helper.readChar("\nConfirm deletion (y/n) > ");
				
				if (confirmation=='y' || confirmation=='Y') {
					patientList.remove(i).getName().equalsIgnoreCase(Remove_name);
					System.out.println("*** Patient has been deleted ***");
				}
			}
		}
		//-------------------
		// Complete code here
		//-------------------

		return patientfound;
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the register visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean registerVisit(ArrayList<Patient> patientList, ArrayList<Visitors> Records) {

		boolean patientfound = false;
		String RegiVisiPatient = Helper.readString("Enter patient name > ");
		System.out.println("");
		
		for ( int i=0; i<patientList.size() ; i++) {
		
		if(patientList.get(i).getName().equalsIgnoreCase(RegiVisiPatient)&&
					patientList.get(i).getDateDischarged().isEmpty()){
			
			patientfound = true;
			patientList.get(i).display();
			int patient_left=(4-patientList.get(i).getVisitorCount());
			if(patient_left>=1 && patient_left<=4) {
				System.out.println("\n*** Only "+patient_left+" visitor(s) allowed ***\n\n");
				int amtvisit =+ Helper.readInt("Enter number of new visitors > ");
				int adding=+amtvisit+patientList.get(i).getVisitorCount();;
				
				if (adding<=4 && adding>=1) {
					int v=0;
					while(v<amtvisit) {
						VisitorTracking_Register(patientList,Records,RegiVisiPatient,adding);
						v++;
					}
					patientList.get(i).setVisitorCount(adding);
					patientfound=true;
				}else if (adding<=0){
					System.out.println("\n*** Invalid input ***");
					patientList.get(i).setVisitorCount(0);
					patientfound=true;
				}else if (adding>4){
					System.out.println("\n*** Visitors exceeded ***");
					patientfound=true;
				}
				
			}else if(patient_left==0) {
				System.out.println("\n*** No additonal visitor allowed ***\n\n");
			}
			
		}else if(patientList.get(i).getName().equalsIgnoreCase(RegiVisiPatient) && 
				!patientList.get(i).getDateDischarged().isEmpty()) {
			patientfound = true;
			System.out.println("*** Patient has been discharged ***");
			return patientfound;
		}
		}
		//-------------------
		// Complete code here
		//-------------------

		return patientfound;
	}

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the end visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean endVisit(ArrayList<Patient> patientList, ArrayList<Visitors> Records) {

		boolean patientfound = false;
		String EndVisiPatient = Helper.readString("Enter patient name > ");
		System.out.println("");
		
		for (int i=0 ; i<patientList.size() ; i++) {
			if(patientList.get(i).getName().equalsIgnoreCase(EndVisiPatient) &&
					patientList.get(i).getDateDischarged().isEmpty()) {
				
				patientfound = true;
				patientList.get(i).display();
				int amtvisit = Helper.readInt("\nEnter number of visitor(s) leaving > ");
				//able to remove it from the patient
				int present=patientList.get(i).getVisitorCount();
				if(present>=amtvisit) {
					int leaving = present-amtvisit;
				
					if(leaving<=4 && leaving>=0) {
						int x=0;
						int x1=1;
						while(x<amtvisit) {
							VisitorTracking_SignOut(patientList,Records,
									EndVisiPatient,leaving,present-x1);
							x++;x1++;
						}

					}
				}else if(present>=amtvisit) {
					System.out.println("\n*** Visitor(s) leaving is more than visited ***");
					return patientfound;
				}else {
					System.out.println("\n*** Visitor(s) leaving is more than visited ***");
					return patientfound;
				}
			}else if (patientList.get(i).getName().equalsIgnoreCase(EndVisiPatient) &&
					!patientList.get(i).getDateDischarged().isEmpty()) {
				
					patientfound = true;
					System.out.println("*** Patient has been discharged ***");
					return patientfound;
		}
		}
		//-------------------
		// Complete code here
		//-------------------

		return patientfound;
	}

	
	
	//------------------------------------------------------------------------------------------------------------
	//static method that takes in a patient arraylist, a ward array and display an overview of the ward information
	//------------------------------------------------------------------------------------------------------------
	public static void displayWardOverview (ArrayList<Patient> patientList, Ward[] WardArr) {
		
		int TotalVisitors=0;
		int TotalPatients=0;
		int TotalBedCount=0;
		
		System.out.println("Ward Overview");
		System.out.printf("%-5s %-28s %-15s %-17s %-12s\n","Ward","Description","Bed Count","Patients","Visitors");
		for (Ward i:WardArr) {
			int PatientperCount=0;
			int WardperVisitors=0;
			TotalBedCount += i.getBedCount();
			for (Patient x:patientList) {
				if(i.getWard()==x.getWard()) {
					TotalVisitors+=x.getVisitorCount();
					WardperVisitors+=x.getVisitorCount();
					if(x.getDateDischarged().isEmpty()){
					PatientperCount+=1;
					TotalPatients+=1;
				}
				}
			}
			if(!patientList.isEmpty() && i!=null) {
				System.out.format("%-5s %-28s %-15d %-17d %-12d\n",i.getWard(),
						i.getDescription(),i.getBedCount(),PatientperCount,WardperVisitors);
			}
		}
		Helper.line(80,"-");
		System.out.printf("Total for all wards%-15s %-15d %-17d %-4d\n","",
				TotalBedCount,TotalPatients,TotalVisitors);
		//-------------------
		// Complete code here
		//-------------------

	}
	
	public static void displayVisitor(ArrayList<Patient> patientList, ArrayList<Visitors> Records) {
		System.out.printf("%-15s %-8s %-15s %-15s %-13s\n"
				,"Patient Name","NRIC4","Visitor Name","Date Visit","Contact");
		for(Visitors i: Records) {
				System.out.printf("%-15s %-8s %-15s %-15s %-13s\n"
		,i.getP_name(),i.getNric4(),i.getName(),i.getDoV(),i.getContact());
				}
			
	}
	
	
	private static void VisitorTracking_Register(ArrayList<Patient> patientList, 
			ArrayList<Visitors> Records, String regiPatient, int adding) {
		String nric4=Helper.readString("Enter visitor 4 digit NRIC > ");
		String name=Helper.readString("Enter visitor name > ");
		String DoV=Helper.readString("Enter Date of Visit > ");
		for(Patient p: patientList) {
			if(p.getName().equalsIgnoreCase(regiPatient) && p.getDateDischarged().isEmpty()) {
				Visitors newV = new Visitors(nric4,name,regiPatient,"",DoV);
				Records.add(newV);
				char option=Helper.readChar("Would like to enter contact info. (y/n) > ");
				if(option=='y' || option=='Y') {
					String contact=Helper.readString("Enter visitor contact No. > ");
					for(int i=0;i<Records.size(); i++) {
						if(Records.get(i).getName().equalsIgnoreCase(name) && Records.get(i).getContact().isEmpty()) {
							Records.get(i).setContact(contact);
							System.out.println("\n*** Visitors Details  ***");
							newV.VisitDisplay();
							p.setVisitorCount(adding);
							System.out.println("\n*** Please proceed to ward ***\n");
							break;
							}
						}
				}else if(option=='n' || option=='N') {
					for(int i=0;i<Records.size(); i++) {
						if(Records.get(i).getName().equalsIgnoreCase(name)) {
							System.out.println("\n*** Visitors Details ***");
							newV.VisitDisplay();
							p.setVisitorCount(adding);
							System.out.println("\n*** Please proceed to ward ***\n");
							break;
						}
					}
				}else {
					System.out.println("\n*** Invalid input ***\n");
				}
		
			}
		}
		
	}

	private static void VisitorTracking_SignOut(ArrayList<Patient> patientList, 
			ArrayList<Visitors> Records, String endPatiVisit, int leaving,int reduction_count) {
		boolean ValidInput=false;
		boolean confirmationSignOut=false;
		
		while(!ValidInput) {
		String nric4=Helper.readString("Enter visitor 4 digit NRIC > ");
		String name=Helper.readString("Enter visitor name > ");
		

		for(int i=0; i<patientList.size(); i++) {
			if(patientList.get(i).getName().equalsIgnoreCase(endPatiVisit) &&
					patientList.get(i).getDateDischarged().isEmpty() ) {
				
				for (int x=0;x<Records.size();x++) {
					
					if(Records.get(x).getNric4().equalsIgnoreCase(nric4) &&
							Records.get(x).getP_name().equalsIgnoreCase(endPatiVisit) &&
							Records.get(x).getName().equalsIgnoreCase(name)){
						
						System.out.printf("\n*** Visitors Details %d ***\n",(reduction_count-reduction_count+1));
						Records.get(x).VisitDisplay();

							Records.remove(x).getNric4().equalsIgnoreCase(nric4);
							patientList.get(i).setVisitorCount(leaving);
							System.out.println("\n*** Visitor has exited ***");
							System.out.printf("\n*** No of visitor(s) still at ward : %d ***\n",reduction_count);
							ValidInput=true;
							confirmationSignOut=true;
						}
					}
				}
			
			}
		if(!confirmationSignOut) {
			System.out.println("\n*** Invalid Input ***\n");
		}
		
		}
	}
	
}