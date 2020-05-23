package com.example.springbootJunitMockito.controller;

import com.example.springbootJunitMockito.model.Widget;
import com.example.springbootJunitMockito.service.WidgetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WidgetRestControllerTest {
    @MockBean
    private WidgetService service;
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("GET /widgets success")
    @Test
    public void testGetWidgetsSuccess() throws Exception {
        //setup mock service
        Widget widget1 = new Widget(1l, "Widget Name", "Description", 1);
        Widget widget2 = new Widget(2l, "Widget 2 Name", "Description 2", 4);

        doReturn(Arrays.asList(widget1, widget2)).when(service).findAll();
        //execute GET request
        mockMvc.perform(get("/rest/widgets"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string(HttpHeaders.LOCATION, "/rest/widgets"))
                // Validate the returned fields
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Widget Name")))
                .andExpect(jsonPath("$[0].description", is("Description")))
                .andExpect(jsonPath("$[0].version", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Widget 2 Name")))
                .andExpect(jsonPath("$[1].description", is("Description 2")))
                .andExpect(jsonPath("$[1].version", is(4)));
    }

    @DisplayName("GET /rest/widget/1")
    @Test
    public void testGetWidgetById() throws Exception {
        Widget widget = new Widget(1l, "Widget Name", "Description", 1);
        doReturn(Optional.of(widget)).when(service).findById(1l);

        //execute the GET request for id=1
        mockMvc.perform(get("/rest/widget/{id}", 1l))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string(HttpHeaders.LOCATION, "/rest/widget/1"))
                .andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
                //validate the return fields
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Widget Name")))
                .andExpect(jsonPath("$.description", is("Description")))
                .andExpect(jsonPath("$.version", is(1)));
    }

    @Test
    @DisplayName("GET /rest/widget/1 - Not Found")
    public void testGetWidgetByIdNotFound() throws Exception {
        doReturn(Optional.empty()).when(service).findById(1l);
        //execute GET request
        mockMvc.perform(get("/rest/widget/{id}",1l))
        .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /rest/widget")
    public void testCreateWidget() throws Exception {
        //setup our mock service
        Widget widgetToPost = new Widget("New Widget", "This is my widget",1);
        Widget widgetToReturn = new Widget(1L, "New Widget", "This is my widget", 1);
        doReturn(widgetToReturn).when(service).save(any());
        //execute POST request
        mockMvc.perform(post("/rest/widget")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(widgetToPost)))

        // Validate the response code and content type
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate headers
                .andExpect(header().string(HttpHeaders.LOCATION, "/rest/widget/1"))
                .andExpect(header().string(HttpHeaders.ETAG, "\"1\""))

                // Validate the returned fields
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("New Widget")))
                .andExpect(jsonPath("$.description", is("This is my widget")))
                .andExpect(jsonPath("$.version", is(1)));
    }

    @Test
    @DisplayName("PUT /rest/widget/1")
    void testUpdateWidget() throws Exception {
        // Setup our mocked service
        Widget widgetToPut = new Widget("New Widget", "This is my widget",1);
        Widget widgetToReturnFindBy = new Widget(1L, "New Widget", "This is my widget", 2);
        Widget widgetToReturnSave = new Widget(1L, "New Widget", "This is my widget", 3);
        doReturn(Optional.of(widgetToReturnFindBy)).when(service).findById(1L);
        doReturn(widgetToReturnSave).when(service).save(any());

        // Execute the POST request
        mockMvc.perform(put("/rest/widget/{id}", 1l)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.IF_MATCH, 2)
                .content(asJsonString(widgetToPut)))

                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate headers
                .andExpect(header().string(HttpHeaders.LOCATION, "/rest/widget/1"))
                .andExpect(header().string(HttpHeaders.ETAG, "\"3\""))

                // Validate the returned fields
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("New Widget")))
                .andExpect(jsonPath("$.description", is("This is my widget")))
                .andExpect(jsonPath("$.version", is(3)));
    }

    @Test
    @DisplayName("PUT /rest/widget/1 - Conflict")
    void testUpdateWidgetConflict() throws Exception {
        // Setup our mocked service
        Widget widgetToPut = new Widget("New Widget", "This is my widget", 1);
        Widget widgetToReturn = new Widget(1L, "New Widget", "This is my widget", 2);
        doReturn(Optional.of(widgetToReturn)).when(service).findById(1L);
        doReturn(widgetToReturn).when(service).save(any());

        // Execute the POST request
        mockMvc.perform(put("/rest/widget/{id}", 1l)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.IF_MATCH, 3)
                .content(asJsonString(widgetToPut)))

                // Validate the response code and content type
                .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("PUT /rest/widget/1 - Not Found")
    void testUpdateWidgetNotFound() throws Exception {
        // Setup our mocked service
        Widget widgetToPut = new Widget("New Widget", "This is my widget",1);
        doReturn(Optional.empty()).when(service).findById(1L);

        // Execute the POST request
        mockMvc.perform(put("/rest/widget/{id}", 1l)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.IF_MATCH, 3)
                .content(asJsonString(widgetToPut)))

                // Validate the response code and content type
                .andExpect(status().isNotFound());
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
