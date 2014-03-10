package com.haruo.amp.test.steps;

import com.premierinc.amp.test.stubs.MocoStubServer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstStep {

    @Before("@ui")
    public void startServer() {
        MocoStubServer.init();
    }

    @After("@ui")
    public void stopServer() {
        MocoStubServer.stop();
    }

    @When("^I run the tests$")
    public void I_run_the_tests() throws Throwable {
        assertTrue(true);
    }

    @Then("^I see the steps$")
    public void I_see_the_steps() throws Throwable {

    }
}
