module bg.tu_varna.sit.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.hibernate.orm.core;
    requires java.persistence;

    requires java.naming;
    requires java.sql;

    opens bg.tu_varna.sit.example.data.entities to org.hibernate.orm.core;
    exports bg.tu_varna.sit.example.data.entities;

    opens bg.tu_varna.sit.example.data.access to org.hibernate.orm.core;
    exports bg.tu_varna.sit.example.data.access;

    exports bg.tu_varna.sit.example.application;
    opens bg.tu_varna.sit.example.application to javafx.fxml;

    exports bg.tu_varna.sit.example.presentation.controllers;
    opens bg.tu_varna.sit.example.presentation.controllers to javafx.fxml;
}