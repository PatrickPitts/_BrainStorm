package org.nerdcore.MazeRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapSiteFactoryImpl implements AbstractMapSiteFactory {

    List<MapSite> prototypes;
    private int maxRoomNumber;

    MapSiteFactoryImpl(MapSite... prototypes){
        this.prototypes = new ArrayList<>();
        this.prototypes.addAll(Arrays.asList(prototypes));

    }
    @Override
    public void addMapSitePrototype(MapSite prototype) {

    }

    @Override
    public MapSite make(MapSite prototype) {
        if(prototype.getClass().isInstance(new Wall())){
            return new Wall();
        } else if (prototype.getClass().isInstance(new Door())){
            return new Door();
        } else if (prototype.getClass().isInstance(new Room(0))){
            return new Room(++maxRoomNumber);
        } return null;
    }


    public MapSite make(Door door) {
        return null;
    }
}

