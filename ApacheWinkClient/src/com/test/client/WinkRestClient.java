package com.test.client;

import javax.ws.rs.core.MediaType;

import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;

public class WinkRestClient {
	static String REST_WEB_SERVICE = "http://localhost:8080/metlife-Jax-rs/rest/metlife/api";
    static ClientConfig clientConfig = new ClientConfig();
    public static void main(String[] args) throws Exception {
    	 
        try {
        	WinkRestClient winkRestClient = new WinkRestClient();
        	 
        	 
        	System.out.println("call get method: ");
            winkRestClient.executeGetMethod();
            System.out.println();
            winkRestClient.executeGetMethodAllUsers();
 
           
        	
        } catch (Exception e) {
        	 
            e.printStackTrace();
             
            System.out.println(e.getMessage());
        }
    }
    public void executeGetMethod() {
    	 
        System.out.println("Testing GET method1....");
        RestClient restClient = new RestClient(clientConfig);
        Resource resource = restClient.resource(REST_WEB_SERVICE);
       // Resource resource = restClient.resource(REST_WEB_SERVICE + "/" + id);
        String response = resource.accept("text/plain").get(String.class);
        System.out.println("Response body : "+response);
        System.out.println("----GET method is executed-------");
    }
    public void executeGetMethodAllUsers() {
   	 
        System.out.println("Testing GET method2....");
        RestClient restClient = new RestClient(clientConfig);
        
        Resource resource = restClient.resource(REST_WEB_SERVICE + "/" + "users");
        System.out.println(resource.toString());
        resource.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get();
        System.out.println("Response body : "+response);
        System.out.println("----GET method is executed-------");
    }
 
	/*
	 * public void executePostMethod(String employee) {
	 * 
	 * System.out.println("Testing POST method..."); RestClient restClient = new
	 * RestClient(clientConfig); Resource resource =
	 * restClient.resource(REST_WEB_SERVICE);
	 * resource.contentType(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).post(
	 * String.class, employee); System.out.println("POST method is executed"); }
	 * 
	 * public void executePutMethod(Long id, String name) {
	 * 
	 * System.out.println("Testing PUT method"); RestClient restClient = new
	 * RestClient(clientConfig); Resource resource =
	 * restClient.resource(REST_WEB_SERVICE + "/" + id);
	 * resource.contentType(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).put(
	 * String.class, name); System.out.println("PUT method is executed"); }
	 * 
	 * public void executeDeleteMethod(Long id) {
	 * 
	 * System.out.println("Testing DELETE method"); RestClient restClient = new
	 * RestClient(clientConfig); Resource resource =
	 * restClient.resource(REST_WEB_SERVICE + "/" + id);
	 * resource.contentType(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).
	 * delete(); System.out.println("DELETE method is executed"); }
	 * 
	 * public void executeJsonGetMethod(long id) {
	 * System.out.println("Testing JSON GET method"); RestClient restClient = new
	 * RestClient(clientConfig); Resource resource =
	 * restClient.resource(REST_WEB_SERVICE + "/json/" + id); ClientResponse
	 * response = resource.accept(MediaType.APPLICATION_JSON).get();
	 * System.out.println("JSON GET method is executed"); }
	 * 
	 * public void executeJAXBGetMethod(long id) {
	 * System.out.println("Testing JAXB GET method"); RestClient restClient = new
	 * RestClient(clientConfig); Resource resource =
	 * restClient.resource(REST_WEB_SERVICE + "/" + id); ClientResponse response =
	 * resource.accept(MediaType.APPLICATION_XML).get();
	 * System.out.println("JAXB GET method is executed"); }
	 */
}
