package Test_Cases;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import Delivery.Agent_Generate_Dockets;

class Agent_Generate_Docket_Test {

	Agent_Generate_Dockets ag ;
	
	@Test
	void test1() throws SQLException {
	ag = new Agent_Generate_Dockets();
		//ag.showFrame();
		//ag.initializeUI();

	}

}
