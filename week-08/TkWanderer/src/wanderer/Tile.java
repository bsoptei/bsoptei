package wanderer;

/**
 * Created by Söp on 2016.12.05.. Tiles of the map
 */
class Tile extends GameObject {

    Tile(int xPos, int yPos, String type) {
        super(type);
        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;
        createElementImage();
        setObstacle();
    }

    private void setObstacle() {
        obstacle = (type.equals("W"));
    }

    @Override
    public void createElementImage() {
        this.tileImage = new PositionedImage(imageSelector.get(type), xPos * imageSize, yPos * imageSize);
    }

    @Override
    void move(int deltaX, int deltaY) {
        xPos += deltaX;
        yPos += deltaY;
        moveElementImage();
    }

    @Override
    void strike() {

    }

    @Override
    void changeElementImage(int deltaX, int deltaY) {

    }

    @Override
    public void moveElementImage() {
        tileImage.setPosX(xPos * imageSize);
        tileImage.setPosY(yPos * imageSize);
    }

    @Override
    void setDefaultStats() {

    }

    public PositionedImage getTileImage() {
        return tileImage;
    }

    @Override
    boolean neighborIsObstacle(int deltaX, int deltaY) {
        return false;
    }

    @Override
    String levelToString() {
        return null;
    }

    @Override
    void sufferDamage(int damage) {

    }

}