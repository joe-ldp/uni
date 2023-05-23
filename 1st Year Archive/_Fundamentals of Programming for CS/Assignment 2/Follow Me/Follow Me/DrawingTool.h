#pragma once
#include "EasyGraphics.h"
#include <string>
#include <vector>
#include <cstdlib>
#include <time.h>

class DrawingTool : public EasyGraphics
{
public:
    DrawingTool();
    ~DrawingTool();

    ///// Functions /////

    // EasyGraphics //
    virtual void onKeyDown(UINT nChar, UINT nRepCnt, UINT nFlags);
    virtual void onKeyUp(UINT nChar, UINT nRepCnt, UINT nFlags);
    virtual void onTimer(UINT nIDEvent);
    virtual void onDraw();

    // Visual //
    virtual void drawSquares();
    virtual void drawCharacters();
    virtual void writeText();

    // Logic//
    virtual void advanceLevel();
    virtual void generatePath();
    virtual void NPCGoPath();
    virtual void movePlayer(UINT nChar);

    ///// Variables /////

    // Game Logic //
    int level = 0;
    int gridSize = 4;

    bool canMove = false;
    bool gameOver = false;
    bool showPathCheat = false;

    UINT currentDirection;

    // Visual //
    int squareSize = 0;
    std::pair<int, int> gridPoints[6][6];

    bool showNPC = false;
    bool showPlayer = false;

    // Path / Movement / Tracking //
    std::vector< std::pair<int, int> > path;

    std::pair<int, int> npcPos;

    std::pair<int, int> playerPos;
    bool visitedCells[6][6];
};