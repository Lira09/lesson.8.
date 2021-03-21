package kg.geektech.less8.game;

import kg.geektech.less8.players.*;

import java.util.Random;

public class RPG_Game {
public static  int roundNumber =0 ;
    public static Random random = new Random();

    public static void start() {
       Boss boss = new Boss(1400,50);
       Warrior warrior = new Warrior(250,20);
       Medic doc = new Medic(220,10,15);
       Magic magic = new Magic(270,25);
       Berserk berserk = new Berserk(260,15);
       Medic assistant = new Medic(265,15,5);
       Golem golem = new Golem(400,5);
       Hacker hacker = new Hacker(200,15);
       Witcher witcher = new Witcher(200,0);
       Levi levi = new Levi(250,50);



       Hero[] heroes= {warrior,doc,magic,berserk,assistant,golem,hacker,witcher, levi};
       printStatistics(boss,heroes);
       while (!isGameFinished(boss,heroes)){
           round(boss,heroes);
       }

    }
    private static void round(Boss boss,Hero[] heroes){
        System.out.println(++roundNumber +  "-----ROUND");
        if (boss.getHealth() > 0){
            bossHits(boss,heroes);
        }
        heroesHits(boss,heroes);
        heroesApplyPower(boss,heroes);
        printStatistics(boss,heroes);
    }




    private static void bossHits(Boss boss,Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }
    private static void heroesHits (Boss boss,Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && heroes[i].getSuperAbility() != SuperAbility.CRITICAL_DAMAGE) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }
    private static void heroesApplyPower (Boss boss,Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperAbility(boss,heroes);
            }
        }
    }


    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won !!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }

        }
        if (allHeroesDead){
            System.out.println("Boss won!!!");
        }return allHeroesDead;
    }
   private static void printStatistics (Boss boss, Hero[] heroes){
       System.out.println("-------------------------------");
       System.out.println("Boss health: " + boss.getHealth() + "  [" + boss.getDamage() + " ]");
       for (int i = 0; i < heroes.length; i++) {
           System.out.println(heroes[i].getClass().getSimpleName()+ " health: " + heroes[i].getHealth() + "[ " + heroes[i].getDamage() + "]");
       }
   }

}




