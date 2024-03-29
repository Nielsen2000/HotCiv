package hotciv.standard;

import hotciv.framework.*;

import java.util.ArrayList;

/** Skeleton implementation of HotCiv.
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

public class GameImpl implements Game {

  protected Player playerInTurn = Player.RED;
  protected int Age = -4000;

  public Tile getTileAt( Position p ) {
    return new TileImpl();
  }

  public Unit getUnitAt( Position p ) { return null; }

  public City getCityAt( Position p ) {
    if (p.getColumn() == 1 && p.getRow() == 1){
      return new CityImpl(Player.RED);
    }
    else{
      return new CityImpl(Player.BLUE);
    }
  }

  public Player getPlayerInTurn() { return playerInTurn; }

  public Player getWinner() {
    return Player.RED;
  }

  public int getAge() {
    return Age;
  }

  public boolean moveUnit( Position from, Position to ) {
    return false;
  }

  public void endOfTurn() {
    playerInTurn = Player.BLUE;
    Age+=100;
  }

  public void changeWorkForceFocusInCityAt( Position p, String balance ) {}

  public void changeProductionInCityAt( Position p, String unitType ) {}

  public void performUnitActionAt( Position p ) {}

}
