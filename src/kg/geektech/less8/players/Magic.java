package kg.geektech.less8.players;

import kg.geektech.less8.game.RPG_Game;

public class Magic extends Hero{
    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 ){
                RPG_Game.random.nextInt(5);
                heroes[i].setDamage( heroes[i].getDamage() + 2);

            }
        }

    }
}
