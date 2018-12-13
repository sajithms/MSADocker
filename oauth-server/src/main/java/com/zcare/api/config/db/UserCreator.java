package com.zcare.api.config.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.mindrot.jbcrypt.BCrypt;

public class UserCreator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection = null;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String url = "jdbc:sqlserver://10.101.5.26;instanceName=SQL2016;databaseName=ZLmsDMGRS";

			// get the sql server database connection
			connection = DriverManager.getConnection(url,"ZLmsDMGRS", "misk");
			int userId = 2198346;
			int personId = 2198360;
			int dummyPersonId =259825;
			String password=BCrypt.hashpw("misk", BCrypt.gensalt());
			Statement statement = connection.createStatement();
			String sql="INSERT INTO [dbo].[SYS_User] ([User_Id],[UserName],[UserPassword],[LastLoginDate],[LastFailedLoginDate],[PasswordDate],[NumberOfFailedLogins],[PasswordExpired],[UserIsEnabled],[AutoDeclared])";
			
			
			
			for (int i = 0; i < 1; i++) {
				//userId = userId+1;
				//personId=personId+1;
				
				
				sql="INSERT INTO [dbo].[SYS_User] ([User_Id],[UserName],[UserPassword],[LastLoginDate],[LastFailedLoginDate],[PasswordDate],[NumberOfFailedLogins],[PasswordExpired],[UserIsEnabled],[AutoDeclared])";
				sql = sql + "  VALUES("+userId+","+ userId+",'"+password+"','NULL','NULL','NULL',0,0,1,0) ";
				statement.executeUpdate(sql);
				
				/*
				sql ="INSERT INTO [dbo].[COMM_Person]([Person_Id],[EnglishFirstName],[IDNumber],[FirstName],[BirthDate],[BirthCity],[BirthCountry],[Nationality],[Gender],[MaritalStatus],[Photo_Id],[Religion],[PhoneList_Id],[AddressList_Id],[OtherIdList_Id],[User_Id],[UserStamp],[TimeStamp],[ExternalID]) VALUES(";
				sql = sql +personId;
				sql = sql +",'Abdulrahim mohammed Abdulla','784196591847189','عبدالرحيم محمد عبدالله ه' ,'19650801','عجمان','AE','AE',1,4,";
				sql = sql +dummyPersonId+",1,"	;	
				sql = sql +dummyPersonId+","	;
				sql = sql +dummyPersonId+","	;	
				sql = sql +dummyPersonId+","	;	
				sql = sql +userId+",1,'20180309 17:47:13.003','TEST_RECORD')"	;	
				
				statement.executeUpdate(sql);
				*/
				
			}



		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
