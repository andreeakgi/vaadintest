package com.example.justavaadinhelloworld;

import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("justavaadinhelloworld")
public class JustavaadinhelloworldUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = JustavaadinhelloworldUI.class)
	public static class Servlet extends VaadinServlet {
	}

	// finally figured out how the path must be set
	FilesystemContainer docs= new FilesystemContainer(new File("/tmp/docs"));
	Table docList = new Table("Documents", docs);
	Label docView = new Label("",ContentMode.HTML);
	
	@Override
	protected void init(VaadinRequest request) {
	
		HorizontalSplitPanel split = new HorizontalSplitPanel();
		setContent(split);
		split.addComponent(docList);
		split.addComponent(docView);
		docList.setSizeFull();
		
		docList.addValueChangeListener(new ValueChangeListener() {
			
			
			public void valueChange(ValueChangeEvent event) {
			    docView.setPropertyDataSource(new TextFileProperty((File) event.getProperty().getValue()));	
				
			}
		});
		
		docList.setImmediate(true);
		docList.setSelectable(true);
	}
	

}