package ignite.demo;

import java.util.Collection;
import java.util.Collections;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCluster;
import org.apache.ignite.Ignition;
import org.apache.ignite.cluster.ClusterGroup;
import org.apache.ignite.configuration.IgniteConfiguration;

public class IgniteTest {
	public static void main(String[] args) {
		/*IgniteConfiguration cfg = new IgniteConfiguration();
		// cfg.setUserAttributes(Collections.singletonMap("ROLE", "master"));
		// cfg.setClientMode(true);
		Ignite ignite = Ignition.start();
		IgniteCluster cluster = ignite.cluster();
		// Nodes with less than 50% CPU load.
		ClusterGroup readyNodes = cluster.forPredicate((node) -> node.metrics()
				.getCurrentCpuLoad() < 0.5);*/
	}
}
