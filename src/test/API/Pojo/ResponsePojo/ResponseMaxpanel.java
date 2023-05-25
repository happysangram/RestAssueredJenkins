
package Pojo.ResponsePojo;

import lombok.Data;

import java.util.List;
@Data
public class ResponseMaxpanel {

    private Integer activeSubsizes;
    private String panelType;
    private Integer passiveSubsizes;
    private List<Layout> layout;
    private String reportid;
    private String version;
}
