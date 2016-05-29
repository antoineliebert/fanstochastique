package la_main;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
	

	public static void main(String[] args) {

		
        ArrayList<ArrayList<Caisse>> data_AL = new ArrayList<ArrayList<Caisse>>();

        data_AL = importTheJSON();
        
		ClickID clickID = new ClickID();
        JFrameClass jFrame = new JFrameClass(data_AL, clickID);

		
		clickID.addObserver(jFrame);
		
        jFrame.paint();
        
        Thread_Simu thread_Simu = new Thread_Simu (jFrame, data_AL.size(), clickID);
        
        
	}
	
	public static String readFile(String path, Charset encoding) throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
	
	
	public static ArrayList<ArrayList<Caisse>> importTheJSON(){
		
        JSONParser parser = new JSONParser();
        
        JSONArray jsonDataArray;
        JSONArray jsonCaisseArray;
        JSONArray jsonClientsArray;
        
        ArrayList<ArrayList<Caisse>> data_AL = new ArrayList<ArrayList<Caisse>>();
        ArrayList<Caisse> ti_AL = new ArrayList<Caisse>(); // ti_AL contient le string temps et un objet Caisse
        ArrayList<ArrayList<Object>> clients_AL = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> clientSeul_AL = new ArrayList<Object>();

        
        String name;
        String status;
        double max_speed;
        double avg_speed;
        int total_clients;
        int happy_client;
        int unhappy_client;
        String statusClient;
        double theta_s;
        
        try {

            String content = readFile("results.json", StandardCharsets.UTF_8);
            
            JSONObject jsonRootObject = new JSONObject(content);

            jsonDataArray = jsonRootObject.optJSONArray("data");
            
            for (int i = 0; i < jsonDataArray.length(); i++) { // Pour tous les temps ti
            	
            	JSONObject time_JSONobj = jsonDataArray.getJSONObject(i); // On sélectionne le jsonobject temps ti
            	
            	ti_AL = new ArrayList<Caisse>();
            	
            	jsonCaisseArray = time_JSONobj.optJSONArray("checkouts"); // L'array de json objects caisses
            	
            	for (int j = 0; j < jsonCaisseArray.length(); j++){ // pour chaque caisse j
            		JSONObject caisse_JSONobj = jsonCaisseArray.getJSONObject(j);
            		
            		            		
            		name = caisse_JSONobj.optString("name");
            		status = caisse_JSONobj.optString("status");
            		max_speed = caisse_JSONobj.optDouble("max_speed");
            		avg_speed = caisse_JSONobj.optDouble("avg_speed");
            		total_clients = caisse_JSONobj.optInt("total_clients");
            		happy_client = caisse_JSONobj.optInt("happy_client");
            		unhappy_client = caisse_JSONobj.optInt("unhappy_client");

            		if (caisse_JSONobj.optJSONArray("clients") != null)
            		{
	            		jsonClientsArray = caisse_JSONobj.optJSONArray("clients"); // L'array de json objects clients
	            		clients_AL = new ArrayList<ArrayList<Object>>();
	            		
	            		for (int k = 0; k < jsonClientsArray.length(); k++){ // pour chaque client k
	            			JSONObject client_JSONobj = jsonClientsArray.getJSONObject(k);
	
	            			clientSeul_AL = new ArrayList<Object>();
	            			
	            			statusClient = client_JSONobj.optString("status");
	            			theta_s = client_JSONobj.optDouble("theta_s");
	            			clientSeul_AL.add(statusClient);
	            			clientSeul_AL.add(theta_s);
	            			
	            			clients_AL.add(clientSeul_AL);
	            			
	            		}
            		}
            		else
            		{
            			clients_AL = new ArrayList<ArrayList<Object>>();
            			clientSeul_AL = new ArrayList<Object>();
            			clientSeul_AL.add("fake");
            			clientSeul_AL.add(0.0);
            			clients_AL.add(clientSeul_AL);
            		}
            		
            		ti_AL.add(new Caisse(name,status,avg_speed,max_speed,total_clients, happy_client, unhappy_client,clients_AL));
            		
            		
            	}
            	
            	data_AL.add(ti_AL);
            
            }
            
            //System.out.println(data_AL.get(0).get(1).getClients().get(2).get(0));
 
			int a = 2 ;
			
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data_AL;
	}
}