package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();
    public static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss("Dragon", 2000, 50);

        Warrior warrior1 = new Warrior("Artur", 280, 10);
        Warrior warrior2 = new Warrior("Ahilles", 290, 15);
        Magic magic = new Magic("Hendolf", 270, 10);
        Berserk berserk = new Berserk("Konan", 260, 10);
        Medic assistant = new Medic("Nebolit", 300, 5, 5);
        Medic doc = new Medic("Aibolit", 250, 5, 15);
        Samurai samurai = new Samurai("Ashura", 270, 5);
        Avenger avenger = new Avenger("Captain America", 280, 10);
        Ludoman ludoman = new Ludoman("Ludik", 270, 5);
        Hacker hacker = new Hacker("Anonimus", 260, 6);


        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant, samurai, avenger, ludoman, hacker};

        printStatistics(boss, heroes);

        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("\nROUND " + roundNumber + " -------------- ");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 &&
                heroes[i].getAbility() != boss.getDefence()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }
}
