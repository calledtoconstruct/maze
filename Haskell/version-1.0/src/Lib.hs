module Lib ( run ) where

import Enumerate
import Find
import Replace
import Types

import Data.List      (sortBy)
import Data.Function  (on)

startPositionIn :: MazePosition -> Bool
startPositionIn (value, _) = value == 'S'

endPositionIn :: MazePosition -> Bool
endPositionIn (value, _) = value == 'E'

nextMoveIn :: RelativeMazePosition -> Bool
nextMoveIn (value, from, to) = isPathOrEnd && (isHorizontal || isVertical)
  where isVertical = abs(toY - fromY) == 1 && fromX == toX
        isHorizontal = abs(toX - fromX) == 1 && fromY == toY
        isPathOrEnd = value == 'E' || value == ' '
        (fromX, fromY) = from
        (toX, toY) = to

hasOne :: (MazePosition -> Bool) -> Maze -> Bool
hasOne somethingIn maze = (length $ concat $ find somethingIn maze) == 1

hasNext :: Maze -> Position -> Bool
hasNext maze current = (null $ concat $ findRelative nextMoveIn maze current) == False

atTheEnd :: Maze -> Position -> Bool
atTheEnd maze current = endX == currentX && endY == currentY
  where (_, (endX, endY)) = head $ concat $ find endPositionIn maze
        (currentX, currentY) = current

leaveBreadcrumb :: Maze -> Position -> Maze
leaveBreadcrumb maze location = replaceInMaze maze location '*'

extractToPosition :: RelativeMazePosition -> Position
extractToPosition relativeMazePosition = (toX, toY)
  where (_, _, (toX, toY)) = relativeMazePosition

deadEnd :: Result -> Bool
deadEnd result = result /= NoPath

breadcrumbs :: Result -> Int
breadcrumbs (MazeComplete maze) = length $ filter (== '*') $ concat maze

move :: Maze -> Position -> Result
move maze from =
  if victory
    then MazeComplete updatedMaze
    else if failure
      then NoPath
      else head $ optimizedPaths
  where victory = atTheEnd maze from
        updatedMaze = leaveBreadcrumb maze from
        options = concat $ findRelative nextMoveIn updatedMaze from
        paths = move updatedMaze <$> extractToPosition <$> options
        validPaths = filter deadEnd $ paths
        failure = null $ validPaths
        optimizedPaths = sortBy (compare `on` breadcrumbs) $ validPaths

run :: Maze -> Result
run maze =
  if hasStart && hasEnd
  then move maze (startX, startY)
  else if hasStart
  then NoEnd
  else NoStart
  where hasStart = hasOne startPositionIn maze
        hasEnd = hasOne endPositionIn maze
        (_, (startX, startY)) = head $ concat $ find startPositionIn maze
