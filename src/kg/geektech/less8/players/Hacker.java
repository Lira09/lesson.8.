package kg.geektech.less8.players;

import kg.geektech.less8.game.RPG_Game;

public class Hacker extends Hero{
    public Hacker(int health, int damage) {
        super(health, damage, SuperAbility.HACKING);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

        if ((RPG_Game.roundNumber) % 2 == 0){
           int randomHero = RPG_Game.random.nextInt(heroes.length);
           int randomHealth = RPG_Game.random.nextInt(heroes.length)+1;
           if (boss.getHealth() - randomHealth < 0){
               boss.setHealth(0);
           }else boss.setHealth(boss.getHealth() - randomHealth );
           if (heroes[randomHero].getHealth() > 0 ){
           heroes[randomHero].setHealth(heroes[randomHero].getHealth() + randomHealth);
            System.out.println(" Hacker hacked Boss health: " + randomHealth + " Gives to :" + heroes[randomHero].getClass().getSimpleName());
            }
        }


    }
}



