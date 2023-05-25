
package Pojo;

import lombok.Data;

import java.util.List;

@Data
public class Maxpanel {

    private List<Filter> filter;
    private Offsets offsets;
    private String paneltype;
    private Integer overlapx;
    private Double overlapy;
    private Panelsize panelsize;
    private String pattern;
    private String resultmode;
}
