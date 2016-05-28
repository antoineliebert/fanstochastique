package la_main;

import java.util.ArrayList;

public class Caisse {
	
	private String name;
	private String status;
	private double avg_speed;
	private double max_speed;
	private int total_clients;
	private int happy_client;
	private int unhappy_client;
	private int neutral_client;
	private ArrayList<ArrayList<Object>> clients;
	
	public Caisse (String name, String status, double avg_speed, double max_speed, int total_clients, int happy_client, int unhappy_client, ArrayList<ArrayList<Object>> clients) {
		
		this.name = name;
		this.status = status;
		this.avg_speed = avg_speed;
		this.max_speed = max_speed;
		this.total_clients = total_clients;
		this.happy_client = happy_client;
		this.unhappy_client = unhappy_client;
		this.neutral_client = total_clients - happy_client - unhappy_client;
		this.clients = clients;
	}

	public ArrayList<ArrayList<Object>> getClients() {
		return clients;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public double getAvgSpeed() {
		return avg_speed;
	}

	public double getMaxSpeed() {
		return max_speed;
	}

	public int getTotalClients() {
		return total_clients;
	}

	public int getHappyClient() {
		return happy_client;
	}

	public int getUnhappyClient() {
		return unhappy_client;
	}
	
	public int getNeutralClient(){
		return neutral_client;
	}
	
	
}
