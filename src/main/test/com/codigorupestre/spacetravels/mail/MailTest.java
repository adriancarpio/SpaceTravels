package com.codigorupestre.spacetravels.mail;

import org.junit.jupiter.api.Test;

public class MailTest {
	
	@Test
	public void testSendEmail() {
		MailSpaceTravels mail = new MailSpaceTravels();
		mail.sendMail("macarpio@est.itsgg.edu.ec");
	}

} 
