package com.barclays.controller;

import com.barclays.model.Message;
import com.barclays.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD )
@TestPropertySource(properties =  {"spring.sql.init.mode=never"})
public class MessageTestWithMockHttpRequest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper(); //convert json->java

    @Test
    public void testGettingAllMessages() throws Exception {
        int expectedLength = 2;
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/messages")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        Message[] messages = mapper.readValue(contentAsString, Message[].class);

        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, messages.length),
                () -> assertEquals("My first message", messages[0].getContent()));

    }

    @Test //annotate as a junit test
    public void testingGettingAllPeople() throws Exception{

        int expectedLength = 3;

        //perform a get request to "/people"
        //this.mockMvc.perform(...) sets up a mock HTTP GET request to the "/people" endpoint
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/people")
                        .contentType(MediaType.APPLICATION_JSON) //specify the content type of the request
                        .accept(MediaType.APPLICATION_JSON)) //specify the  expected content type of the response.
                .andExpect(MockMvcResultMatchers.status().isOk()); //asserts that the HTTP response status is OK (200).

        // Deserialize the JSON response into an array of Message objects
        MvcResult result = resultActions.andReturn(); //retrieves the result of the performed request.
        String contentAsString = result.getResponse().getContentAsString(); //gets the content of the response as a string.
        Person[] people = mapper.readValue(contentAsString, Person[].class); //deserializes(using mapper) the
        //  JSON response into an array of Message objects.


        // Assert the expected values
        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, people.length),
                () -> assertEquals("Tolu Adetomiwa", people[0].getPersonName()));

    }

    @Test //annotate as a junit test
    public void testingGettingPersonById() throws Exception{
         int personId = 300;;

        String expectedName = "Tolu Adetomiwa";

        //perform a get request to "/people"
        //this.mockMvc.perform(...) sets up a mock HTTP GET request to the "//people/{id}" endpoint
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/people/{id}", personId)
                        .contentType(MediaType.APPLICATION_JSON) //specify the content type of the request
                        .accept(MediaType.APPLICATION_JSON)) //specify the  expected content type of the response.
                .andExpect(MockMvcResultMatchers.status().isOk()); //asserts that the HTTP response status is OK (200).

        // Deserialize the JSON response into an array of Message objects
        MvcResult result = resultActions.andReturn(); //retrieves the result of the performed request.
        String contentAsString = result.getResponse().getContentAsString(); //gets the content of the response as a string.
        Person people = mapper.readValue(contentAsString, Person.class); //deserializes(using mapper) the
        //  JSON response into an array of Message objects.


        // Assert the expected values
        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedName, people.getPersonName()));

    }



    /*
    json  encodes objects as a string
    serialization = covert object ->string
    deserialization = string to object
    * */
}
