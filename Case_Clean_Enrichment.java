String Contracts="SELECT COUNT (*) FROM CONTRACT";
String SQLCASENote="SELECT CASE_ID, NOTE_TEXT, NOTE_DATE FROM CASE_NOTE";
String SQLCASES="SELECT CASE_ID, CASE_TYPE, STATUS FROM CASES";
ArrayList<String> open_cases = new ArrayList<String>();
ArrayList<String> billing_cases = new ArrayList<String>();
ArrayList<String> network_cases = new ArrayList<String>();

//reportUserMessage("Case Cleaning function is running");


String newBillingNote = "insolvent customer due to alien assimilation";
String newNetworkNote = "customer has been assimilated into a phone and is no longer network compatible";
String statusClose="CLOSED";

Db.Rows rowsC = ludb().fetch(SQLCASES);
for (Db.Row row:rowsC){
	String cellStatus=""+row.get("STATUS");
	String cellCaseID=""+row.get("CASE_ID");
	String cellCaseType=""+row.get("CASE_Type");
	if (cellStatus.matches("Open") || cellStatus.matches("OPEN"))
	{
		open_cases.add(cellStatus);
		String SQLCaseStatus="UPDATE CASES SET STATUS = ? where STATUS = ?";
		ludb().execute(SQLCaseStatus,statusClose,cellStatus);
	}
	if (cellCaseType.matches("Billing Issue"))
	{
		billing_cases.add(cellCaseID);
	}
	if (cellCaseType.matches("Network Issue"))
	{
		network_cases.add(cellCaseID);
	}
	
}

Db.Rows rowsN = ludb().fetch(SQLCASENote);
for (Db.Row row:rowsN){
	
	String cellNoteText=""+row.get("NOTE_TEXT");
	String cellCaseID=""+row.get("CASE_ID");
	//reportUserMessage(cellCaseID);
	boolean ans1 = billing_cases.contains(cellCaseID);
	boolean ans2 = network_cases.contains(cellCaseID);
	if (ans1) {
		String SQLBillingNote="UPDATE CASE_NOTE SET NOTE_TEXT = ? where CASE_ID = ?";
		ludb().execute(SQLBillingNote,newBillingNote,cellCaseID);
	}
	else if (ans2){
		String SQLNetworkNote="UPDATE CASE_NOTE SET NOTE_TEXT =? WHERE CASE_ID = ?";
		ludb().execute(SQLNetworkNote,newNetworkNote,cellCaseID);
	}
}

	
	
		
		
		
	
	