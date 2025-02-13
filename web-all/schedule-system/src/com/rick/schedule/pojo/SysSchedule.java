package com.rick.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysSchedule implements Serializable {

     private Integer uid;
     private Integer sid;
    private String title;
    private Integer completed;

}
