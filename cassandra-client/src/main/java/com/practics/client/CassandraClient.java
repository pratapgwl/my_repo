package com.practics.client;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;

public class CassandraClient {

	private Cluster cluster;

	public void connect(String node) {
		cluster = Cluster.builder().addContactPoint(node)
				// .withSSL() // Uncomment if using client to node encryption
				.build();
		Metadata metadata = cluster.getMetadata();
		System.out.println("Testing sysout");
		System.out.println("Testing sysout 2");
		System.out.println("Testing sysout 3");
		System.out.printf("Connected to cluster: %s\n",
				metadata.getClusterName());
		for (Host host : metadata.getAllHosts()) {
			System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
					host.getDatacenter(), host.getAddress(), host.getRack());
		}
	}

	public void close() {
		cluster.shutdown();
		System.out.println("Testing sysout");
		System.out.println("Testing sysout 2");
		System.out.println("Testing sysout 3");
	}
	
	public static void main(String[] args){
		
		CassandraClient client = new CassandraClient();
		
		client.connect("127.0.0.1");
		
		//client.connect("localhost");
		
		client.close();
		System.out.println("Testing sysout");
		System.out.println("Testing sysout 2");
		System.out.println("Testing sysout 3");
	}
}
