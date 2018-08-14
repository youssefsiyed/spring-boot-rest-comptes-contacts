package com.dev.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.dev.rmi.ScolariteRemote;
import com.dev.service.EtudiantService;

@Configuration
public class MyConfig {

	
/////////////////////////// WEB SERVICE JAXRS ///////////////////
	//@Bean	
public ResourceConfig getJaxRSExporter(){
	ResourceConfig config = new ResourceConfig();
	config.register(EtudiantService.class);
	return config;
}
/////////////////////////// WEB SERVICE SOAP ///////////////////
@Bean
public SimpleJaxWsServiceExporter getJaxWs(){
	SimpleJaxWsServiceExporter sm =new SimpleJaxWsServiceExporter();
	sm.setBaseAddress("http://0.0.0.0:8585/service");
	return sm;
}
/////////////////////////// WEB SERVICE RMI ///////////////////
@Bean
@Autowired
public RmiServiceExporter getRMI(ScolariteRemote rmiservice){
	RmiServiceExporter rmExporter = new RmiServiceExporter();
	rmExporter.setRegistryPort(1099);
	rmExporter.setServiceName("Scolarite");
	//ScolariteRemote rmiservice=ctx.getBean(ScolariteRemote.class);
	rmExporter.setService(rmiservice);
	return rmExporter;
}


}
