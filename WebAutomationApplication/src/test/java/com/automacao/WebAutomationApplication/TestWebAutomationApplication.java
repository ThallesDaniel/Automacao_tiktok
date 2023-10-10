package com.automacao.WebAutomationApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestWebAutomationApplication {

	public static void main(String[] args) {
		SpringApplication.from(WebAutomationApplication::main).with(TestWebAutomationApplication.class).run(args);
	}

}
