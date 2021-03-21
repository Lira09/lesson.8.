package kg.geektech.less8.players;

import kg.geektech.less8.game.RPG_Game;

public class Levi extends Hero{
    public Levi(int health, int damage) {
        super(health, damage, SuperAbility.HIT);
    }
    final int randomRound = RPG_Game.random.nextInt(5)+1;
    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

        if (randomRound == RPG_Game.roundNumber){
            boss.setDamage(boss.getDamage() - 20);
            System.out.println(" Levi hits Boss :" + RPG_Game.roundNumber);
        }
    }
}
// Levi может наносить удар по  Боссу (ослабить его damage) мечом используя его только один раз .