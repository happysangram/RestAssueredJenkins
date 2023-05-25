
package Pojo.ResponsePojo;

import lombok.Data;

import java.util.List;

@Data

public class Panel {

    private Boolean active;
    private Double sav;
    private Double tof;
    private Double tsrf;
    private Double azimuth;
    private Integer cell;
    private List<Double> center;
    private List<Datum> data;
    private Double height;
    private Integer id;
    private String orientation;
    private Double pitch;
    private Integer row;
    private Double width;
    private Integer widthFID;
    private Double widthSize;

}
