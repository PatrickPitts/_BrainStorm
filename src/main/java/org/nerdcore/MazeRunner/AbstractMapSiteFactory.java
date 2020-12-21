package org.nerdcore.MazeRunner;

import java.util.Map;

public interface AbstractMapSiteFactory {

    public void addMapSitePrototype(MapSite prototype);
    public MapSite make(MapSite prototype);
}
