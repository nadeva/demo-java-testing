package com.oltruong.demo;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", format = {"html:target/cucumber-html-report","json:target/cucumber.json"})
public class RunCukesIT {


}
