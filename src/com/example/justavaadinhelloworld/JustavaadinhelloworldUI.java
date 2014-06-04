package com.example.justavaadinhelloworld;

import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
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
	ComboBox docList = new ComboBox("Documents", docs);
	@Override
	protected void init(VaadinRequest request) {
	setContent(docList);
	}

}