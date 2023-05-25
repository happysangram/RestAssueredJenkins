
package Pojo.ResponsePojo;

import lombok.Data;

import java.util.List;

@Data
public class Layout {

    private Integer activepanels;
    private String designator;
    private List<Panel> panels;
    private PasivePanelsBySize pasivePanelsBySize;
    private Integer pasivepanels;
}
