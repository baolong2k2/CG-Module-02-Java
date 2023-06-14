public class BulletPool extends MemoryPool<Bullet>{
    @Override
    protected Bullet allocate() {
        return new Bullet();
    }


    public void freeItem(Bullet pp) {
    }
}
