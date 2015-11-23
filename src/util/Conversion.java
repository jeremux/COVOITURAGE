package util;

public class Conversion {
	
	public static boolean sqliteToBool(int int1) {
		return (int1==0)?false:true;
	}
	
	public static int toSqliteBool(boolean b) {
		return b?1:0;
	}
}
