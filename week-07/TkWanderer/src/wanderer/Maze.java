package wanderer;

import java.util.Random;

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
    private Tile[][] data;
    private int width;
    private int height;
    private Random rand = new Random();

    Maze(int width, int height) {
        this.width = width;
        this.height = height;
        data = new Tile[width][];
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
            if (data[x1][y1].getType().equals("W") && data[x2][y2].getType().equals("W")) {
                data[x1][y1] = new Tile(x1,y1, "F");
                data[x2][y2] = new Tile(x2, y2, "F");
                carve(x2, y2);
            } else {
                dir = (dir + 1) % 4;
                count += 1;
            }
        }
    }

    Tile[][] generate() {
        for (int x = 0; x < width; x++) {
            data[x] = new Tile[height];
            for (int y = 0; y < height; y++) {
                data[x][y] = new Tile(x,y, "W");
            }
        }
        for (int x = 0; x < width; x++) {
            data[x][0] = new Tile(x,0, "F");
            data[x][height - 1] = new Tile(x, height -1, "F");
        }
        for (int y = 0; y < height; y++) {
            data[0][y] = new Tile(0, y, "F");
            data[width - 1][y] = new Tile(width -1, y, "F");
        }
        data[2][2] = new Tile(2, 2, "F");
        carve(2, 2);
        data[2][1] = new Tile(2,1, "F");
        data[width - 3][height - 2] = new Tile(width-3, height-2, "F");
        return data;
    }

}