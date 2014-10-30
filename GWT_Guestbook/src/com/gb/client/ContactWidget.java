package com.gb.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class ContactWidget extends Composite {

    private static ContactWidgetUiBinder uiBinder = GWT
            .create(ContactWidgetUiBinder.class);
    @UiField Image image;
    @UiField Label nameLabel;
    @UiField Label phoneLabel;
    @UiField Label emailLabel;
    Contact contact; // 手動撰寫

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    public Label getPhoneLabel() {
        return phoneLabel;
    }

    public void setPhoneLabel(Label phoneLabel) {
        this.phoneLabel = phoneLabel;
    }

    public Label getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(Label emailLabel) {
        this.emailLabel = emailLabel;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
        // 以下4行手動產生的
        nameLabel.setText(contact.getName());
        emailLabel.setText(contact.getEmail());
        phoneLabel.setText(contact.getPhone());
        image.setUrl(contact.getImageURL());
    }

    interface ContactWidgetUiBinder extends UiBinder<Widget, ContactWidget> {
    }

    public ContactWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
