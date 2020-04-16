import java.util.LinkedList;

public class BulletPool {
    private static BulletPool instance;
    private LinkedList<Bullet> bullets;

    public static BulletPool getInstance() {
        if (instance == null) instance = new BulletPool();

        return instance;
    }

    private BulletPool() {
        bullets = createBullet(200);
    }

    private LinkedList<Bullet> createBullet(int n) {
        LinkedList<Bullet> results = new LinkedList<Bullet>();

        for (int i = 0; i < n; i++) {
            results.add(new Bullet(0, 0,0,0));
        }

        return  results;
    }

    public Bullet getBullet(int x, int y, int dx, int dy) {
        Bullet bullet = bullets.pop();
        bullet.setPos(x, y, dx, dy);

        return  bullet;
    }

    public void recycleBullet(Bullet bullet) {
        bullets.push(bullet);
    }
}
