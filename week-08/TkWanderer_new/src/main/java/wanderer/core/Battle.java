package wanderer.core;

/**
 * Created by Söp on 2016.12.08.. This is a fight-until-death logic
 */
interface Battle {

    void strike();

    void sufferDamage(int damage);

    void decreaseHealthPoint(int damage);
}
