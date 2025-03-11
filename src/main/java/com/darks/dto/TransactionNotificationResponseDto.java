package com.darks.dto;
/**
 * @author Er. Arundeep Randev
 * @since Jan-Mar 2025
 *
 */

public class TransactionNotificationResponseDto {
	
	    private String transactionRefNo;
	    private String transConfirmNumber;
	    private String interfaceName;
	    private String sessionId;
	    private String statusText;

	    public TransactionNotificationResponseDto() {}
	    
	    public String getTransactionRefNo() {
			return transactionRefNo;
		}
		public void setTransactionRefNo(String transactionRefNo) {
			this.transactionRefNo = transactionRefNo;
		}
		public String getTransConfirmNumber() {
			return transConfirmNumber;
		}
		public void setTransConfirmNumber(String transConfirmNumber) {
			this.transConfirmNumber = transConfirmNumber;
		}
		public String getInterfaceName() {
			return interfaceName;
		}
		public void setInterfaceName(String interfaceName) {
			this.interfaceName = interfaceName;
		}
		public String getSessionId() {
			return sessionId;
		}
		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}
		public String getStatusText() {
			return statusText;
		}
		public void setStatusText(String statusText) {
			this.statusText = statusText;
		}
	    
}
