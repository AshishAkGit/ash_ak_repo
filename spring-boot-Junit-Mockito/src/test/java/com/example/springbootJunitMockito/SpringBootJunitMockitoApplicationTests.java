package com.example.springbootJunitMockito;

import com.example.springbootJunitMockito.model.Widget;
import com.example.springbootJunitMockito.repository.WidgetRepository;
import com.example.springbootJunitMockito.service.WidgetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
class SpringBootJunitMockitoApplicationTests {

	/**
	 * Autowire in the service we want to test
	 */
	@Autowired
	private WidgetService service;

	/**
	 * Create a mock implementation of the WidgetRepository
	 */
	@MockBean
	private WidgetRepository repository;

	@DisplayName("Test findById Success")
	@Test
	void testFindById() {
		//setup our mock repository
		Widget widget=new Widget("Widget Name","Description",1);
		doReturn(Optional.of(widget)).when(repository).findById(1l);

		// Execute the service call
		Optional<Widget> returnedWidget = service.findById(1l);

		//Assert the response
		Assertions.assertTrue(returnedWidget.isPresent(),"Widget was not found");
		Assertions.assertSame(returnedWidget.get(), widget, "The widget returned was not the same as the mock");
	}
	@Test
	@DisplayName("Test findById Not Found")
	void testFindByIdNotFound() {
		// Setup our mock repository
		doReturn(Optional.empty()).when(repository).findById(1l);

		// Execute the service call
		Optional<Widget> returnedWidget = service.findById(1l);

		// Assert the response
		Assertions.assertFalse(returnedWidget.isPresent(), "Widget should not be found");
	}

	@DisplayName("Test findAll Success")
	@Test
    void testFindAll(){
        Widget widget1=new Widget("Widget Name","Description",1);
        Widget widget2=new Widget("Widget 2 Name ","Description 2",4);
	    doReturn(Arrays.asList(widget1,widget2)).when(repository).findAll();
	    //Execute the service call
        List<Widget> widgets=service.findAll();
        Assertions.assertEquals(2,widgets.size(),"find All should return 2 widgets");

    }

    @Test
    @DisplayName("Test save widget")
    void testSave() {
        // Setup our mock repository
        Widget widget = new Widget("Widget Name", "Description", 1);
        doReturn(widget).when(repository).save(any());

        // Execute the service call
        Widget returnedWidget = service.save(widget);

        // Assert the response
        Assertions.assertNotNull(returnedWidget, "The saved widget should not be null");
        Assertions.assertEquals(2, returnedWidget.getVersion(), "The version should be incremented");
    }
}
