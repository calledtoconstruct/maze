module Lib ( run ) where

import Enumerate
import Maze
import Find
import Replace

startPositionIn :: (Char, Int, Int) -> Bool
startPositionIn (value, _, _) = value == 'S'

endPositionIn :: (Char, Int, Int) -> Bool
endPositionIn (value, _, _) = value == 'E'

nextMoveIn :: (Char, Int, Int, Int, Int) -> Bool
nextMoveIn (value, fromX, fromY, toX, toY) = isPathOrEnd && (isHorizontal || isVertical)
  where isVertical = abs(toY - fromY) == 1 && fromX == toX
        isHorizontal = abs(toX - fromX) == 1 && fromY == toY
        isPathOrEnd = value == 'E' || value == ' '

hasOne :: ((Char, Int, Int) -> Bool) -> Maze -> Bool
hasOne somethingIn maze = (length $ concat $ find somethingIn maze) == 1

hasNext :: Maze -> Int -> Int -> Bool
hasNext maze currentX currentY = (null $ concat $ findRelative nextMoveIn maze currentX currentY) == False

atTheEnd :: Maze -> Int -> Int -> Bool
atTheEnd maze currentX currentY = endX == currentX && endY == currentY
  where (_, endX, endY) = head $ concat $ find endPositionIn maze

leaveBreadcrumb :: Maze -> Int -> Int -> Maze
leaveBreadcrumb maze x y = replaceInMaze maze x y '*'

move :: Maze -> Int -> Int -> Result
move maze fromX fromY =
  if canMove
  then move updatedMaze toX toY
  else if victory
  then MazeComplete updatedMaze
  else NoPath
  where canMove = hasNext maze fromX fromY
        updatedMaze = leaveBreadcrumb maze fromX fromY
        (_, _, _, toX, toY) = head $ concat $ findRelative nextMoveIn updatedMaze fromX fromY
        victory = atTheEnd maze fromX fromY

run :: Maze -> Result
run maze =
  if hasStart && hasEnd
  then move maze startX startY
  else if hasStart
  then NoEnd
  else NoStart
  where hasStart = hasOne startPositionIn maze
        hasEnd = hasOne endPositionIn maze
        (_, startX, startY) = head $ concat $ find startPositionIn maze
