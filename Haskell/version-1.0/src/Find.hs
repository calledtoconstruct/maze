module Find (
  find,
  findRelative
) where

import Enumerate
import Types

findInLine :: (MazePosition -> Bool) -> Int -> String -> [MazePosition]
findInLine predicate y line = filter predicate $ map
  (\(x, value) -> (value, (x, y)))
  $ enumerate line

find :: (MazePosition -> Bool) -> Maze -> [[MazePosition]]
find predicate maze = map
  (\(y, line) -> findInLine predicate y line)
  $ enumerate maze

findRelativeInLine :: (RelativeMazePosition -> Bool) -> Position -> Int -> String -> [RelativeMazePosition]
findRelativeInLine next current y line = filter next $ map
  (\(x, value) -> (value, (currentX, currentY), (x, y)))
  $ enumerate line
  where (currentX, currentY) = current

findRelative :: (RelativeMazePosition -> Bool) -> Maze -> Position -> [[RelativeMazePosition]]
findRelative next maze current = map
  (\(y, line) -> findRelativeInLine next current y line)
  $ enumerate maze
