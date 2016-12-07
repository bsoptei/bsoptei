package wanderer;

/*
Copyright (c) 2015, Joe Wingbermuehle
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of the <organization> nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Joe Wingbermuehle BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
class Maze {
    public GameElement[][] tiles;


    private static final int WALL = 0;
    private static final int SPACE = 1;
    private byte[][] data;
    private int width;
    private int height;
    private java.util.Random rand = new java.util.Random();

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new GameElement[width][height];
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

}