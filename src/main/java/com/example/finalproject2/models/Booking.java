package com.example.finalproject2.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String email;

    private int contactNo;

    private String healthMedicalPackage;

    private String restRelaxationPackage;

    private String dietNutritionPackage;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    private String time;






}
