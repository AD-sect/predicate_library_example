package ru.raiffaisen.predicat.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import ru.raiffaisen.predicat.example.utils.BigDecimalSerializer;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CheckEntity {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private String stringField;
    private Integer intField;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal bigDecimalField;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate localDateField;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime localDataTimeFiled;
    private CheckSubentity checkSubentity;
    private List<String> listCollectionField;

}

//
//    EQUALS	Равно
//    NOT_EQUAL	Не равно
//    STARTS_WITH	Начинается с
//    NOT_START_WITH	Начинается не с
//    CONTAINS	Содержит
//    NOT_CONTAIN	Не coдержит
//    ENDS_WITH	Оканчивается на
//    NOT_END_WITH	Оканчивается не на
//    NULL	Пусто
//    NOT_NULL	Не пусто
//    GREATER_OR_EQUAL	Больше или равно
//    LESS_OR_EQUAL	Меньше или равно
//    GREATER	Больше
//    LESS	Меньше