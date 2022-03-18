int CRMCases_threshold = 25000;
Boolean syncInd = false;
String count = db("CRM_DB").fetch("SELECT count (*) FROM CASES").firstValue().toString();

reportUserMessage(count);

int cnt = Integer.parseInt(count);

if (cnt >= CRMCases_threshold){
	
reportUserMessage("new case in !!");
	
	syncInd = true;
} 

return syncInd;