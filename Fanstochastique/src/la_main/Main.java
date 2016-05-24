package la_main;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
	
	private static int b;

	public static void main(String[] args) {
		//system.out.println("o");
		BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        FileInputStream fis = null;
        
        String chaine="";
        
        JSONParser parser = new JSONParser();
        JSONArray jsonDataArray;
        JSONArray jsonCaisseArray;
        
        ArrayList data_AL = new ArrayList();
        ArrayList ti_AL = new ArrayList();
        ArrayList clients = new ArrayList();
        
        
        String name;
        String status;
        String v_moy;
        String v_max;
        String client_total;
        String happy_client;
        String unhappy_client;
        
        try {
 
            Object obj = parser.parse(new FileReader(
                    "C:\\Users\\Antoine\\Desktop\\ESIEA\\4AS2\\Processus stochastiques\\projet\\format.json"));
 
            //JSONObject jsonObject = (JSONObject) obj;
            
            String content = readFile("C:\\Users\\Antoine\\Desktop\\ESIEA\\4AS2\\Processus stochastiques\\projet\\format.json", StandardCharsets.UTF_8);
            
            //JSONObject response = jsonObject.getJSONObject("response");
            //JSONArray jsonArray = jsonObject.optJSONArray("data");
            JSONObject jsonRootObject = new JSONObject(content);

            jsonDataArray = jsonRootObject.optJSONArray("data");
            
            for (int i = 0; i < jsondataArray.length(); i++) {
            	
            	JSONObject time_JSONobj = jsonDataArray.getJSONObject(i);
            	
            	ti_AL.add(time_JSONobj.optString("time"));
            	
            	jsonCaisseArray = time_JSONobj.optJSONArray("caisses");
            	
            	for (int j = 0; j < jsonCaisseArray.length(); j++){
            		JSONObject caisse_JSONobj = jsonCaisseArray.getJSONObject(j);
            		name = caisse_JSONobj.optString("name");
            		
            		ti_AL.add(new );
            	}
            	
            
            	data.add(ti_AL);
            }
            
            JSONObject time = jsonArray.getJSONObject(0);
            
        	b = 3;
            JSONArray jsonArray = jsonRootObject.optJSONArray("clients");
            
            int a = 2;

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
		try {
      

            
            
            nb_notes = 0;
            for (int i = 0; i < jsonArray2.length(); i++) {
                JSONObject jsonObject2 = jsonArray2.getJSONObject(i);

                String ID = jsonObject2.optString("ID");
                String NOTE = jsonObject2.optString("NOTE");
                String COMMENTAIRES = jsonObject2.optString("COMMENTAIRES").toString();
                String ADDR_MAC = jsonObject2.optString("ADDR_MAC").toString();
                String ZONE1 = jsonObject2.optString("ZONE").toString();

                if (ZONE1.equals(zone)) {
                    notesdb[nb_notes][0] = ID;
                    notesdb[nb_notes][1] = NOTE;
                    notesdb[nb_notes][2] = COMMENTAIRES;
                    notesdb[nb_notes][3] = ADDR_MAC;

                    nb_notes ++;
                }
            }*/
	}
	
	static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
	
}