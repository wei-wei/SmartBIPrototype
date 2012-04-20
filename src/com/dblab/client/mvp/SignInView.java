package com.dblab.client.mvp;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class SignInView extends ViewImpl implements SignInPresenter.MyView {

	private Viewport viewport;
	private TextField<String> userName;
	private TextField<String> password;
	private Button signInButton;
	
	@Inject
	public SignInView() {
		viewport = new Viewport();
		viewport.setLayout(new CenterLayout());
		viewport.add(createSignInForm());
	}

	@Override
	public Widget asWidget() {
		return viewport;
	}
	
	private FormPanel createSignInForm() {
		FormPanel form = new FormPanel();
		form.setHeading("Sign In");
		form.setWidth(400);
		
		userName = new TextField<String>();
		userName.setFieldLabel("User Name");
		userName.setAllowBlank(false);
		form.add(userName);
		
		password = new TextField<String>();
		password.setPassword(true);
		password.setFieldLabel("Password");
		password.setAllowBlank(false);
		form.add(password);
		
		signInButton = new Button("Sign In");
		form.addButton(signInButton);
		form.setButtonAlign(HorizontalAlignment.CENTER);
		
		form.setFrame(true);
		form.setBodyStyle("padding: 6px");
		
		return form;
	}

	@Override
	public String getUserName() {
		return userName.getValue();
	}

	@Override
	public String getPassword() {
		return password.getValue();
	}

	@Override
	public Button getSignInButton() {
		return signInButton;
	}
}
