# Repo4K2Studio

test repo for k2


String sql ="SELECT cust.FIRST_NAME, cust.LAST_NAME, cont.CONTRACT_ID, cont.CONTRACT_DESCRIPTION, sub.SUBSCRIBER_ID, sub.MSISDN, sub.IMSI, sub.SIM, sub.SUBSCRIBER_TYPE, sub.VIP_STATUS FROM Customer.CUSTOMER cust, Customer.CONTRACT cont, Customer.SUBSCRIBER sub WHERE cont.ASSOCIATED_LINE_FMT=sub.MSISDN and sub.VIP_STATUS=?";
Db.Rows rows = ludb("Customer", i_id).fetch(sql, i_vipStatus);
log.info("WS executed Successfully for Customer ID:" + i_id);
return rows;
