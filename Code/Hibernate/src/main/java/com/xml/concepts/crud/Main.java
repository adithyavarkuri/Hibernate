package com.xml.concepts.crud;

public class Main {
	public static void main(String[] args) {

		/* save update delete */

		// InsertRecord.insert();
		 Loadrecords.load();
		 Delete.delete();
		 Update.updatewithoutcall();
		 Loadrecords.load();
		 Update.updatewithcall();
		 Loadrecords.load();

		
	}

}
