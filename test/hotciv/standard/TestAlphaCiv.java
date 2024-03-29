package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/** Skeleton class for AlphaCiv test cases

    Updated Oct 2015 for using Hamcrest matchers

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
public class TestAlphaCiv {

  private Game game;
  /** Fixture for alphaciv testing. */
  @Before
  public void setUp() {
    game = new GameImpl();
  }

  @Test
  public void shouldHaveRedCityAt1_1() {
    City c = game.getCityAt(new Position(1,1));
    assertThat("There should be a city at (1,1)",
               c, is(notNullValue()));

    Player p = c.getOwner();
    assertThat("The city should be owned by RED player",
               p, is(Player.RED));
  }

  @Test
  public void shouldHaveBlueCityAt4_1() {
    City c = game.getCityAt(new Position(4,1));
    assertThat("There should be a city at (4,1)",
            c, is(notNullValue()));

    Player p = c.getOwner();
    assertThat("The city should be owned by BLUE player",
            p, is(Player.BLUE));
  }

  @Test
  public void shouldHaveOceanTileAt1_0(){
    Tile t = game.getTileAt(new Position(1,0));
    assertThat("There should be an ocean tile at (1,0)", t.getTypeString(), is(GameConstants.OCEANS));
  }

  @Test
  public void shouldBeRedsTurnInTurn1(){
    // The game is freshly created, so it is currently turn 1
    assertThat("In turn one player red should be in turn", game.getPlayerInTurn(), is(Player.RED));
  }

  @Test
  public void afterItHasBeenRedsTurnItShouldBeBluesTurn(){
    assertThat("It is reds turn", game.getPlayerInTurn(), is(Player.RED));
    game.endOfTurn();
    assertThat("It is blues turn", game.getPlayerInTurn(), is(Player.BLUE));
  }

  @Test
  public void inTurn1ItIsYear4000BC(){
    assertThat("It is year 4000BC", game.getAge(), is(-4000));
  }

  @Test
  public void inTurn2ItIsYear3900BC(){
    game.endOfTurn();
    assertThat("It is year 3900BC", game.getAge(), is(-3900));
  }
  @Test
  public void inYear3000BCRedWins(){
    for (int a = 0; a<10; a++) {
      game.endOfTurn();
    }
    assertThat("It is year 3000BC", game.getAge(), is(-3000));
    assertThat("Red wins in year 3000BC", game.getWinner(), is(Player.RED));
  }
}
