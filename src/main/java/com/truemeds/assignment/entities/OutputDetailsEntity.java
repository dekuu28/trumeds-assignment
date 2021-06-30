package com.truemeds.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ashish_patil_java_output")
public class OutputDetailsEntity {

    @Id
    private int id;

    private String input;

    private String timestamp;

    private int output;
}
