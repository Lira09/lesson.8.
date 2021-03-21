package kg.geektech.less8.players;

public class Berserk extends Hero{
    public Berserk(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

        int bossDamage = boss.getDamage()/ 2;
         if (boss.getHealth() - this.getDamage() - bossDamage < 0){
             boss.setHealth(0);
         }else  boss.setHealth( boss.getHealth() - this.getDamage() - bossDamage);
       }

}
///Berserk должен получать от босса урон, и потом наносить ему свой урон + часть урона полученного от босса