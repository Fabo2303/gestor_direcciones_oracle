package application.utilidades;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;

public class ClobConverter {
	public static String clobToString(Clob clob){
        StringBuilder sb = new StringBuilder();
        try (Reader reader = clob.getCharacterStream();
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }catch(Exception e) {
        	System.out.println(e.getMessage() + " " + e.getCause());
        }
        return sb.toString();
    }
}
