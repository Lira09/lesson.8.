package kg.geektech.less8.players;

public class Golem extends Hero{
    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.PROTECT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() >0 ){
                int damage = boss.getDamage() / 5;
                heroes[i].setHealth(heroes[i].getHealth() + damage);
                if (this.getHealth() - damage < 0){
                    this.setHealth(0);
                }else {this.setHealth(this.getHealth() - damage);}
            }

        }
    }
}
