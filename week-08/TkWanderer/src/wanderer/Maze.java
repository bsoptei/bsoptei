package wanderer;

class Maze {
    public GameElement[][] tiles = new GameElement[10][10];


        private static final int WALL = 0;
        private static final int SPACE = 1;

        private byte[][] data;
        private int width;
        private int height;
        private java.util.Random rand = new java.util.Random();

        public Maze(int width, int height) {
            this.width = width;
            this.height = height;
            data = new byte[width][];
        }

        private void carve(int x, int y) {

            final int[] upx = {1, -1, 0, 0};
            final int[] upy = {0, 0, 1, -1};

            int dir = rand.nextInt(4);
            int count = 0;
            while (count < 4) {
                final int x1 = x + upx[dir];
                final int y1 = y + upy[dir];
                final int x2 = x1 + upx[dir];
                final int y2 = y1 + upy[dir];
                if (data[x1][y1] == WALL && data[x2][y2] == WALL) {
                    data[x1][y1] = SPACE;
                    data[x2][y2] = SPACE;
                    carve(x2, y2);
                } else {
                    dir = (dir + 1) % 4;
                    count += 1;
                }
            }
        }

        public GameElement[][] generate() {
            for (int x = 0; x < width; x++) {
                data[x] = new byte[height];
                for (int y = 0; y < height; y++) {
                    data[x][y] = WALL;
                }
            }
            for (int x = 0; x < width; x++) {
                data[x][0] = SPACE;
                data[x][height - 1] = SPACE;
            }
            for (int y = 0; y < height; y++) {
                data[0][y] = SPACE;
                data[width - 1][y] = SPACE;
            }

            data[2][2] = SPACE;
            carve(2, 2);

            data[2][1] = SPACE;
            data[width - 3][height - 2] = SPACE;
            return convert();
        }

        public GameElement[][] convert() {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (data[x][y] == WALL) {
                        tiles[x][y] = (new GameElement(x, y, "W"));
                    } else {
                        tiles[x][y] = (new GameElement(x, y, "F"));
                    }
                }
            }
            return tiles;
        }




    public static void main(String[] args) {

//        MazeObj m = new MazeObj(10, 10);
//        m.generate();
//        m.print();


    }
}