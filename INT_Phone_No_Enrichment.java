String SQLNumber = "SELECT ASSOCIATED_LINE, CONTRACT_DESCRIPTION FROM Customer.CONTRACT";
String interCode="+1";
//SQL statement para sa field updates
String SQLFormattedNumber="UPDATE CONTRACT SET ASSOCIATED_LINE = ? where ASSOCIATED_LINE=?";
Db.Rows rows = fabric().fetch(SQLNumber);
// starting loop over all rows of LUDB
for (Db.Row row:rows){
	String formattedNumber="";
	String cellValue=""+row.get("ASSOCIATED_LINE");
	String cellValueContDesc=""+row.get("CONTRACT_DESCRIPTION");
	//Start matching test
	if ((cellValue.matches("(.*)+1(.*)") == false)){
		formattedNumber = interCode + cellValue;
		fabric().execute(SQLFormattedNumber, formattedNumber, cellValue);
	}// end of the statement
}//end loop through rows