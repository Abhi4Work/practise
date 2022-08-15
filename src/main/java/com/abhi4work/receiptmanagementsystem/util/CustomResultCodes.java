package com.abhi4work.receiptmanagementsystem.util;

public enum CustomResultCodes
{
	RECEIPT_REQUEST_VALIDATION_ERROR(1000,ResultCodeType.CLIENT_ERROR,"Mandatory fields missing in request"),
	RECEIPT_VALIDATION_ERROR(1001,ResultCodeType.SERVER_ERROR,"Mandatory fields missing in request"),
	RECEIPT_CREATION_ERROR(1002,ResultCodeType.SERVER_ERROR,"Error in db while creating receipt"),
	SUCCESSFUL(1003,ResultCodeType.SUCCESSFUL,"successful"),
	RECEIPT_DAO_ERROR(1004,ResultCodeType.SERVER_ERROR,"Successfully created a new receipt"),
	RECEIPT_UPDATE_ERROR(1005,ResultCodeType.SERVER_ERROR,"Error in db while creating receipt"),
	RECEIPT_FETCH_ERROR(1006,ResultCodeType.SERVER_ERROR,"Error in db while fetching receipt"),
	RECEIPT_DELETE_ERROR(1007,ResultCodeType.SERVER_ERROR,"Error in db while deleting receipt");

	int code;
	ResultCodeType description;
	String reason;
//	private static HashMap<Integer,CustomResultCodes> lookupTable = null;

	private CustomResultCodes() {

	}

	private CustomResultCodes(int code,ResultCodeType description ,String reason ){
		this.code = code;
		this.description = description;
		this.reason = reason;
	}

//	static
//	{
//		CustomResultCodes[] arr$ = values();
//		for(CustomResultCodes i$ : arr$){
//			lookupTable.put(i$.code,i$);
//		}
//	}

//	public CustomResultCodes lookupCustomResultCodes(Integer code){
//		return lookupTable.get(code);
//	}

	public int getCode(){
		return this.code;
	}
	public String getReason(){
		return this.reason;
	}

	 enum ResultCodeType
	{
		INFORMATIONAL("INFORMATIONAL",1),
		SUCCESSFUL("SUCCESSFUL",2),
		SERVER_ERROR("SERVER",3),
		CLIENT_ERROR("CLIENT",4);


		String typeName;
		int code;

		private ResultCodeType(String typeName,int code){
			this.typeName = typeName;
			this.code = code;
		}

	}
}
