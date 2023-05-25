package Payloads;

import Pojo.Filter;
import Pojo.Maxpanel;
import Pojo.Offsets;
import Pojo.Panelsize;

import java.util.ArrayList;
import java.util.List;

public class MaxPanelPayload {

    public static Maxpanel maxpanelPayload(){

        Maxpanel maxpanel=new Maxpanel();
        maxpanel.setResultmode("3D");
        maxpanel.setPattern("Staggered");
        maxpanel.setPaneltype("SolarTile");
        maxpanel.setOverlapx(0);
        maxpanel.setOverlapy(0.358);
        Panelsize panelsize=new Panelsize();
        panelsize.setHeight(14.02);
        panelsize.setWidth(45.12);
        Offsets offsets=new Offsets();
        offsets.setDefault(1);
        offsets.setEave(0);
        offsets.setObstruction(2);
        offsets.setRake(1);
        offsets.setValley(2);
        offsets.setRidge(2);
        maxpanel.setOffsets(offsets);
        maxpanel.setPanelsize(panelsize);
        Filter filter=new Filter();
        filter.setFiltername("Compact");
        filter.setFiltervalue("FALSE");
        Filter filter1=new Filter();
        filter1.setFiltername("ClippedSolarTiles");
        filter1.setFiltervalue("FALSE");
        Filter filter2=new Filter();
        filter2.setFiltername("WidthFactorsPasiveTiles");
        filter2.setFiltervalue("6");
        Filter filter3=new Filter();
        filter3.setFiltername("WidthFactorsActiveTiles");
        filter3.setFiltervalue("1");
        Filter filter4=new Filter();
        filter4.setFiltername("PVRuleXNoEdge");
        filter4.setFiltervalue("TRUE");
        Filter filter5=new Filter();
        filter5.setFiltername("PVRuleYNoEdge");
        filter5.setFiltervalue("TRUE");
        Filter filter6=new Filter();
        filter6.setFiltername("PVRuleNoObstructionSide");
        filter6.setFiltervalue("TRUE");

        List<Filter> filterList=new ArrayList<>();
        filterList.add(filter);
        filterList.add(filter1);
        filterList.add(filter2);
        filterList.add(filter3);
        filterList.add(filter4);
        filterList.add(filter5);
        filterList.add(filter6);

        maxpanel.setFilter(filterList);

        return maxpanel;


    }
}
