package kg.geeks.game.players;
import kg.geeks.game.general.RPG_Game;
public class Magic extends Hero {
    private int[] num = {5, 10, 20};
    private int[] originalDamages;

    public Magic(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (originalDamages == null) {
            originalDamages = new int[heroes.length];
            for (int i = 0; i < heroes.length; i++) {
                originalDamages[i] = heroes[i].getDamage();
            }
        }

        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(originalDamages[i]);
        }

        if (RPG_Game.roundNumber < 5) {
            int randomIndex = RPG_Game.random.nextInt(num.length);
            int boosting = num[randomIndex];
            for (int i = 0; i < heroes.length; i++) {
                if (this != heroes[i]) {
                    heroes[i].setDamage(heroes[i].getDamage() + boosting);
                }
            }
            System.out.println("Magic " + this.getName()
                    + " boosting everyone's damage by: " + boosting);
        }
    }
}
