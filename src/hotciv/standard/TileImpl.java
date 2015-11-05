package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Tile;

/**
 * Created by Johnny Hansen on 05-11-2015.
 */
public class TileImpl implements Tile {
    @Override
    public String getTypeString() {
        return GameConstants.OCEANS;
    }
}
